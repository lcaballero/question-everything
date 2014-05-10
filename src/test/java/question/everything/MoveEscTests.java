package question.everything;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MoveEscTests {

    @Test
    public void toEscape_should_not_produce_values_for_0() {
        String esc = MoveEsc.toEscape(0, 0);
        assertThat(esc, notNullValue());
        assertThat(esc, is(""));
    }

    @Test
    public void toEscape_should_not_include_digit_1_values_for_up() {
        String esc = MoveEsc.toEscape(0, 1);
        assertThat(esc, notNullValue());
        assertThat(esc, is("\u001b[a"));
    }

    @Test
    public void toEscape_should_not_include_digit_1_values_for_down() {
        String esc = MoveEsc.toEscape(0, -1);
        assertThat(esc, notNullValue());
        assertThat(esc, is("\u001b[b"));
    }

    @Test
    public void toEscape_should_not_include_digit_1_values_for_right() {
        String esc = MoveEsc.toEscape(1, 0);
        assertThat(esc, notNullValue());
        assertThat(esc, is("\u001b[c"));
    }

    @Test
    public void toEscape_should_not_include_digit_1_values_for_left() {
        String esc = MoveEsc.toEscape(-1, 0);
        assertThat(esc, notNullValue());
        assertThat(esc, is("\u001b[d"));
    }

    @Test
    public void toEscape_should_include_control_letter_up() {
        String esc = MoveEsc.toEscape(1, MoveEsc.UP);
        assertThat(esc, containsString(String.valueOf(MoveEsc.UP)));
    }

    @Test
    public void toEscape_should_include_control_letter_down() {
        String esc = MoveEsc.toEscapes(-2, MoveEsc.DOWN);
        assertThat(esc, containsString(String.valueOf(MoveEsc.DOWN)));
    }

    @Test
    public void toEscape_should_include_control_letter_left() {
        String esc = MoveEsc.toEscapes(1, MoveEsc.LEFT);
        assertThat(esc, containsString(String.valueOf(MoveEsc.LEFT)));
    }

    @Test
    public void toEscape_should_include_control_letter_right() {
        String esc = MoveEsc.toEscapes(1, MoveEsc.RIGHT);
        assertThat(esc, containsString(String.valueOf(MoveEsc.RIGHT)));
    }

    @Test (expected = IllegalArgumentException.class)
    public void toEscape_should_throw_exception_if_not_a_valid_control_character() {
        String esc = MoveEsc.toEscapes(1, 'p');
    }

    @Test
    public void isDirChar_should_accept_one_of_the_move_accept_chars() {
        char[] chars = new char[] {
            MoveEsc.UP,
            MoveEsc.DOWN,
            MoveEsc.LEFT,
            MoveEsc.RIGHT
        };

        for (char c : chars) {
            assertThat(MoveEsc.isDirChar(c), is(true));
        }
    }

    @Test
    public void isDirChar_should_not_accept_a_non_move_char() {
        char[] chars = new char[] {
            MoveEsc.UP + 12,
            MoveEsc.DOWN + 12,
            MoveEsc.LEFT + 12,
            MoveEsc.RIGHT + 12
        };

        for (char c : chars) {
            assertThat(MoveEsc.isDirChar(c), is(false));
        }
    }

    @Test
    public void move_escapes_with_equal_x_and_y_should_have_the_same_hash_code() {
        MoveEsc a = new MoveEsc(2,3);
        MoveEsc b = new MoveEsc(2,3);

        assertThat(a.hashCode(), is(b.hashCode()));
    }

    @Test
    public void two_move_escapes_with_different_x_and_y_should_not_have_the_same_hash_code() {
        MoveEsc a = new MoveEsc(2,3);
        MoveEsc b = new MoveEsc(a.getX() + 1, a.getY() + 1);

        assertThat(a.hashCode(), not(b.hashCode()));
    }

    @Test
    public void add_should_produce_new_move_esc() {
        MoveEsc a = new MoveEsc(2,3);
        MoveEsc b = a.add(new MoveEsc(1,1));

        assertThat(a == b, is(false));
    }
}
