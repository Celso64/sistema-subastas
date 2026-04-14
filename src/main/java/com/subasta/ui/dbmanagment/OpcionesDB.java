package com.subasta.ui.dbmanagment;

import com.subasta.ui.share.util.Icon;
import com.subasta.ui.share.util.FindIcon;

import javax.swing.*;
import java.awt.*;

public class OpcionesDB extends JFrame {
    public OpcionesDB() throws HeadlessException {
        setTitle("Opciones de Base de Datos");
        setVisible(true);
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        FindIcon.getIcon(Icon.APP).ifPresent(imageIcon -> setIconImage(imageIcon.getImage()));
    }
}
