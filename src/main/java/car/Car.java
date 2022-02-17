package car;

public class Car implements Comparable<Car> {

    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;
    private int distance = 0;

    public int getRandomNumber() {
        return (int) (Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1)) + MIN_RANDOM_NUMBER;
    }

    public void move() {
        this.distance += 1;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Car o) {
        return o.getDistance() - getDistance();
    }
}
