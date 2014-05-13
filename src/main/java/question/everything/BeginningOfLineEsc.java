package question.everything;

import com.google.common.base.Strings;


public class BeginningOfLineEsc extends AbstractEsc {

    public static final char UPWARD = 'E';
    public static final char DOWNWARD = 'F';

    private int lines;
    private boolean isClearingLines;

    public BeginningOfLineEsc(int n, boolean isClearingLines) {
        this.lines = n;
        this.isClearingLines = isClearingLines;
    }

    public String toCloseEsc(int n, char dir) {
        return String.format("%s[%d%s", ESC, n, dir);
    }

    public int toLineCount(int n) {
        n = n < 0 ? -n : n;
        return n;
    }

    public char toDirection(int n) {
        return (n >= 0) ? UPWARD : DOWNWARD;
    }

    @Override
    public String surround(String... args) {
        throw new UnsupportedOperationException("surround() is not supported by " + this.getClass().getName());
    }

    @Override
    public String apply() {
        if (this.isClearingLines) {
            return toClearedLine(this.lines);
        } else {
            return toLineStart(this.lines);
        }
    }

    public String toClearedLine(int lines) {

        char dir = toDirection(lines);
        int n = toLineCount(lines);

        String prefix = "";

        if (n > 0 || dir == DOWNWARD) {
            prefix = String.format("%s[0E%sK", ESC, ESC);
        }

        String clearLines = Strings.repeat(String.format("%s[1%s%s[K", ESC, dir, ESC), n);

        return String.format("%s%s", prefix, clearLines);
    }

    /**
     * Moves to the beginning of the line relative to the current location where a negative
     * number move the cursor up, and a positive number moves the cursor downward, and
     * then to the beginning of the line.
     *
     * @param lines the number of lines where sign indicates direction.
     */
    public String toLineStart(int lines) {
        char dir = toDirection(this.lines);
        int n = toLineCount(this.lines);
        String close = toCloseEsc(n, dir);
        return close;
    }
}
