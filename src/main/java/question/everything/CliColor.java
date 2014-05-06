package question.everything;

import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CliColor {

    public static ColorEsc black;
    public static ColorEsc red;
    public static ColorEsc green;
    public static ColorEsc yellow;
    public static ColorEsc blue;
    public static ColorEsc magenta;
    public static ColorEsc cyan;
    public static ColorEsc white;

    public static ColorEsc blackBg;
    public static ColorEsc redBg;
    public static ColorEsc greenBg;
    public static ColorEsc yellowBg;
    public static ColorEsc blueBg;
    public static ColorEsc magentaBg;
    public static ColorEsc cyanBg;
    public static ColorEsc whiteBg;

    public static ColorEsc blackBright;
    public static ColorEsc redBright;
    public static ColorEsc greenBright;
    public static ColorEsc yellowBright;
    public static ColorEsc blueBright;
    public static ColorEsc magentaBright;
    public static ColorEsc cyanBright;
    public static ColorEsc whiteBright;

    public static ColorEsc blackBrightBg;
    public static ColorEsc redBrightBg;
    public static ColorEsc greenBrightBg;
    public static ColorEsc yellowBrightBg;
    public static ColorEsc blueBrightBg;
    public static ColorEsc magentaBrightBg;
    public static ColorEsc cyanBrightBg;
    public static ColorEsc whiteBrightBg;


    public CliColor(PrintStream out) throws IllegalAccessException {

        Field[] fields = this.getClass().getDeclaredFields();

        List<ColorEsc> colors = colors();
        for (ColorEsc c : colors) {
            c.setOut(out);
        }

        HashMap<String,ColorEsc> map = mapColors(colors);

        for (Field f : fields) {
            String name = f.getName();
            if (map.containsKey(name)) {
                f.set(this, map.get(name));
            }
        }
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
