package question.everything;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CliColor {

    private PrintStream out;
    private HashMap<String,ColorEsc> colorMap;
    private ColorEsc activeColor = ColorEsc.None;

    public CliColor print(String... args) {
        activeColor.toStream(this.out, args);
        return this;
    }

    public CliColor println(String... args) {
        activeColor.toStream(this.out, args);
        this.out.println();
        return this;
    }

    public CliColor nl(String... args) {
        colorMap.get(ColorEsc.NONE).toStream(this.out, args);
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
        activeColor = new ColorEsc(this.activeColor, colorMap.get(color));
        return this;
    }

    public CliColor() {
        this.colorMap = mapColors(colors());
    }

    public CliColor(CliColor cc) {
        this(cc, null);
    }

    protected CliColor(CliColor cc, PrintStream out) {
        this.colorMap = cc.colorMap;
        this.out = out;
    }

    protected CliColor(CliColor cc, PrintStream out, ColorEsc esc) {
        this.colorMap = cc.colorMap;
        this.out = out;
        this.activeColor = esc;
    }

    public CliColor to(PrintStream print) {
        return new CliColor(this, print);
    }

    public CliColor clear() {
        return new CliColor(this, this.out);
    }

    public CliColor name() {
        print(String.format(" (%s)", activeColor.getName()));
        return this;
    }

    public HashMap<String,ColorEsc> mapColors(List<ColorEsc> escs) {
        HashMap<String,ColorEsc> map = new HashMap<>();
        for (ColorEsc c : escs) {
            map.put(c.getName(), c);
        }
        return map;
    }

    public List<ColorEsc> colors() {
        ArrayList<ColorEsc> escs = new ArrayList<>();

        escs.add(ColorEsc.None);

        escs.add(new ColorEsc("bold", 1, 22));
        escs.add(new ColorEsc("italic", 3, 23));
        escs.add(new ColorEsc("underline", 4, 24));
        escs.add(new ColorEsc("blink", 5, 25));
        escs.add(new ColorEsc("inverse", 7, 27));
        escs.add(new ColorEsc("strike", 9, 29));

        String[] colors = new String[] {
            "black", "red", "green", "yellow", "blue",
            "magenta", "cyan", "white"
        };

        for (int i = 0; i < colors.length; i++) {
            escs.add(new ColorEsc(colors[i], 30 + i, 39));
            escs.add(new ColorEsc(colors[i] + "Bright", 90 + i, 39));
            escs.add(new ColorEsc(colors[i] + "Bg", 40 + i, 49));
            escs.add(new ColorEsc(colors[i] + "BrightBg", 100 + i, 49));
        }

        return escs;
    }
}
