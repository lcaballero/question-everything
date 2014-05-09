package question.everything;

public interface ITerminalListener {

    public void startUp(String message);
    public void shuttingDown(String message);
    public void read(String c);
}
