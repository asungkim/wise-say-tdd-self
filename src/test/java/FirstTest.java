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
    @DisplayName("명언 종료")
    void t2() {
        String out = TestBot.run("""
                등록
                명언1
                작가1
                """);

        assertThat(out)
                .contains("명령)");
    }
}