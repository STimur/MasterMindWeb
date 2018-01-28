package controllers;

import domain.Game;
import domain.InputParser;
import domain.InputValidator;
import groovy.json.JsonOutput;
import play.cache.Cache;
import play.data.validation.Required;
import play.mvc.Controller;
import viewmodels.GameViewModel;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {

    public static void index() {
        Game game = Cache.get("Game" + session.getId(), Game.class);
        if (game == null) {
            game = new Game();
            Cache.set("Game" + session.getId(), game);
        }

        List<String> hints = Cache.get("Hints" + session.getId(), List.class);
        if (hints == null) {
            hints = new ArrayList<>();
            Cache.set("Hints" + session.getId(), hints);
        }

        render(game, hints);
    }

    public static void guess(@Required String guess) {
        GameViewModel gameViewModel = new GameViewModel();
        try {
            InputValidator.validate(guess);
        } catch (InputValidator.ValidationException e) {
            gameViewModel.isValid = false;
        }

        if (!gameViewModel.isValid)
            //"Wrong guess!\n" + "It should consist of 4 integers in 0 to 5 range, e.g.: 1122";
            renderJSON(gameViewModel);

        Game game = Cache.get("Game" + session.getId(), Game.class);
        int[] answer = game.guess(InputParser.parse(guess));

        if (game.isFinished)
            gameViewModel.isFinished = game.isFinished;

        List<String> hints = Cache.get("Hints" + session.getId(), List.class);

        gameViewModel.hint = String.format(
                "Your guess: %s\n" +
                "wellplaced: %d misplaced: %d", guess, answer[0], answer[1]);


        hints.add(gameViewModel.hint);

        renderJSON(JsonOutput.toJson(gameViewModel));
    }

    public static void restart() {
        Cache.set("Game" + session.getId(), new Game());
        Cache.set("Hints" + session.getId(), new ArrayList<>());
    }

}