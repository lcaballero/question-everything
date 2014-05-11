package question.everything;

import java.io.PrintStream;

public class MoveEsc extends AbstractEsc {

    public static final char UP = 'a';
    public static final char DOWN = 'b';
    public static final char RIGHT = 'c';
    public static final char LEFT = 'd';

    public static final String BARE_UP = String.format("%s[%s", ESC, UP);
    public static final String BARE_DOWN = String.format("%s[%s", ESC, DOWN);
    public static final String BARE_LEFT = String.format("%s[%s", ESC, LEFT);
    public static final String BARE_RIGHT = String.format("%s[%s", ESC, RIGHT);

    protected int x;
    protected int y;

    public MoveEsc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MoveEsc add(MoveEsc b) {
        return new MoveEsc(this.x + b.x, this.y + b.y);
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public static String toEscape(int x, int y) {
        String rs = "";
        if (x != 0) { rs += toEscapes(x, x < 0 ? LEFT : RIGHT); }
        if (y != 0) { rs += toEscapes(y, y < 0 ? DOWN : UP); }
        return rs;
    }

    public static boolean isDirChar(char c) {
        return c == UP || c == DOWN || c == LEFT || c == RIGHT;
    }

    public static String toEscapes(int v, char ctrl) {
        if (!isDirChar(ctrl)) {
            throw new IllegalArgumentException("Cannot map control character: " + ctrl);
        }
        v = (v < 0 ? -v : v);
        String n = (v == 1 ? "" : ""+v);
        return String.format("%s[%s%s", ESC, n, ctrl);
    }

    @Override
    public MoveEsc apply(PrintStream out, String... args) {
        if (args != null && args.length > 0) {
            throw new IllegalArgumentException("Cannot both move cursor and output args");
        }
        out.print(toEscape(this.x, this.y));
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MoveEsc)) { return false; }
        MoveEsc b = (MoveEsc)obj;
        return this.x == b.x && this.y == b.y;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return String.format("[%d,%d]", this.getX(), this.getY());
    }
}
