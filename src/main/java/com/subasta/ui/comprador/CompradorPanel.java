package com.subasta.ui.comprador;

import com.subasta.core.api.CompradorAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CompradorPanel extends JPanel {

    @Autowired
    public CompradorPanel(CompradorAPI compradorAPI, CompradorList compradorList, CompradorAdd compradorAdd) {
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(compradorList, "listar");
        add(compradorAdd, "agregar");

        compradorList.alPresionarAgregar(e -> cardLayout.show(this, "agregar"));
        compradorAdd.alPresionarCancelar(e -> cardLayout.show(this, "listar"));
    }
}
