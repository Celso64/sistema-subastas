package com.subasta.ui.preferences;

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
    }
}
