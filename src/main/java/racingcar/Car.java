package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.views.OutputFeature;

import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    private void run(){
        boolean canCarGo = Randoms.pickNumberInRange(0,9) >= 4;
        if(canCarGo){
            this.position++;
        }
    }

    public static void runAll(List<Car> cars, OutputFeature output){
        for(Car car : cars){
            car.run();
            output.printResultInProcess(car.name, car.position);
        }
    }

    public static List<String> getWinner(List<Car> cars){
        int maxPosition = cars.stream().mapToInt(x->x.position).max().getAsInt();
        return cars.stream()
                .filter(car->car.position == maxPosition)
                .map(car->car.name).collect(Collectors.toList());
    }

    // 추가 기능 구현
}
