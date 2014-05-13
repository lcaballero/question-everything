package question.everything;

import java.io.PrintStream;
import java.util.List;


public class ListMenu implements ITerminalListener {

    private List<String> items;
    private PrintStream out;
    private SpanEsc active;
    private SpanEsc other;
    private CliColor cli;
    private int selected;
    private Terminal terminal;

    public ListMenu(List<String> items, SpanEsc active, SpanEsc other, PrintStream out) {
        this.items = items;
        this.active = active;
        this.other = other;
        this.out = out;
        this.cli = new CliColor();
    }

    @Override
    public void startUp(String message) {
        this.cli.to(this.out);
        moveSelection("", true);
    }

    @Override
    public void shuttingDown(String message) {
        this.terminal.remove(this); // remove this class as listener from the terminal
        this.terminal = null;       // remove reference to the Terminal instance.
    }

    @Override
    public void read(String c) {
        moveSelection(c, false);
    }

    public boolean isUp(String c) {
        return MoveEsc.BARE_UP.equals(c.toLowerCase());
    }

    public boolean isDown(String c) {
        return MoveEsc.BARE_DOWN.equals(c.toLowerCase());
    }

    public int limit(int selected, int max) {
        if (selected < 0) { return items.size() - 1; }
        else if (selected >= max) { return 0; }
        else { return selected; }
    }

    public int toSelected(String c, int selected, int max) {
        if (isUp(c)) {
            return limit(--selected, max);
        } else if (isDown(c)) {
            return limit(++selected, max);
        } else {
            return selected;
        }
    }

    private void moveSelection(String c, boolean firstCall) {

        if ("\n".equals(c)) {
            this.terminal.shutdown();
            return;
        }

        if (!firstCall) {
            this.cli.toClearedLines(-items.size()); // Move up number of items
        }

        selected = toSelected(c, this.selected, items.size());

        for (int i = 0; i < items.size(); i++) {

            String item = items.get(i);

            if (selected == i) {
                this.out.print(this.active.surround(item, " >"));
            } else {
                this.out.print(this.other.surround(item));
            }
            this.cli.println();
        }
    }

    public String run() {
        this.terminal = new Terminal();
        this.terminal.add(this).run();
        return this.items.get(this.selected);
    }
}
