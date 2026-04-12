package com.subasta.ui.comprador.view;

import com.subasta.core.api.CompradorAPI;
import com.subasta.ui.share.constant.Vista;
import com.subasta.ui.comprador.event.CompradorCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CompradorPanel extends JPanel {

    private final CardLayout cardLayout;

    @Autowired
    public CompradorPanel(CompradorAPI compradorAPI, CompradorList compradorList, CompradorAdd compradorAdd) {
        this.cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(compradorList, Vista.LISTAR.toString());
        add(compradorAdd, Vista.AGREGAR.toString());

        compradorList.alPresionarAgregar(e -> cardLayout.show(this, Vista.AGREGAR.toString()));
        compradorAdd.alPresionarCancelar(e -> cardLayout.show(this, Vista.LISTAR.toString()));
    }

    @EventListener
    public void handleCompradorCreate(CompradorCreate compradorCreate){
        this.cardLayout.show(this, Vista.LISTAR.toString());
    }
}
