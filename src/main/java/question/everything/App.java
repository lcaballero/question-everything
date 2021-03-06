package question.everything;

import com.google.inject.Singleton;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Singleton
public class App {

    public void start() throws IllegalAccessException, IOException {
        menu();
//        bol0();
//        bol2();
    }

    public void menu() throws IOException {

        SpanEsc blue = Colors.blue;
        SpanEsc none = Colors.none;

        List<String> items = new ArrayList<>();
        items.add("Menu item 1 selection");
        items.add("Menu item 2 selection");
        items.add("Menu item 3 selection");

        String item = new ListMenu(items, blue, none, System.out).run();

        System.out.println(Colors.red.surround(item));
    }

    public void bol0() {

        new CliColor()
            .to(System.out)
            .print("Some text here")
            .toLineStart(0)
            .println("Aarg");
    }

    public void bol2() {

        new CliColor()
            .to(System.out)
            .println("Line 1")
            .println("Line 2")
            .println("Line 3")
            .print("Line 4")
            .toLineStart(-2)
            .println(">>>>");

        new CliColor()
            .to(System.out)
            .println("Line 1")
            .println("Line 2")
            .println("Line 3")
            .print("Line 4")
            .toClearedLines(-2)
            .println(">>>>");
    }

    public void readLine() {
        Console console = System.console();
        if (console == null) {
            System.out.println("Cannot retrieve console");
        }
        String line = console.readLine();
        new CliColor()
            .to(System.out)
            .print("I saw this line: ")
            .red()
            .println(line);
    }

    public void moves() {
        System.out.println();
        System.out.println("Next line that should not be completely overwritten.");

        new CliColor()
            .to(System.out)
            .move(0, 2);

        System.out.print("After");
        System.out.println();
    }

    public void colors() {

        new CliColor()
            .to(System.out)
            .black().print("Hello, World!").name().println().clear()
            .red().print("Hello, World!").name().println().clear()
            .green().print("Hello, World!").name().println().clear()
            .yellow().print("Hello, World!").name().println().clear()
            .blue().print("Hello, World!").name().println().clear()
            .magenta().print("Hello, World!").name().println().clear()
            .cyan().print("Hello, World!").name().println().clear()
            .white().print("Hello, World!").name().println().clear()

            .blackBright().print("Hello, World!").name().println().clear()
            .redBright().print("Hello, World!").name().println().clear()
            .greenBright().print("Hello, World!").name().println().clear()
            .yellowBright().print("Hello, World!").name().println().clear()
            .blueBright().print("Hello, World!").name().println().clear()
            .magentaBright().print("Hello, World!").name().println().clear()
            .cyanBright().print("Hello, World!").name().println().clear()
            .whiteBright().print("Hello, World!").name().println().clear()

            .blackBg().print("Hello, World!").name().println().clear()
            .redBg().print("Hello, World!").name().println().clear()
            .greenBg().print("Hello, World!").name().println().clear()
            .yellowBg().print("Hello, World!").name().println().clear()
            .blueBg().print("Hello, World!").name().println().clear()
            .magentaBg().print("Hello, World!").name().println().clear()
            .cyanBg().print("Hello, World!").name().println().clear()
            .whiteBg().print("Hello, World!").name().println().clear()

            .blackBrightBg().print("Hello, World!").name().println().clear()
            .redBrightBg().print("Hello, World!").name().println().clear()
            .greenBrightBg().print("Hello, World!").name().println().clear()
            .yellowBrightBg().print("Hello, World!").name().println().clear()
            .blueBrightBg().print("Hello, World!").name().println().clear()
            .magentaBrightBg().print("Hello, World!").name().println().clear()
            .cyanBrightBg().print("Hello, World!").name().println().clear()
            .whiteBrightBg().print("Hello, World!").name().println().clear()
        ;

        new CliColor()
            .red().whiteBg().print("Brave, World!").name().println().clear()
        ;

        new CliColor()
            .underline().print("Brave, World!").name().println()
        ;
    }
}