package com.subasta.ui.compra.view;

import com.subasta.ui.compra.event.OfertaCreate;
import com.subasta.ui.share.constant.Vista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CompraPanel extends JPanel {

    private final CardLayout cardLayout;

    @Autowired
    public CompraPanel(CompraList compraList, CompraAdd compraAdd) {
        this.cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(compraList, Vista.LISTAR.toString());
        add(compraAdd, Vista.AGREGAR.toString());

        compraList.alPresionarAgregar(e -> {
            if (compraAdd.getSinCompradores()){
                JOptionPane.showMessageDialog(this, "No hay compradores creados.", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                cardLayout.show(this, Vista.AGREGAR.toString());
            }
        });
        compraAdd.alPresionarCancelar(e -> cardLayout.show(this, Vista.LISTAR.toString()));
    }

    @EventListener
    public void handleOfertaCreate(OfertaCreate ofertaCreate){
        this.cardLayout.show(this, Vista.LISTAR.toString());
    }
}
