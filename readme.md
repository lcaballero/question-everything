# Introduction

This is a java project to help build more awesome command line interfaces.
It is not an options parser, there are a lot of those.  This is instead
a lib for adding color to the command prompt.  It's intended to be used
with a future lib that will create prompts for user input in the same
fashion as [Inquirer.js][Inquirer]


## Overview

There are really only 2 main classes in the lib.  One provides escaping
bytes to the command prompt, and the other a builder to combine various
escape sequences (colors).  The former is called `ColorEsc` and the
latter `CliColor`.  Most usage will be through `CliColor`.

## Usage

Here's an example usage:

```java
    new CliColor()
        .to(System.out)
        .black().print("Hello, World!").name().println().clear()
        .red().print("Hello, World!").name().println().clear()
        .green().print("Hello, World!").name().println().clear()
        .yellow().print("Hello, World!").name().println().clear()
        .blue().print("Hello, World!").name().println().clear()
        .magenta().print("Hello, World!").name().println().clear()
        .cyan().print("Hello, World!").name().println().clear()
        .white().print("Hello, World!").name().println().clear();
```

Additionally, foreground and background colors can be combined:

```java
    new CliColor()
        .to(System.out)
        .red().whiteBg().print("Brave, World!").name().println().clear();

```

The same is true for styles.  They can be combined as well:

```java
    new CliColor()
        .to(System.out)
        .underline().print("Brave, World!").name().println();
```

## License

## License

See license file.

The use and distribution terms for this software are covered by the
[Eclipse Public License 1.0][EPL-1], which can be found in the file 'license' at the
root of this distribution. By using this software in any fashion, you are
agreeing to be bound by the terms of this license. You must not remove this
notice, or any other, from this software.





[Inquirer]: https://github.com/SBoudrias/Inquirer.js/
[EPL-1]: http://opensource.org/licenses/eclipse-1.0.txt