package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    public static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수_양끝공백_허용() {
        assertRandomNumberInRangeTest(() -> {
            run("pobi,woni", "   2   ");
            assertThat(output()).contains("실행 결과");
        }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD); // 2대 × 3라운드 = 6회 난수
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,  ,woni", "pobi,,woni", ""})
    void 예외_자동차_이름이_없거나_공백(String inputNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(inputNames, "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"hi", "안녕", " ", "   "})
    void 예외_시도횟수가_숫자가_아닌_경우(String wrongRoundCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", wrongRoundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다.")
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void 예외_시도횟수가_0_이하(String wrongRoundCount) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", wrongRoundCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("시도 횟수는 1 이상의 정수여야 합니다.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
