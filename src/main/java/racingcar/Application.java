package racingcar;

import racingcar.views.InputFeature;
import racingcar.views.OutputFeature;

public class Application {
    public static void main(String[] args) {
        OutputFeature output = new OutputFeature();
        InputFeature input = new InputFeature();
        CarRacingGame mainGame = new CarRacingGame(input,output);
        mainGame.playGame();
    }
}
