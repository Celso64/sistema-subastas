package com.subasta.ui;

import com.subasta.ui.compra.view.CompraPanel;
import com.subasta.ui.comprador.view.CompradorPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Ventana extends JFrame {

    @Autowired
    public Ventana(CompraPanel compraPanel, CompradorPanel compradorPanel) throws HeadlessException {
        setTitle("Sistema Subasta");
        setSize(820, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        MenuBar menu = new MenuBar();

        compraPanel.setOpaque(true);
        tabbedPane.addTab("Compras", null, compraPanel,
                "Lotes de cartas compradas.");

        compradorPanel.setOpaque(true);
        tabbedPane.addTab("Compradores", null, compradorPanel,
                "Compradores de cartas.");

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        setJMenuBar(menu);

    }

}
