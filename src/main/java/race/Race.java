package race;

import car.Car;

import java.util.*;

public class Race {

    private static final String NUMBER_FORMAT_EXCEPTION_MESSAGE = "올바른 숫자를 입력해주세요.";
    private static final String CAR_COUNT_REQUIRED_EXCEPTION_MESSAGE = "올바른 자동차 갯수를 먼저 입력해주세요.";
    private static final int MOVING_MIN_CONDITION_NUMBER = 4;
    private int raceCount;
    private List<Car> cars;
    private List<Car> winners;
    Scanner scan;

    public void start() {
        for (int j=0; j<raceCount; j++) {
            doRace();
        }
    }

    public void doRace() {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            int randomNumber = car.getRandomNumber();
            moveIfPassCondition(randomNumber, car);
        }
    }

    public void findWinner() {
        Collections.sort(cars);
        winners = new ArrayList<>();
        makeWinnerList();
    }

    public void readCarCount() {
        scan = new Scanner(System.in);
        try {
            int carCount = Integer.parseInt(scan.next());
            createCarList(carCount);
        } catch ( NoSuchElementException | NumberFormatException e) {
            throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    public void readRaceCount() {
        scan = new Scanner(System.in);
        this.raceCount = Integer.parseInt(scan.next());
        if (Objects.isNull(cars)) {
            throw new RuntimeException(CAR_COUNT_REQUIRED_EXCEPTION_MESSAGE);
        }
    }

    public int getRaceCount() {
        return raceCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
    }

    private void moveIfPassCondition(int randomNumber, Car car){
        if (randomNumber >= MOVING_MIN_CONDITION_NUMBER) {
            car.move();
        }
    }

    private void makeWinnerList(){
        int prevMax = 0;
        for (Car car: cars) {
            prevMax = compareDistance(prevMax, car);
        }
    }

    private int compareDistance(int prevMax, Car car){
        if (prevMax <= car.getDistance()) {
            winners.add(car);
            return car.getDistance();
        }
        return prevMax;
    }

    private void createCarList(int carCount) {
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }
}
