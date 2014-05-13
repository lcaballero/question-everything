package question.everything;

import com.google.common.base.Joiner;


public class SpanEsc extends AbstractEsc {

    protected String escStart = "";
    protected String escEnd = "";
    protected String name = Colors.NONE;

    /**
     * Creates a SpanEsc with the provided name, and with the start and end
     * escapes.  The escapes are prefixed with \x1b[ and so given a start
     * of 31 and an end of 39 would produce escapes \1xb[31 and \1xb[39
     * respectively.  These escape sequences would then be used when outputting
     * to stream, sandwiching a arguments between the start and end.
     *
     * @param name Canonical name for the escape
     * @param start Integer portion for the start escape sequence.
     * @param end Integer portion of the end escape sequence.
     */
    public SpanEsc(String name, int start, int end) {
        this.name = name;
        this.escStart = String.format("%s[%sm", ESC, String.valueOf(start));
        this.escEnd = String.format("%s[%sm", ESC, String.valueOf(end));
    }

    /**
     * Creates a default SpanEsc with empty terminal Esc chars and a name of 'none'.
     */
    public SpanEsc() {
        // All values defaulted in AbstractEsc, including: name, escStart, escEnd.
    }

    /**
     * Concatenates the escape sequences to produce a new escape where even
     * the name would amount to 'name + name'.  The idea is that concatenating
     * two escapes like red and whiteBg would produce the correct start and end
     * sequence along with the name 'red + whiteBg'
     *
     * @param a The initial escape.
     * @param b The escape to concatenate.
     */
    protected SpanEsc(SpanEsc a, SpanEsc b) {
        this.escStart = a.escStart + b.escStart;
        this.escEnd = a.escEnd + b.escEnd;

        String prefix = Colors.NONE.equals(a.name) ? "" : String.format("%s + ", a.name);
        this.name = String.format("%s%s", prefix, b.name);
    }

    public SpanEsc wrap(SpanEsc b) {
        return new SpanEsc(this, b);
    }

    @Override
    public String apply() {
        return this.surround();
    }

    @Override
    public String surround(String... params) {
        if (this.escStart == null || this.escStart.length() == 0 || this.escEnd == null || this.escEnd.length() == 0) {
            return Joiner.on(" ").join((params));
        } else {
            return String.format("%s%s%s", escStart, Joiner.on(" ").join(params), escEnd);
        }
    }

    @Override
    public int hashCode() {
        return String.format(
            "%s%s%s",
            this.name,
            this.escStart,
            this.escEnd).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof SpanEsc)) {
            return false;
        }
        SpanEsc esc = (SpanEsc)obj;

        String start = this.escStart == null ? "" : this.escStart;
        String end = this.escEnd == null ? "" : this.escEnd;

        return
            this.name.equals(esc.name)
            && start.equals(esc.escStart)
            && end.equals(esc.escEnd);
    }

    public String getName() { return name; }
}
