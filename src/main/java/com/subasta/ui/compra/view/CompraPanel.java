package com.subasta.ui.compra.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CompraPanel extends JPanel {

    @Autowired
    public CompraPanel(CompraList compraList, CompraAdd compraAdd) {
        CardLayout cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(compraList, "listar");
        add(compraAdd, "agregar");

        compraList.alPresionarAgregar(e -> cardLayout.show(this, "agregar"));
        compraAdd.alPresionarCancelar(e -> cardLayout.show(this, "listar"));
    }
}
