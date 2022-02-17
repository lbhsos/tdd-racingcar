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
    @DisplayName("자동차는 전진하면 이동거리 필드가 증가한다.")
    void driving_test() {
        //given
        //when
        car.move();
        //then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
