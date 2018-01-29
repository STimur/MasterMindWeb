$(document).ready(function () {
    $("#error").hide();
    $("#restartButton").hide();
    $("#gameFinished").hide();

    $("#guessButton").click(function () {
        $.get("/guess", {guess: $('#guess').val()},
            function (gameViewModel) {
                if (!gameViewModel.isValid) {
                    $('#error').show();
                } else {
                    $('#error').hide();
                    $('#hints').append("<p class='mt-3'>" + gameViewModel.hint + "</p>");
                }
                if (!gameViewModel.isFinished) {
                    $('#guess').val('');
                    $('#guess').focus();
                    $('#guess').show();
                    $('#guessButton').show();
                    $('#restartButton').hide();
                    $('#gameInProgress').show();
                    $('#gameFinished').hide();
                } else {
                    $('#guess').focusout();
                    $('#guess').hide();
                    $('#guessButton').hide();
                    $('#restartButton').show();
                    $('#restartButton').focus();
                    $('#gameInProgress').hide();
                    $('#gameFinished').show();
                }
            }, "json");
    });

    $("#restartButton").click(function () {
        $.get("/restart", function () {
            $('#guess').val('');
            $('#guess').show();
            $('#guess').focus();
            $('#guessButton').show();
            $('#restartButton').hide();
            $('#hints').empty();
            $('#gameInProgress').show();
            $('#gameFinished').hide();
        });
    });

    $("#guess").keyup(function (event) {
        if (event.keyCode === 13) {
            $("#guessButton").click();
        }
    });
})