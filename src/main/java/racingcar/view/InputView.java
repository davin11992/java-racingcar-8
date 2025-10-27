package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readFirstLine() {
        return readInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)", "자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    public String readSecondLine() {
        return readInput("시도할 횟수는 몇 회인가요?", "시도 횟수는 자연수여야 합니다.");
    }

    private String readInput(String promptMessage, String errorMessage) {
        System.out.println(promptMessage);
        String input = Console.readLine();
        validateNotNull(input, errorMessage);
        return input;
    }

    private void validateNotNull(String input, String errorMessage) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
