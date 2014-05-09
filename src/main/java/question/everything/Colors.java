package question.everything;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.stream.Collectors;

public interface Colors {

    public static final String NONE = "none";

    public static final SpanEsc none = new SpanEsc();
    
    public static final SpanEsc bold = new SpanEsc("bold", 1, 22);
    public static final SpanEsc italic = new SpanEsc("italic", 3, 23);
    public static final SpanEsc underline = new SpanEsc("underline", 4, 24);
    public static final SpanEsc blink = new SpanEsc("blink", 5, 25);
    public static final SpanEsc inverse = new SpanEsc("inverse", 7, 27);
    public static final SpanEsc strike = new SpanEsc("strike", 9, 29);
    
    public static final ImmutableSet<SpanEsc> AllStyles = ImmutableSet.of(
        bold, italic, blink, underline, inverse, strike
    );

    public static final int FG_END = 39;
    public static final int BG_END = 49;

    public static final int FG_START = 30;
    public static final int BRIGHT = 90;
    public static final int BG_START = 40;
    public static final int BRIGH_BG = 100;

    public static final SpanEsc black      = new SpanEsc("black",     FG_START + 0, FG_END);
    public static final SpanEsc red        = new SpanEsc("red",       FG_START + 1, FG_END);
    public static final SpanEsc green      = new SpanEsc("green",     FG_START + 2, FG_END);
    public static final SpanEsc yellow     = new SpanEsc("yellow",    FG_START + 3, FG_END);
    public static final SpanEsc blue       = new SpanEsc("blue",      FG_START + 4, FG_END);
    public static final SpanEsc magenta    = new SpanEsc("magenta",   FG_START + 5, FG_END);
    public static final SpanEsc cyan       = new SpanEsc("cyan",      FG_START + 6, FG_END);
    public static final SpanEsc white      = new SpanEsc("white",     FG_START + 7, FG_END);

    public static final SpanEsc blackBright      = new SpanEsc("blackBright",     BRIGHT + 0, FG_END);
    public static final SpanEsc redBright        = new SpanEsc("redBright",       BRIGHT + 1, FG_END);
    public static final SpanEsc greenBright      = new SpanEsc("greenBright",     BRIGHT + 2, FG_END);
    public static final SpanEsc yellowBright     = new SpanEsc("yellowBright",    BRIGHT + 3, FG_END);
    public static final SpanEsc blueBright       = new SpanEsc("blueBright",      BRIGHT + 4, FG_END);
    public static final SpanEsc magentaBright    = new SpanEsc("magentaBright",   BRIGHT + 5, FG_END);
    public static final SpanEsc cyanBright       = new SpanEsc("cyanBright",      BRIGHT + 6, FG_END);
    public static final SpanEsc whiteBright      = new SpanEsc("whiteBright",     BRIGHT + 7, FG_END);

    public static final SpanEsc blackBg      = new SpanEsc("blackBg",     BG_START + 0, BG_END);
    public static final SpanEsc redBg        = new SpanEsc("redBg",       BG_START + 1, BG_END);
    public static final SpanEsc greenBg      = new SpanEsc("greenBg",     BG_START + 2, BG_END);
    public static final SpanEsc yellowBg     = new SpanEsc("yellowBg",    BG_START + 3, BG_END);
    public static final SpanEsc blueBg       = new SpanEsc("blueBg",      BG_START + 4, BG_END);
    public static final SpanEsc magentaBg    = new SpanEsc("magentaBg",   BG_START + 5, BG_END);
    public static final SpanEsc cyanBg       = new SpanEsc("cyanBg",      BG_START + 6, BG_END);
    public static final SpanEsc whiteBg      = new SpanEsc("whiteBg",     BG_START + 7, BG_END);

    public static final SpanEsc blackBrightBg      = new SpanEsc("blackBrightBg",     BRIGH_BG + 0, BG_END);
    public static final SpanEsc redBrightBg        = new SpanEsc("redBrightBg",       BRIGH_BG + 1, BG_END);
    public static final SpanEsc greenBrightBg      = new SpanEsc("greenBrightBg",     BRIGH_BG + 2, BG_END);
    public static final SpanEsc yellowBrightBg     = new SpanEsc("yellowBrightBg",    BRIGH_BG + 3, BG_END);
    public static final SpanEsc blueBrightBg       = new SpanEsc("blueBrightBg",      BRIGH_BG + 4, BG_END);
    public static final SpanEsc magentaBrightBg    = new SpanEsc("magentaBrightBg",   BRIGH_BG + 5, BG_END);
    public static final SpanEsc cyanBrightBg       = new SpanEsc("cyanBrightBg",      BRIGH_BG + 6, BG_END);
    public static final SpanEsc whiteBrightBg      = new SpanEsc("whiteBrightBg",     BRIGH_BG + 7, BG_END);

    public static final ImmutableSet<SpanEsc> AllColors = ImmutableSet.of(
        black, red, green, yellow, blue, magenta, cyan, white,                          // color (Basic)

        blackBright, redBright, greenBright, yellowBright, blueBright, magentaBright,   // colorBight
        cyanBright, whiteBright,

        blackBg, redBg, greenBg, yellowBg, blueBg, magentaBg, cyanBg, whiteBg,          // colorBg

        blackBrightBg, redBrightBg, greenBrightBg, yellowBrightBg, blueBrightBg,        // colorBrightBg
        magentaBrightBg, cyanBrightBg, whiteBrightBg
    );

    public static final ImmutableSet<SpanEsc> AllEscapes = ImmutableSet.<SpanEsc>builder()
        .addAll(AllStyles).addAll(AllColors).build();

    public static final ImmutableMap<String,SpanEsc> AllEscapesMap = ImmutableMap.copyOf(
        AllEscapes.stream().collect(Collectors.toMap((c) -> c.getName(), (c) -> c)));
}
