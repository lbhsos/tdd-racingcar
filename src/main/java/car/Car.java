package car;

public class Car {

    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;
    private final int MOVING_MIN_NUMBER = 4;
    int movingCount = 0;
    int randomNumber = 0;
    int distance = 0;

    public void race() {
        this.randomNumber = getRandomNumber();
        if (randomNumber < MOVING_MIN_NUMBER) {
            return;
        }
        move();
    }

    private int getRandomNumber() {
        this.movingCount += movingCount + 1;
        return (int) (Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1)) + MIN_RANDOM_NUMBER;
    }

    public void move() {
        this.distance += 1;
    }
}
