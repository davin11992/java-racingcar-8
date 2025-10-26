package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputNames = Console.readLine();

        List<String> names = nameParse(inputNames);
        List<Car> cars = createCars(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfRounds = Integer.parseInt(Console.readLine());

        System.out.println("실행 결과");
    }

    private static List<String> nameParse(String inputNames) {
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }

    private static List<Car> createCars(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

}
