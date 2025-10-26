package racingcar.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = createCars(names);
    }

    private List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> moveAll() {
        for (Car car : cars) {
            car.move();
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
