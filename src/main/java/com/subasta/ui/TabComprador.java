package com.subasta.ui;

import javax.swing.*;
import java.awt.*;

public class TabComprador extends JPanel {

    private final Integer TAM_FILA = 16;

    public TabComprador() {
        String[] columnNames = {"Nombre",
                "Contacto",
                "Estado"
        };

        Object[][] data = {
                {"Dani", "2934 597863",
                        "ACTIVO"},
                {"Celso", "2934 597863",
                        "BANEADO"},
                {"Leo", "2934 597863",
                        "MOROSO"}
        };

        final JTable table = new JTable(data, columnNames);
        Integer cantidadFilas = data.length;
        table.setPreferredScrollableViewportSize(new Dimension(800, TAM_FILA*cantidadFilas));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }
}
