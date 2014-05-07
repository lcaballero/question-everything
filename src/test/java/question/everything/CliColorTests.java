package question.everything;

import org.junit.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class CliColorTests {

    @Test
    public void should_start_with_none_active_color() {
        CliColor cc = new CliColor();
        assertThat(cc.getActiveColor(), notNullValue());
    }

    @Test
    public void should_change_active_color_when_building() {
        CliColor cc = new CliColor();
        ColorEsc a = cc.getActiveColor();
        cc = cc.red();
        ColorEsc b = cc.getActiveColor();

        assertThat(a != b, is(true));
        assertThat(a.hashCode(), not(b.hashCode()));
        assertThat(a.getName(), not(b.getName()));
    }

    @Test
    public void should_create_new_cli_color_each_transition() {
        CliColor a = new CliColor();
        CliColor b = a.red();
        CliColor c = b.underline();

        assertThat(a != b, is(true));
        assertThat(b != c, is(true));
    }

    @Test (expected = IllegalArgumentException.class)
    public void esc_should_throw_exception_for_unfound_color_string() {
        CliColor a = new CliColor();
        a.esc("not a color at all");
    }

    @Test
    public void should_be_able_to_call_all_color_methods() {
        CliColor c = new CliColor();

        c.black().red().green().yellow().blue().magenta().cyan().white();

        c.blackBright().redBright().greenBright().yellowBright().blueBright()
            .magentaBright().cyanBright().whiteBright();

        c.blackBg().redBg().greenBg().yellowBg().blueBg().magentaBg().cyanBg().whiteBg();

        c.blackBrightBg().redBrightBg().greenBrightBg().yellowBrightBg()
            .blueBrightBg().magentaBrightBg().cyanBrightBg().whiteBrightBg();

        c.bold().italic().underline().blink().inverse().strike();
    }
}
