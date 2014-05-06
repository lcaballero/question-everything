package question.everything;

import com.google.inject.Singleton;


@Singleton
public class App {

    private boolean started = false;

    public boolean isStarted() {
        return this.started;
    }

    public void start() throws IllegalAccessException {
        started = true;

        new ColorEsc("red", 31, 39, System.out).print("old world");

        System.out.println(' ');

        new CliColor(System.out);

        CliColor.red.print("brave world");

        System.out.println(' ');

        CliColor.blue.print("home world");

        System.out.println(' ');
    }
}