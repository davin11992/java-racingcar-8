package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.domain.Cars;
import racingcar.model.service.WinnerCalculator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final WinnerCalculator winnerCalculator;

    public RacingController(InputView inputView, OutputView outputView, WinnerCalculator winnerCalculator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.winnerCalculator = winnerCalculator;
    }

    public void run() {
        String inputNames = inputView.readFirstLine();
        Cars cars = new Cars(parseInputNames(inputNames));

        String roundString = inputView.readSecondLine();
        if (roundString == null || roundString.trim().isEmpty() || !roundString.trim().matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }
        int roundInt = Integer.parseInt(roundString.trim());
        if (roundInt <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        outputView.showExecutionResult();
        for (int i = 0; i < roundInt; i++) {
            outputView.showRoundResult(cars.moveAll());
        }
        outputView.showWinners(winnerCalculator.findWinners(cars.getCars()));
    }

    private static List<String> parseInputNames(String inputNames) {
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }
}
