package racingcar.views;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class InputValidator {

    public boolean validateCarNames(String input){
        List<Consumer<String>> validateList = new ArrayList<>();
        validateList.add(this::validateCarNameLength);
        validateList.add(this::validateNotHaveOtherSeparator);
        return validateResult(validateList, input);
    }

    public boolean validateTryingCount(String input){
        List<Consumer<String>> validateList = new ArrayList<>();
        validateList.add(this::validateInputAsInteger);
        return validateResult(validateList, input);
    }

    public boolean validateResult(List<Consumer<String>> validateList, String input){
        try{
            for (Consumer<String> stringConsumer : validateList) {
                stringConsumer.accept(input);
            }
            return true;
        }catch(IllegalArgumentException ex){
            return false;
        }
    }

    public void validateCarNameLength(String input){
        String[] carNames = input.split(",");
        for(String carName : carNames){
            if(carName.length() > 5){
                String errorMessage = "[ERROR] 차의 이름 길이는 5자 이하로만 입력 가능합니다.";
                errorProcess(errorMessage);
            }
        }
    }

    public void validateNotHaveOtherSeparator(String input){
        String[] carNames = input.split(",");
        for(String carName : carNames){
            if(!Pattern.matches("^[a-zA-Z0-9]*$",carName)){
                String errorMessage = "[ERROR] 자동차의 이름 입력에는 오직 숫자와 문자, 그리고 콤마(,) 만 입력할 수 있습니다.";
                errorProcess(errorMessage);
            }
        }
    }

    public void validateInputAsInteger(String input){
        try{
            int number = Integer.parseInt(input);
            if(number < 0){
                throw new NullPointerException();
            }
        }catch (NumberFormatException ex){
            String errorMessage = "[ERROR] 경기 횟수는 자연수만 입력할 수 있습니다.";
            errorProcess(errorMessage);
        }
    }

    private void errorProcess(String errorMessage){
        OutputFeature.printStatement(errorMessage);
        throw new IllegalArgumentException();
    }
}
