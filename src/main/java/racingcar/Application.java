package racingcar;

import racingcar.controller.RacingController;
import racingcar.model.service.WinnerCalculator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        WinnerCalculator winnerCalculator = new WinnerCalculator();

        RacingController racingController = new RacingController(inputView, outputView, winnerCalculator);

        racingController.run();
    }
}