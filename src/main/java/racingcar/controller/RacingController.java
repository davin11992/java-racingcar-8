package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.domain.Cars;
import racingcar.model.service.InputValidator;
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

        String roundString = inputView.readSecondLine().trim();
        InputValidator.validateRoundString(roundString);

        outputView.showResultHeader();
        startRace(Integer.parseInt(roundString), cars);
        outputView.showWinners(winnerCalculator.findWinners(cars.getCars()));
    }

    private void startRace(int roundCountInt, Cars cars) {
        for (int i = 0; i < roundCountInt; i++) {
            outputView.showRoundResult(cars.moveAll());
        }
    }

    private List<String> parseInputNames(String inputNames) {
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }
}
