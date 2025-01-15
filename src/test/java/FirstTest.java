import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FirstTest {

    @Test
    void t1() {
        assertThat(1).isEqualTo(1);
    }

    @Test
    @DisplayName("명령에 종료를 입력하면 종료")
    void t2() {
        String out = TestBot.run("");

        assertThat(out)
                .contains("명령)")
                .contains("프로그램을 종료합니다");

    }


    @Test
    @DisplayName("앱 시작시 '== 명언 앱 ==' 출력")
    void t3() {
        String out = TestBot.run("");


        assertThat(out)
                .containsSubsequence("== 명언 앱 ==", "프로그램을 종료합니다");
    }

    @Test
    @DisplayName("등록 - 명언 1개 입력(2단계)")
    void t4() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자 미상
                """);

        assertThat(out)
                .containsSubsequence("명언 : ", "작가 : ");
    }

    @Test
    @DisplayName("등록시 명언번호 출력(3단계)")
    void t5() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자 미상
                """);

        assertThat(out)
                .contains("1번 명언이 등록되었습니다.");

    }

    @Test
    @DisplayName("등록시 명언번호 출력(4단계)")
    void t6() {
        String out = TestBot.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(out)
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.");
    }
}