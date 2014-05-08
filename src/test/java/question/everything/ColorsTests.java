package question.everything;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ColorsTests {

    @Test
    public void the_color_none_should_be_equal_to_itself() {
        assertThat(Colors.none.equals(Colors.none), is(true));
    }

    @Test
    public void should_have_styles_list_initialized() {
        assertThat(Colors.AllStyles, notNullValue());
        assertThat(Colors.AllStyles.size(), greaterThan(0));
    }

    @Test
    public void should_have_colors_initialized() {
        assertThat(Colors.AllColors, notNullValue());
        assertThat(Colors.AllColors.size(), greaterThan(0));
    }

    @Test
    public void should_have_all_escapes_list_initialized_and_sum_of_other_lists() {
        assertThat(Colors.AllEscapes, notNullValue());
        assertThat(Colors.AllEscapes.size(), is(Colors.AllColors.size() + Colors.AllStyles.size()));
    }

    @Test
    public void should_find_all_escapes_have_unique_names() {
        Set<String> names = new HashSet<String>();
        for (ColorEsc c : Colors.AllEscapes) {
            names.add(c.getName());
        }
        assertThat(names.size(), is(Colors.AllEscapes.size()));
    }

    @Test
    public void should_find_all_escapes_have_unique_hash_codes() {
        Set<ColorEsc> names = new HashSet<>();
        for (ColorEsc c : Colors.AllEscapes) {
            names.add(c);
        }
        assertThat(names.size(), is(Colors.AllEscapes.size()));
    }

    @Test
    public void should_find_all_styles_in_all_styles_set() {

        assertTrue(Colors.AllStyles.contains(Colors.bold));
        assertTrue(Colors.AllStyles.contains(Colors.italic));
        assertTrue(Colors.AllStyles.contains(Colors.underline));
        assertTrue(Colors.AllStyles.contains(Colors.blink));
        assertTrue(Colors.AllStyles.contains(Colors.inverse));
        assertTrue(Colors.AllStyles.contains(Colors.strike));
    }

    @Test
    public void should_find_all_colors_in_all_colors_set() {

        assertTrue(Colors.AllColors.contains(Colors.black));
        assertTrue(Colors.AllColors.contains(Colors.red));
        assertTrue(Colors.AllColors.contains(Colors.green));
        assertTrue(Colors.AllColors.contains(Colors.yellow));
        assertTrue(Colors.AllColors.contains(Colors.blue));
        assertTrue(Colors.AllColors.contains(Colors.magenta));
        assertTrue(Colors.AllColors.contains(Colors.cyan));
        assertTrue(Colors.AllColors.contains(Colors.white));

        assertTrue(Colors.AllColors.contains(Colors.blackBg));
        assertTrue(Colors.AllColors.contains(Colors.redBg));
        assertTrue(Colors.AllColors.contains(Colors.greenBg));
        assertTrue(Colors.AllColors.contains(Colors.yellowBg));
        assertTrue(Colors.AllColors.contains(Colors.blueBg));
        assertTrue(Colors.AllColors.contains(Colors.magentaBg));
        assertTrue(Colors.AllColors.contains(Colors.cyanBg));
        assertTrue(Colors.AllColors.contains(Colors.whiteBg));

        assertTrue(Colors.AllColors.contains(Colors.blackBright));
        assertTrue(Colors.AllColors.contains(Colors.redBright));
        assertTrue(Colors.AllColors.contains(Colors.greenBright));
        assertTrue(Colors.AllColors.contains(Colors.yellowBright));
        assertTrue(Colors.AllColors.contains(Colors.blueBright));
        assertTrue(Colors.AllColors.contains(Colors.magentaBright));
        assertTrue(Colors.AllColors.contains(Colors.cyanBright));
        assertTrue(Colors.AllColors.contains(Colors.whiteBright));

        assertTrue(Colors.AllColors.contains(Colors.blackBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.redBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.greenBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.yellowBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.blueBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.magentaBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.cyanBrightBg));
        assertTrue(Colors.AllColors.contains(Colors.whiteBrightBg));
    }
}
