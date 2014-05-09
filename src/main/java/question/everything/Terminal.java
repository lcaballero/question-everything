package question.everything;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class Terminal {

    private String ttyConfig;

    public void run() {

        try {
            setTerminalToCBreak();

            while (true) {
                if ( System.in.available() != 0 ) {
                    int c = System.in.read();
                    if (c == 0x1B) {
                        System.out.print("read: 0x1B");
                        System.out.print((char)System.in.read());
                        System.out.println((char)System.in.read());
                    } else if (c == '\n') {
                        System.out.println("read: \\n");
                    } else {
                        System.out.println("read: " + (char)c);
                    }
                }
            }
        }
        catch (IOException e) {
            System.err.println("IOException");
        }
        catch (InterruptedException e) {
            System.err.println("InterruptedException");
        }
        finally {
            try {
                stty( ttyConfig.trim() );
            }
            catch (Exception e) {
                System.err.println("Exception restoring tty config");
            }
        }

    }

    private void setTerminalToCBreak() throws IOException, InterruptedException {
        ttyConfig = stty("-g");
        stty("-icanon min 1");  // set the console to be character-buffered instead of line-buffered
        stty("-echo");          // disable character echoing
    }

    /**
     *  Execute the stty command with the specified arguments
     *  against the current active terminal.
     */
    private String stty(final String args)
        throws IOException, InterruptedException {
        String cmd = "stty " + args + " < /dev/tty";

        return exec(new String[] { "sh", "-c", cmd });
    }

    /**
     *  Execute the specified command and return the output
     *  (both stdout and stderr).
     */
    private String exec(final String[] cmd)
        throws IOException, InterruptedException {

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        Process p = Runtime.getRuntime().exec(cmd);
        InputStream in = p.getInputStream();

        int c;

        while ((c = in.read()) != -1) {
            bout.write(c);
        }

        in = p.getErrorStream();

        while ((c = in.read()) != -1) {
            bout.write(c);
        }

        p.waitFor();

        String result = new String(bout.toByteArray());
        return result;
    }

}
