package question.everything;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ColorEscTests {

    @Test
    public void two_colors_with_same_name_and_escapes_should_be_equal() {
        SpanEsc a = new SpanEsc("red", 31, 39);
        SpanEsc b = new SpanEsc("red", 31, 39);

        assertThat(a.equals(b), is(true));
    }

    @Test
    public void two_colors_with_same_name_and_escapes_should_have_same_hash_code() {
        SpanEsc a = new SpanEsc("red", 31, 39);
        SpanEsc b = new SpanEsc("red", 31, 39);

        assertThat(a.hashCode(), is(b.hashCode()));
    }
}
