package question.everything;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.List;

public class ListMenu {

    private List<String> items;
    private PrintStream out;
    private SpanEsc active;
    private SpanEsc other;

    public ListMenu(List<String> items, SpanEsc active, SpanEsc other, PrintStream out) {
        this.items = items;
        this.active = active;
        this.other = other;
        this.out = out;
    }

    public String run() throws IOException {

        Reader reader = System.console().reader();
        int input = reader.read();
        int selected = 0;

        while (input != -1) {
            for (int i = 0; i < items.size(); i++) {
                String item = items.get(i);
                out.printf("%s %s", item, ">");
            }

            input = reader.read();


        }

        return null;
    }
}
