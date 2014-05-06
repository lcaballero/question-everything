package question.everything;

import com.google.common.base.Joiner;

import java.io.PrintStream;


public class ColorEsc {

    public static final char ESC = '\u001b';

    private char[] escStart;
    private char[] escEnd;
    private PrintStream out;
    private String name;

    public ColorEsc(String name, int start, int end, PrintStream out) {
        this.name = name;
        this.out = out;
        this.escStart = String.format("[%sm", String.valueOf(start)).toCharArray();
        this.escEnd = String.format("[%sm", String.valueOf(end)).toCharArray();
    }

    public ColorEsc(String name, int start, int end) {
        this(name, start, end, null);
    }

    public PrintStream getOut() {
        return out;
    }

    public String getName() {
        return name;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void print(String... args) {
        out.print(ESC);
        out.print(escStart);
        out.print(Joiner.on(" ").join((args)));
        out.print(ESC);
        out.print(escEnd);
    }
}
