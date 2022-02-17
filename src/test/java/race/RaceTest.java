package race;

import car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaceTest {

    private Race race;

    @BeforeEach
    void setUp() {
        race = new Race();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", ""})
    @DisplayName("자동차 갯수를 잘못 입력하면 예외를 던진다.")
    void Should_ThrowsError_When_IllegalCarCountInput(String givenCarCount) {
        //given
        System.setIn(new ByteArrayInputStream(givenCarCount.getBytes()));
        //when, then
        assertThatThrownBy(() -> race.readCarCount()).isInstanceOf(NumberFormatException.class);}

    @Test
    @DisplayName("자동차 갯수를 입력 받기 전에, 경주 횟수를 입력할 경우 예외를 던진다.")
    void Should_ThrowsError_When_YetInputCarCount() {
        //given
        String givenCarCount = "5";
        System.setIn(new ByteArrayInputStream(givenCarCount.getBytes()));
        //when, then
        assertThatThrownBy(() -> race.readRaceCount()).isInstanceOf(RuntimeException.class).hasMessageContaining("자동차");
    }

    @Test
    @DisplayName("사용자가 입력한 경기 횟수만큼 raceCount를 저장한다.")
    void Should_HaveRacingCount_AsInput() {
        //given
        String givenCarCount = "5";
        System.setIn(new ByteArrayInputStream(givenCarCount.getBytes()));
        race.readCarCount();
        String givenRaceInput = "3";
        int givenAnswer = Integer.parseInt(givenRaceInput);
        System.setIn(new ByteArrayInputStream(givenRaceInput.getBytes()));
        //when
        race.readRaceCount();
        //then
        assertThat(givenAnswer).isEqualTo(race.getRaceCount());
    }


    @Test
    @DisplayName("사용자가 입력한 자동차 수와 Race의 cars 리스트 길이는 같다.")
    void Should_CarsListSize_SameAsInput() {
        String givenInput = "5";
        int givenAnswer = Integer.parseInt(givenInput);
        System.setIn(new ByteArrayInputStream(givenInput.getBytes()));
        race.readCarCount();
        assertThat(givenAnswer).isEqualTo(race.getCars().size());
    }
    @Test
    @DisplayName("이동이 끝나면 우승자 배열에는 한 개 이상의 자동차가 담긴다.")
    void Should_HaveWinners() {
        //given
        String givenCarCount = "5";
        System.setIn(new ByteArrayInputStream(givenCarCount.getBytes()));
        race.readCarCount();
        String givenRaceInput = "3";
        System.setIn(new ByteArrayInputStream(givenRaceInput.getBytes()));
        race.readRaceCount();
        race.start();
        //when
        race.findWinner();
        //then
        int ZERO = 0;
        int FIRST_WINNER = 0;
        List<Car> winners = race.getWinners();
        int max = winners.get(FIRST_WINNER).getDistance();
        assertThat(winners).isNotNull();
        assertThat(winners.size()).isGreaterThan(ZERO);
        assertThat(winners.stream().map(car -> car.getDistance()).collect(Collectors.toList())).containsOnly(max);
    }

    //** 테스트 어려워용 **//
    @Test
    @DisplayName("자동차는 random값이 4이상이면 전진한다.")
    void random_moving_test(){
        //given
        //when
        //then
    }

    @Test
    @DisplayName("자동차는 random값이 4미만이면 전진하지않는다.")
    void random_not_moving_test(){
        //given
        //when
        //then
    }
}
