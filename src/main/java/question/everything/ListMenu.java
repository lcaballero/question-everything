package question.everything;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.util.List;


public class ListMenu implements ITerminalListener {

    private List<String> items;
    private PrintStream out;
    private SpanEsc active;
    private SpanEsc other;
    private int selected;

    public ListMenu(List<String> items, SpanEsc active, SpanEsc other, PrintStream out) {
        this.items = items;
        this.active = active;
        this.other = other;
        this.out = out;
    }

    @Override
    public void startUp(String message) { }

    @Override
    public void shuttingDown(String message) { }

    @Override
    public void read(String c) {

        new CliColor()
            .to(this.out)
            .move(0, items.size());

        if (MoveEsc.BARE_UP.equals(c.toLowerCase())) { selected--; }
        else if (MoveEsc.BARE_DOWN.equals(c.toLowerCase())) { selected++; }

        System.out.println("selected: " + selected);

        if (selected < 0) { selected = items.size() - 1; }
        else if (selected >= items.size()) { selected = 0; }

        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            out.print(item);

            if (selected == i) {
                out.printf(" > %d or %d, %s %s", selected, items.size(), c.replace(""+AbstractEsc.ESC, "\\u001b"), MoveEsc.BARE_UP.replace(""+AbstractEsc.ESC, "\\u001b"));
            }
            out.println();
        }
    }
}
