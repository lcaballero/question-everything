package question.everything;

import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;


public class CliColorTests {

    @Test
    public void should_start_with_none_active_color() {
        CliColor cc = new CliColor();
        assertThat(cc.getActiveColor(), notNullValue());
    }
}
