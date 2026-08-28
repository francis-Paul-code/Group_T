import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class LanternaDisplay {
    Terminal terminal;

    public LanternaDisplay() {
        try {
            this.terminal = new DefaultTerminalFactory().createTerminal();
            printBanner("Cherish Gift Shop");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printBanner(String title) {
        System.out.print(title);
        try {
            this.terminal.enterPrivateMode();
            this.terminal.setCursorVisible(true);
            this.terminal.setBackgroundColor(TextColor.ANSI.BLUE);
            this.terminal.setForegroundColor(TextColor.ANSI.YELLOW);

            final TextGraphics textGraphics = terminal.newTextGraphics();

            textGraphics.putString(2, 1, "Lanterna Tutorial 2 - Press ESC to exit", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
            textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
            textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
            textGraphics.putString(5 + "Terminal Size: ".length(), 3, terminal.getTerminalSize().toString());


            System.out.println("finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        finally {
//            if (terminal != null) {
//                try {
//                    terminal.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }
    }
}