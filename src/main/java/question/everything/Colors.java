package question.everything;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.stream.Collectors;

public interface Colors {

    public static final CliEsc none = new CliEsc();
    
    public static final CliEsc bold = new CliEsc("bold", 1, 22);
    public static final CliEsc italic = new CliEsc("italic", 3, 23);
    public static final CliEsc underline = new CliEsc("underline", 4, 24);
    public static final CliEsc blink = new CliEsc("blink", 5, 25);
    public static final CliEsc inverse = new CliEsc("inverse", 7, 27);
    public static final CliEsc strike = new CliEsc("strike", 9, 29);
    
    public static final ImmutableSet<CliEsc> AllStyles = ImmutableSet.of(
        bold, italic, blink, underline, inverse, strike
    );

    public static final int FG_END = 39;
    public static final int BG_END = 49;

    public static final int FG_START = 30;
    public static final int BRIGHT = 90;
    public static final int BG_START = 40;
    public static final int BRIGH_BG = 100;

    public static final CliEsc black      = new CliEsc("black",     FG_START + 0, FG_END);
    public static final CliEsc red        = new CliEsc("red",       FG_START + 1, FG_END);
    public static final CliEsc green      = new CliEsc("green",     FG_START + 2, FG_END);
    public static final CliEsc yellow     = new CliEsc("yellow",    FG_START + 3, FG_END);
    public static final CliEsc blue       = new CliEsc("blue",      FG_START + 4, FG_END);
    public static final CliEsc magenta    = new CliEsc("magenta",   FG_START + 5, FG_END);
    public static final CliEsc cyan       = new CliEsc("cyan",      FG_START + 6, FG_END);
    public static final CliEsc white      = new CliEsc("white",     FG_START + 7, FG_END);

    public static final CliEsc blackBright      = new CliEsc("blackBright",     BRIGHT + 0, FG_END);
    public static final CliEsc redBright        = new CliEsc("redBright",       BRIGHT + 1, FG_END);
    public static final CliEsc greenBright      = new CliEsc("greenBright",     BRIGHT + 2, FG_END);
    public static final CliEsc yellowBright     = new CliEsc("yellowBright",    BRIGHT + 3, FG_END);
    public static final CliEsc blueBright       = new CliEsc("blueBright",      BRIGHT + 4, FG_END);
    public static final CliEsc magentaBright    = new CliEsc("magentaBright",   BRIGHT + 5, FG_END);
    public static final CliEsc cyanBright       = new CliEsc("cyanBright",      BRIGHT + 6, FG_END);
    public static final CliEsc whiteBright      = new CliEsc("whiteBright",     BRIGHT + 7, FG_END);

    public static final CliEsc blackBg      = new CliEsc("blackBg",     BG_START + 0, BG_END);
    public static final CliEsc redBg        = new CliEsc("redBg",       BG_START + 1, BG_END);
    public static final CliEsc greenBg      = new CliEsc("greenBg",     BG_START + 2, BG_END);
    public static final CliEsc yellowBg     = new CliEsc("yellowBg",    BG_START + 3, BG_END);
    public static final CliEsc blueBg       = new CliEsc("blueBg",      BG_START + 4, BG_END);
    public static final CliEsc magentaBg    = new CliEsc("magentaBg",   BG_START + 5, BG_END);
    public static final CliEsc cyanBg       = new CliEsc("cyanBg",      BG_START + 6, BG_END);
    public static final CliEsc whiteBg      = new CliEsc("whiteBg",     BG_START + 7, BG_END);

    public static final CliEsc blackBrightBg      = new CliEsc("blackBrightBg",     BRIGH_BG + 0, BG_END);
    public static final CliEsc redBrightBg        = new CliEsc("redBrightBg",       BRIGH_BG + 1, BG_END);
    public static final CliEsc greenBrightBg      = new CliEsc("greenBrightBg",     BRIGH_BG + 2, BG_END);
    public static final CliEsc yellowBrightBg     = new CliEsc("yellowBrightBg",    BRIGH_BG + 3, BG_END);
    public static final CliEsc blueBrightBg       = new CliEsc("blueBrightBg",      BRIGH_BG + 4, BG_END);
    public static final CliEsc magentaBrightBg    = new CliEsc("magentaBrightBg",   BRIGH_BG + 5, BG_END);
    public static final CliEsc cyanBrightBg       = new CliEsc("cyanBrightBg",      BRIGH_BG + 6, BG_END);
    public static final CliEsc whiteBrightBg      = new CliEsc("whiteBrightBg",     BRIGH_BG + 7, BG_END);

    public static final ImmutableSet<CliEsc> AllColors = ImmutableSet.of(
        black, red, green, yellow, blue, magenta, cyan, white,                          // color (Basic)

        blackBright, redBright, greenBright, yellowBright, blueBright, magentaBright,   // colorBight
        cyanBright, whiteBright,

        blackBg, redBg, greenBg, yellowBg, blueBg, magentaBg, cyanBg, whiteBg,          // colorBg

        blackBrightBg, redBrightBg, greenBrightBg, yellowBrightBg, blueBrightBg,        // colorBrightBg
        magentaBrightBg, cyanBrightBg, whiteBrightBg
    );

    public static final ImmutableSet<CliEsc> AllEscapes = ImmutableSet.<CliEsc>builder()
        .addAll(AllStyles).addAll(AllColors).build();

    public static final ImmutableMap<String,CliEsc> AllEscapesMap = ImmutableMap.copyOf(
        AllEscapes.stream().collect(Collectors.toMap((c) -> c.getName(), (c) -> c)));
}
