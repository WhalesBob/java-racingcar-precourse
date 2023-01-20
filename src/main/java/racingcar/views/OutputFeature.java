package racingcar.views;

import java.util.List;

public class OutputFeature {

    public void requestCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requestHowManyDo(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printMessageBeforeResult(){
        System.out.println("실행 결과");
    }

    public void printResultInProcess(String carName, int position){
        StringBuilder resultBuilder = new StringBuilder();
        for(int resultIndex = 0; resultIndex < position; resultIndex++){
            resultBuilder.append("-");
        }
        System.out.println(carName + " : " + resultBuilder);
    }

    public void printFinalResult(List<String> winnerList){
        System.out.print("최종 우승자 : " + String.join(", ",winnerList));
    }

    public static void printStatement(String message){
        System.out.println(message);
    }
}
