package question.everything;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import static question.everything.CliColor.*;


public class CliColorTests {

//    @Test
//    public void should_start_with_a_buffer() {
//        CliColor cc = new CliColor();
//
//        assertThat(cc.getBuffer(), notNullValue());
//    }
//
//    @Test
//    public void should_start_with_esc() {
//        CliColor cc = new CliColor();
//        cc.red("a");
//
//        StringBuffer actual = cc.getBuffer();
//
//        char[] expected = new StringBuffer()
//            .append(ESC).append(Red).append('a').append(ESC).append(ClearFg)
//            .toString()
//            .toCharArray();
//
//        compareChars(actual, 0, ESC, '[', '3', '1', 'm', 'a', ESC, '[', '3', '9', 'm');
//        compareChars(actual, 0, expected);
//    }
//
//    public void compareChars(StringBuffer buff, int start, char... chars) {
//
//        for (int i = 0; i < chars.length && (start + i) < buff.length(); i++) {
//            char c = buff.charAt(start + i);
//            assertThat("index: " + i, c, is(chars[i]));
//        }
//    }
}
