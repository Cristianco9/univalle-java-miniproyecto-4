package app.util;

import javax.swing.*;
import java.awt.*;

public class Utils {
    public static void centerFrame(JFrame frame) {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int h = frame.getSize().height;
        frame.setLocation((dim.width - w) / 2, (dim.height - h) / 2);
    }
}
