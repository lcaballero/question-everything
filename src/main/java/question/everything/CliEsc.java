package question.everything;

import com.google.common.base.Joiner;

import java.io.PrintStream;


public class CliEsc {

    public static final char ESC = '\u001b';
    public static final String NONE = "none";

    private char[] escStart = new char[0];
    private char[] escEnd = new char[0];
    private String name;

    public CliEsc(String name, int start, int end) {
        this.name = name;
        this.escStart = String.format("%s[%sm", ESC, String.valueOf(start)).toCharArray();
        this.escEnd = String.format("%s[%sm", ESC, String.valueOf(end)).toCharArray();
    }

    public CliEsc() {
        this.name = NONE;
    }

    public CliEsc(CliEsc a, CliEsc b) {
        this.escStart = add(a.escStart, b.escStart);
        this.escEnd = add(a.escEnd, b.escEnd);

        String prefix = NONE.equals(a.name) ? "" : String.format("%s + ", a.name);
        this.name = String.format("%s%s", prefix, b.name);
    }

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

    public String getName() { return name; }

    public CliEsc toStream(PrintStream out, String... params) {

        if (this.escStart.length == 0 || this.escEnd.length == 0) {
            System.out.print(Joiner.on(" ").join((params)));
        } else {
            System.out.print(escStart);
            System.out.print(Joiner.on(" ").join((params)));
            System.out.print(escEnd);
        }

        return this;
    }

    @Override
    public int hashCode() {
        return String.format(
            "%s%s%s",
            this.name,
            new String(this.escStart),
            new String(this.escEnd)).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof CliEsc)) {
            return false;
        }
        CliEsc esc = (CliEsc)obj;

        return
            this.name.equals(esc.name)
            && new String(this.escStart).equals(new String(esc.escStart))
            && new String(this.escEnd).equals(new String(esc.escEnd));
    }
}
