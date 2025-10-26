package racingcar.model.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"helloworld", "안녕하세요hi", "he  ll"})
    void 예외_이름_5자_초과(String lengthExceededName) {
        assertThatThrownBy(() -> new Car(lengthExceededName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void 예외_이름_공백(String blankName) {
        assertThatThrownBy(() -> new Car(blankName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_초기_위치_0() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차_한_라운드_후_위치() {
        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isBetween(0, 1);
    }
}