package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    private Car car;
    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차는 race 수행마다 이동횟수 필드가 증가한다.")
    void increase_moving_count_test() {
        // given
        // when
        car.race();
        // then
        assertThat(car.movingCount).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 전진하면 이동거리 필드가 증가한다.")
    void driving_test() {
        //given
        //when
        car.move();
        //then
        assertThat(car.distance).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 random값이 4이상이면 전진한다.")
    void random_moving_test(){
        //given
        //when
        while (car.randomNumber<4) {
            car.race();
        }
        //then
        assertThat(car.distance).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 random값이 4미만이면 전진하지않는다.")
    void random_not_moving_test(){
        //given
        //when
        while (car.randomNumber>=4) {
            car.race();
        }
        //then
        assertThat(car.distance).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 random값이 0-9가 아니면 예외를 던진다.")
    void random_value_exception_test(){

    }
}
