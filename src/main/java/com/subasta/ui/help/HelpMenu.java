package com.subasta.ui.help;

import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class HelpMenu extends JMenu {
    public HelpMenu() {
        setText("Ayuda");

        var menuItem = new JMenuItem("Sobre");
        menuItem.addActionListener(a -> new SobreItem());

        add(menuItem);
    }
}
