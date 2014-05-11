package question.everything;

import java.io.PrintStream;

public abstract class AbstractEsc {

    public static final char ESC = '\u001b';

    public abstract AbstractEsc apply(PrintStream out, String... args);

    public char[] add(char[] a, char[] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException("Neither array can be null");
        }
        char[] rv = new char[a.length + b.length];
        int i = 0;
        for (char c : a) { rv[i] = c; i++; }
        for (char c : b) { rv[i] = c; i++; }
        return rv;
    }
}
