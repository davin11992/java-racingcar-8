package racingcar.view;

import java.util.List;
import racingcar.model.domain.Car;

public class OutputView {
    public void showResultHeader() {
        System.out.println("\n실행 결과");
    }

    public void showRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void showWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
