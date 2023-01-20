package racingcar;

import racingcar.views.InputFeature;
import racingcar.views.OutputFeature;

import java.util.List;
import java.util.stream.Collectors;

public class CarRacingGame {

    private final InputFeature input;
    private final OutputFeature output;

    public CarRacingGame(InputFeature input, OutputFeature output) {
        this.input = input;
        this.output = output;
    }

    public void playGame(){
        output.requestCarNames();
        List<String> carNames = input.getCarNames();
        output.requestHowManyDo();
        int gameCount = input.getTryingCount();

        List<Car> cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        race(cars,gameCount);
    }
    public void race(List<Car> cars, int gameCount){
        output.printMessageBeforeResult();
        for(int game = 0; game < gameCount; game++){
            Car.runAll(cars, output);
            System.out.println("");
        }
        List<String> winnerList = Car.getWinner(cars);
        output.printFinalResult(winnerList);
    }
}
