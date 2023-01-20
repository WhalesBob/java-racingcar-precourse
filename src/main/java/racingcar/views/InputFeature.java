package racingcar.views;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class InputFeature {
    private final InputValidator validator = new InputValidator();

    public List<String> getCarNames(){
        String userInput = inputTemplate(validator::validateCarNames);
        return Arrays.asList(userInput.split(","));
    }

    public int getTryingCount(){
        String userInput = inputTemplate(validator::validateTryingCount);
        return Integer.parseInt(userInput);
    }

    private String inputTemplate(Predicate<String> validateFunction){
        boolean isRightInput;
        String input;
        do{
            input = Console.readLine();
            isRightInput = validateFunction.test(input);
        }while(!isRightInput);
        return input;
    }
}
