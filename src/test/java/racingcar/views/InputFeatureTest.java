package racingcar.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;

class InputFeatureTest {

    private final InputFeature inputFeature = new InputFeature();
    private static final String ERROR_MESSAGE = "[ERROR]";

    OutputStream out;
    InputStream in;

    void beforeSetting(String input){
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    void getExceptionTest(Supplier<?> testFunction){
        try{
            testFunction.get();
        }catch(NoSuchElementException ignored){}
        assertThat(out.toString().trim()).contains(ERROR_MESSAGE);
    }

    @Nested
    class GetCarNamesTest{

        void getCarNameTest(String input){
            beforeSetting(input);
            List<String> output = Arrays.asList(input.split(","));
            assertThat(inputFeature.getCarNames()).isEqualTo(output);
        }

        @DisplayName("정상 동작 - 새로운 방법으로 차 이름을 잘 받는지 확인하기")
        @Test
        void getCarName_1(){
            String input = "pobi,woni,jun";
            getCarNameTest(input);
        }
    }

    @Nested
    class GetTryingCountTest{

        void getTryingCountTest(String input){
            beforeSetting(input);
            int output = Integer.parseInt(input);
            assertThat(inputFeature.getTryingCount()).isEqualTo(output);
        }

        @DisplayName("정상 동작 - 새로운 방법으로 숫자를 잘 받는지 확인하기")
        @Test
        void getTryingCount_1(){
            String input = "1";
            getTryingCountTest(input);
        }
    }




}