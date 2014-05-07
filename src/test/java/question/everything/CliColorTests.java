package question.everything;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThan;

import org.junit.Test;

import java.util.HashMap;


public class CliColorTests {

    @Test
    public void should_start_with_none_active_color() {
        CliColor cc = new CliColor();
        assertThat(cc.getActiveColor(), notNullValue());
    }
}
