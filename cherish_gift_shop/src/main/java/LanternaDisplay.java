import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;


public class LanternaDisplay {
    Terminal terminal;

    public LanternaDisplay() {
        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayManager(ArrayList<String> print) {
        try {
            this.terminal.enterPrivateMode();
            this.terminal.setCursorVisible(true);
            this.terminal.setBackgroundColor(TextColor.ANSI.BLUE);
            this.terminal.setForegroundColor(TextColor.ANSI.YELLOW);

            final TextGraphics textGraphics = terminal.newTextGraphics();

            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK_BRIGHT);
            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.fillRectangle(new TerminalPosition(0, 0), terminal.getTerminalSize(), ' ');

            // Print banner text
            textGraphics.putString(2, 1, "Cherish Gift Shop - Press ESC to exit", SGR.BOLD);

            terminal.flush();

            boolean close = false;
            int frameCount = 0;

            while (!close) {
                KeyStroke keyStroke = terminal.pollInput();

                if (keyStroke != null) {
                    // Check if the escape key or the character 'q' was pressed to close
                    if (keyStroke.getKeyType() == KeyType.Escape ||
                            (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q')) {

                        close = true;
                    }
                }


                // 3. Perform background operations and draw updates
                frameCount++;
                int curr = frameCount % print.size();
                textGraphics.putString(2, 3 + curr, print.get(curr));

                // Flush changes to the physical screen
                terminal.flush();

                // other operations here
            }


            System.out.println("finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (terminal != null) {
                try {
                    terminal.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}