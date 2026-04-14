package com.subasta.ui;

import com.subasta.ui.dbmanagment.OpcionesDB;
import com.subasta.ui.help.HelpMenu;
import com.subasta.ui.preferences.Preferencias;
import org.springframework.stereotype.Component;
import javax.swing.*;

@Component
public class MenuBar extends JMenuBar {
    public MenuBar(HelpMenu helpMenu) {
        JMenu jMenu = new JMenu("Opciones");
        JMenuItem itemPreferencias = new JMenuItem("Preferencias");
        JMenuItem itemBD = new JMenuItem("Base de Datos");

        itemPreferencias.addActionListener(action -> new Preferencias());
        itemBD.addActionListener(action -> new OpcionesDB());

        add(jMenu);
        add(helpMenu);
        jMenu.add(itemPreferencias);
        jMenu.add(itemBD);
    }
}
