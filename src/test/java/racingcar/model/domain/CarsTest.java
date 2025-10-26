package racingcar.model.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    public static final int MOVING_FORWARD = 4;

    @Test
    void 이름_리스트로_Cars_생성() {
        List<String> names = List.of("pobi", "woni", "davin");
        Cars cars = new Cars(names);

        assertThat(cars.getCars()).hasSize(3);
        assertThat(cars.getCars())
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "davin");
    }

    @Test
    void 랜덤이_4가_들어오면_모든_차_전진() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = new Cars(List.of("pobi", "woni"));
            List<Car> moved = cars.moveAll();

            assertThat(moved)
                    .allSatisfy(car -> assertThat(car.getPosition()).isEqualTo(1));
        }, MOVING_FORWARD, MOVING_FORWARD);
    }
}