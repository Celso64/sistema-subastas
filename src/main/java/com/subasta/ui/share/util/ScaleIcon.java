package com.subasta.ui.share.util;

import javax.swing.*;
import java.awt.*;

public abstract class ScaleIcon {

    public static final Integer ICONO_SMALL = 16;
    public static final Integer ICONO_MEDIUM = 24;
    public static final Integer ICONO_LARGE = 32;

    public static ImageIcon scale(ImageIcon icon, Integer alto, Integer ancho){
        Image imagenEscalada = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imagenEscalada);
    }
}
