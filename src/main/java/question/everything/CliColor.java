package question.everything;

import com.google.common.collect.ImmutableMap;

import java.io.PrintStream;

public class CliColor implements Colors {

    private PrintStream out = System.out;
    private final ImmutableMap<String,SpanEsc> colorMap = Colors.AllEscapesMap;
    private SpanEsc activeColor = Colors.none;

    public CliColor print(String... args) {
        activeColor.apply(this.out, args);
        return this;
    }

    public CliColor println(String... args) {
        activeColor.apply(this.out, args);
        this.out.println();
        return this;
    }

    public CliColor black() { return esc("black"); }
    public CliColor red() { return esc("red"); }
    public CliColor green() { return esc("green"); }
    public CliColor yellow() { return esc("yellow"); }
    public CliColor blue() { return esc("blue"); }
    public CliColor magenta() { return esc("magenta"); }
    public CliColor cyan() { return esc("cyan"); }
    public CliColor white() { return esc("white"); }

    public CliColor blackBright() { return esc("blackBright"); }
    public CliColor redBright() { return esc("redBright"); }
    public CliColor greenBright() { return esc("greenBright"); }
    public CliColor yellowBright() { return esc("yellowBright"); }
    public CliColor blueBright() { return esc("blueBright"); }
    public CliColor magentaBright() { return esc("magentaBright"); }
    public CliColor cyanBright() { return esc("cyanBright"); }
    public CliColor whiteBright() { return esc("whiteBright"); }

    public CliColor blackBg() { return esc("blackBg"); }
    public CliColor redBg() { return esc("redBg"); }
    public CliColor greenBg() { return esc("greenBg"); }
    public CliColor yellowBg() { return esc("yellowBg"); }
    public CliColor blueBg() { return esc("blueBg"); }
    public CliColor magentaBg() { return esc("magentaBg"); }
    public CliColor cyanBg() { return esc("cyanBg"); }
    public CliColor whiteBg() { return esc("whiteBg"); }

    public CliColor blackBrightBg() { return esc("blackBrightBg"); }
    public CliColor redBrightBg() { return esc("redBrightBg"); }
    public CliColor greenBrightBg() { return esc("greenBrightBg"); }
    public CliColor yellowBrightBg() { return esc("yellowBrightBg"); }
    public CliColor blueBrightBg() { return esc("blueBrightBg"); }
    public CliColor magentaBrightBg() { return esc("magentaBrightBg"); }
    public CliColor cyanBrightBg() { return esc("cyanBrightBg"); }
    public CliColor whiteBrightBg() { return esc("whiteBrightBg"); }

    public CliColor bold() { return esc("bold"); }
    public CliColor italic() { return esc("italic"); }
    public CliColor underline() { return esc("underline"); }
    public CliColor blink() { return esc("blink"); }
    public CliColor inverse() { return esc("inverse"); }
    public CliColor strike() { return esc("strike"); }

    public CliColor esc(String color) {
        if (!colorMap.containsKey(color)) {
            throw new IllegalArgumentException("No escape for color: " + color);
        }
        SpanEsc newColor = this.activeColor.wrap(colorMap.get(color));
        CliColor cli = new CliColor(this.out, newColor);

        return cli;
    }

    public CliColor() { }
    protected CliColor(PrintStream out) { this.out = out; }
    protected CliColor(PrintStream out, SpanEsc esc) {
        this.out = out;
        this.activeColor = esc;
    }

    public SpanEsc getActiveColor() { return this.activeColor; }
    public CliColor to(PrintStream print) { return new CliColor(print); }
    public CliColor clear() { return new CliColor(this.out); }
    public CliColor name() {
        print(String.format(" (%s)", activeColor.getName()));
        return this;
    }

    public CliColor move(int x, int y) {
        new MoveEsc(x, y).apply(this.out);
        return this;
    }

    public CliColor toLineStart(int lines) {
        new BeginningOfLineEsc(lines, false)
            .apply(this.out);
        return this;
    }

    public CliColor toClearedLines(int lines) {
        new BeginningOfLineEsc(lines, true)
            .apply(this.out);
        return this;
    }
}
