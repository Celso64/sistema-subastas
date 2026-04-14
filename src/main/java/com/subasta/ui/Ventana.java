package com.subasta.ui;

import com.subasta.ui.compra.view.CompraPanel;
import com.subasta.ui.comprador.view.CompradorPanel;
import com.subasta.ui.share.util.Icon;
import com.subasta.ui.share.util.FindIcon;
import com.subasta.ui.share.util.ScaleIcon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

@Component
public class Ventana extends JFrame {

    private static final Integer BORDER_SIZE = 10;

    @Autowired
    public Ventana(CompraPanel compraPanel, CompradorPanel compradorPanel, MenuBar menu) throws HeadlessException {
        setTitle("Sistema Subasta");
        setSize(820, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        FindIcon.getIcon(Icon.APP).ifPresent(imageIcon -> setIconImage(imageIcon.getImage()));

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
        compraPanel.setOpaque(true);


        javax.swing.Icon iconoCarta = null;
        javax.swing.Icon iconoComprador = null;


        var c1 = FindIcon.getIcon(Icon.CARTAS);
        var c2 = FindIcon.getIcon(Icon.COMPRADOR);

        if (c1.isPresent()){
            iconoCarta = ScaleIcon.scale(c1.get(), ScaleIcon.ICONO_MEDIUM, ScaleIcon.ICONO_MEDIUM);
        }

        if (c2.isPresent()){
            iconoComprador = ScaleIcon.scale(c2.get(), ScaleIcon.ICONO_MEDIUM, ScaleIcon.ICONO_MEDIUM);
        }


        tabbedPane.addTab("Compras", iconoCarta, compraPanel,
                "Lotes de cartas compradas.");

        compradorPanel.setOpaque(true);
        tabbedPane.addTab("Compradores", iconoComprador, compradorPanel,
                "Compradores de cartas.");

        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        setJMenuBar(menu);

    }

}
