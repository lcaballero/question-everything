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

    @Test (expected = IllegalArgumentException.class)
    public void add_should_throw_exception_when_null_and_non_null_is_used_for_add() {
        SpanEsc none = Colors.none;
        none.add(null, new char[0]);
    }

    @Test (expected = IllegalArgumentException.class)
    public void add_should_throw_exception_when_null_and_null_is_used_for_add() {
        SpanEsc none = Colors.none;
        none.add(null, null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void add_should_throw_exception_when_non_null_and_null_is_used_for_add() {
        SpanEsc none = Colors.none;
        none.add(new char[0], null);
    }

    @Test
    public void add_should_concat_chars() {
        SpanEsc none = Colors.none;

        String a = "hello";
        String b = "world";

        char[] hello = a.toCharArray();
        char[] world = b.toCharArray();

        String actual = new String(none.add(hello, world));
        String expected = a + b;

        assertThat(actual, is(expected));
    }
}
