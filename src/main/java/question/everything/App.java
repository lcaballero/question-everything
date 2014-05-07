package question.everything;

import com.google.inject.Singleton;


@Singleton
public class App {

    public void start() throws IllegalAccessException {

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
            .to(System.out)
            .red().whiteBg().print("Brave, World!").name().println().clear()
        ;

        new CliColor()
            .to(System.out)
            .underline().print("Brave, World!").name().println();

    }
}