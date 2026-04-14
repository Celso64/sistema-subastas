package com.subasta.ui.preferences;

import com.subasta.ui.share.util.Icon;
import com.subasta.ui.share.util.FindIcon;

import javax.swing.*;
import java.awt.*;

public class Preferencias extends JFrame {
    public Preferencias() throws HeadlessException {
        setTitle("Preferencias");
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        FindIcon.getIcon(Icon.APP).ifPresent(imageIcon -> setIconImage(imageIcon.getImage()));
    }
}
