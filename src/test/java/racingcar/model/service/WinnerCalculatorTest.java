package racingcar.model.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.model.domain.Car;

class WinnerCalculatorTest {
    public static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 단독_우승() {
        assertRandomNumberInRangeTest(() -> {
            Car pobi = new Car("pobi");
            Car woni = new Car("woni");

            // pobi만 3칸 이동해서 우승
            for (int moveCount = 0; moveCount < 3; moveCount++) {
                pobi.move();
            }

            WinnerCalculator winnerCalculator = new WinnerCalculator();
            List<String> winners = winnerCalculator.findWinners(List.of(pobi, woni));

            assertThat(winners).containsExactly("pobi");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP, STOP);
    }

    @Test
    void 공동_우승() {
        assertRandomNumberInRangeTest(() -> {
            Car pobi = new Car("pobi");
            Car woni = new Car("woni");

            // pobi, woni 모두 1칸 이동하여 공동우승
            pobi.move();
            woni.move();

            WinnerCalculator wc = new WinnerCalculator();
            List<String> winners = wc.findWinners(List.of(pobi, woni));

            assertThat(winners).containsExactlyInAnyOrder("pobi", "woni");
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 예외_빈_리스트() {
        WinnerCalculator winnerCalculator = new WinnerCalculator();
        assertThatThrownBy(() -> winnerCalculator.findWinners(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 목록이 비어 있습니다.");
    }
}