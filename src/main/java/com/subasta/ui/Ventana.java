package com.subasta.ui;

import com.subasta.ui.compra.view.CompraPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Ventana extends JFrame {

    @Autowired
    public Ventana(CompraPanel compraPanel) throws HeadlessException {
        setTitle("Sistema Subasta");
        setSize(820, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        compraPanel.setOpaque(true);
        tabbedPane.addTab("Compras", null, compraPanel,
                "Lotes de cartas compradas.");

        TabComprador tabComprador = new TabComprador();
        tabComprador.setOpaque(true);
        tabbedPane.addTab("Compradores", null, tabComprador,
                "Compradores de cartas.");

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

    }

}
