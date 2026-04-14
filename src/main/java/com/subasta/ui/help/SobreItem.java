package com.subasta.ui.help;

import com.subasta.ui.share.util.FindIcon;
import com.subasta.ui.share.util.Icon;
import com.subasta.ui.share.util.ScaleIcon;

import javax.swing.*;
import java.awt.*;

public class SobreItem extends JFrame {
    public SobreItem() {
        setTitle("Sobre");
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        FindIcon.getIcon(Icon.APP).ifPresent(imageIcon -> setIconImage(imageIcon.getImage()));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridy = 0;
        var label = new JLabel("");
        FindIcon.getIcon(Icon.APP).ifPresent(imageIcon -> label.setIcon(ScaleIcon.scale(imageIcon, ScaleIcon.ICONO_LARGE, ScaleIcon.ICONO_LARGE)));
        add(label, gbc);


        gbc.gridy = 1;
        add(new JLabel("Software para gestionar subastas de cartas."), gbc);

        gbc.gridy = 2;
        add(new JLabel("V1.0"), gbc);
    }
}
