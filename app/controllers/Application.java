package controllers;

import models.Game;
import models.InputParser;
import models.InputValidator;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.List;

public class Application extends Controller {
    static Game game = new Game();
    static List<String> hintsList = new ArrayList<String>();

    public static void index() {
        Game gameVO = game;
        List<String> hints = hintsList;
        render(gameVO, hints);
    }

    public static void guess(@Required String guess) {
        try {
            InputValidator.validate(guess);
        } catch (InputValidator.ValidationException e) {
            Validation.addError("Guess", "Invalid guess");
        }

        if(validation.hasErrors()) {
            flash.error(
                    "Wrong guess!\n" +
                    "It should consist of 4 integers in 0 to 5 range, e.g.: 1122");
            index();
        }
        int[] answer = game.guess(InputParser.parse(guess));
        hintsList.add(String.format(
                "Your guess: %s\n" +
                "wellplaced: %d misplaced: %d", guess, answer[0], answer[1]));
        index();
    }

    public static void restart() {
        game = new Game();
        hintsList = new ArrayList<String>();
        index();
    }

}