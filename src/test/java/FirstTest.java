import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FirstTest {

    @Test
    void t1() {
        assertThat(1).isEqualTo(1);
    }

}