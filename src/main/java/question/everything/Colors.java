package question.everything;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public interface Colors {
    
    public static final ColorEsc bold = new ColorEsc("bold", 1, 22);
    public static final ColorEsc italic = new ColorEsc("italic", 3, 23);
    public static final ColorEsc underline = new ColorEsc("underline", 4, 24);
    public static final ColorEsc blink = new ColorEsc("blink", 5, 25);
    public static final ColorEsc inverse = new ColorEsc("inverse", 7, 27);
    public static final ColorEsc strike = new ColorEsc("strike", 9, 29);
    
    public static final ImmutableSet<ColorEsc> AllStyles = ImmutableSet.of(
        bold, italic, blink, underline, inverse, strike
    );

    public static final int FG_END = 39;
    public static final int BG_END = 49;

    public static final int FG_START = 30;
    public static final int BRIGHT = 90;
    public static final int BG_START = 40;
    public static final int BRIGH_BG = 100;

    public static final ColorEsc black      = new ColorEsc("black",     FG_START + 0, FG_END);
    public static final ColorEsc red        = new ColorEsc("red",       FG_START + 1, FG_END);
    public static final ColorEsc green      = new ColorEsc("green",     FG_START + 2, FG_END);
    public static final ColorEsc yellow     = new ColorEsc("yellow",    FG_START + 3, FG_END);
    public static final ColorEsc blue       = new ColorEsc("blue",      FG_START + 4, FG_END);
    public static final ColorEsc magenta    = new ColorEsc("magenta",   FG_START + 5, FG_END);
    public static final ColorEsc cyan       = new ColorEsc("cyan",      FG_START + 6, FG_END);
    public static final ColorEsc white      = new ColorEsc("white",     FG_START + 7, FG_END);

    public static final ColorEsc blackBright      = new ColorEsc("blackBright",     BRIGHT + 0, FG_END);
    public static final ColorEsc redBright        = new ColorEsc("redBright",       BRIGHT + 1, FG_END);
    public static final ColorEsc greenBright      = new ColorEsc("greenBright",     BRIGHT + 2, FG_END);
    public static final ColorEsc yellowBright     = new ColorEsc("yellowBright",    BRIGHT + 3, FG_END);
    public static final ColorEsc blueBright       = new ColorEsc("blueBright",      BRIGHT + 4, FG_END);
    public static final ColorEsc magentaBright    = new ColorEsc("magentaBright",   BRIGHT + 5, FG_END);
    public static final ColorEsc cyanBright       = new ColorEsc("cyanBright",      BRIGHT + 6, FG_END);
    public static final ColorEsc whiteBright      = new ColorEsc("whiteBright",     BRIGHT + 7, FG_END);

    public static final ColorEsc blackBg      = new ColorEsc("blackBg",     BG_START + 0, BG_END);
    public static final ColorEsc redBg        = new ColorEsc("redBg",       BG_START + 1, BG_END);
    public static final ColorEsc greenBg      = new ColorEsc("greenBg",     BG_START + 2, BG_END);
    public static final ColorEsc yellowBg     = new ColorEsc("yellowBg",    BG_START + 3, BG_END);
    public static final ColorEsc blueBg       = new ColorEsc("blueBg",      BG_START + 4, BG_END);
    public static final ColorEsc magentaBg    = new ColorEsc("magentaBg",   BG_START + 5, BG_END);
    public static final ColorEsc cyanBg       = new ColorEsc("cyanBg",      BG_START + 6, BG_END);
    public static final ColorEsc whiteBg      = new ColorEsc("whiteBg",     BG_START + 7, BG_END);

    public static final ColorEsc blackBrightBg      = new ColorEsc("blackBrightBg",     BRIGH_BG + 0, BG_END);
    public static final ColorEsc redBrightBg        = new ColorEsc("redBrightBg",       BRIGH_BG + 1, BG_END);
    public static final ColorEsc greenBrightBg      = new ColorEsc("greenBrightBg",     BRIGH_BG + 2, BG_END);
    public static final ColorEsc yellowBrightBg     = new ColorEsc("yellowBrightBg",    BRIGH_BG + 3, BG_END);
    public static final ColorEsc blueBrightBg       = new ColorEsc("blueBrightBg",      BRIGH_BG + 4, BG_END);
    public static final ColorEsc magentaBrightBg    = new ColorEsc("magentaBrightBg",   BRIGH_BG + 5, BG_END);
    public static final ColorEsc cyanBrightBg       = new ColorEsc("cyanBrightBg",      BRIGH_BG + 6, BG_END);
    public static final ColorEsc whiteBrightBg      = new ColorEsc("whiteBrightBg",     BRIGH_BG + 7, BG_END);

    public static final ImmutableSet<ColorEsc> AllColors = ImmutableSet.of(
        black, red, green, yellow, blue, magenta, cyan, white,                          // color (Basic)

        blackBright, redBright, greenBright, yellowBright, blueBright, magentaBright,   // colorBight
        cyanBright, whiteBright,

        blackBg, redBg, greenBg, yellowBg, blueBg, magentaBg, cyanBg, whiteBg,          // colorBg

        blackBrightBg, redBrightBg, greenBrightBg, yellowBrightBg, blueBrightBg,        // colorBrightBg
        magentaBrightBg, cyanBrightBg, whiteBrightBg
    );

    public static final ImmutableSet<ColorEsc> AllEscapes = ImmutableSet.<ColorEsc>builder()
        .addAll(AllStyles).addAll(AllColors).build();
}
