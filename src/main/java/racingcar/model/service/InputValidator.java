package racingcar.model.service;

public class InputValidator {
    public static final String NATURAL_NUMBER = "\\d+";

    private InputValidator() {
    }

    public static void validateRoundString(String roundString) {
        if (!roundString.matches(NATURAL_NUMBER)) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }

        int roundCountInt = Integer.parseInt(roundString);
        if (roundCountInt <= 0) {
            throw new IllegalArgumentException("시도 횟수는 자연수여야 합니다.");
        }
    }
}
