package question.everything;

import java.io.PrintStream;
import java.io.PrintWriter;

public class MoveEsc extends AbstractEsc {

    public static final char UP = 'a';
    public static final char DOWN = 'b';
    public static final char RIGHT = 'c';
    public static final char LEFT = 'd';

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

    public char[] toEscape(int x, int y) {
        String rs = "";
        if (x != 0) { rs += toEscapes(x, x < 0 ? DOWN : UP); }
        if (y != 0) { rs += toEscapes(y, y < 0 ? LEFT : RIGHT); }
        return rs.toCharArray();
    }

    public String toEscapes(int n, char ctrl) {
        return String.format("%s[%s%s", ESC, ""+n, ctrl);
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
