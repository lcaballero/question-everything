package question.everything;

import java.io.PrintStream;


public class BeginningOfLineEsc extends AbstractEsc {

    protected char[] escapes = new char[0];

    public BeginningOfLineEsc(int n) {
        char dir = (n >= 0) ? 'E' : 'F';
        n = n < 0 ? -n : n;
        String esc = String.format("%s[%d%s", ESC, n, dir);
        escapes = esc.toCharArray();
    }

    @Override
    public AbstractEsc apply(PrintStream out, String... args) {
        out.print(escapes);
        return this;
    }
}
