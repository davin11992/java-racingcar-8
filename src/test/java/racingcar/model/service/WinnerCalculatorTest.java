package racingcar.model.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class WinnerCalculatorTest {

    @Test
    void 단독_우승() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        // pobi만 3칸 이동해서 우승
        for (int i = 0; i < 3; i++) {
            pobi.move();
        }

        WinnerCalculator winnerCalculator = new WinnerCalculator();
        List<String> winners = winnerCalculator.findWinners(List.of(pobi, woni));

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    void 공동_우승() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");

        // pobi, woni 모두 1칸 이동하여 공동 우승
        pobi.move();
        woni.move();

        WinnerCalculator winnerCalculator = new WinnerCalculator();
        List<String> winners = winnerCalculator.findWinners(List.of(pobi, woni));

        assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
    }

    @Test
    void 예외_빈_리스트() {
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        assertThatThrownBy(() -> winnerCalculator.findWinners(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 목록이 비어 있습니다.");
    }
}