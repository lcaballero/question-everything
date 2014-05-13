package question.everything;

public abstract class AbstractEsc {

    public static final char ESC = '\u001b';

    public abstract String surround(String... args);
    public abstract String apply();
}
