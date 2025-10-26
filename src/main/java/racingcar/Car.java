package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int NAME_MAX_LENGTH = 5;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
