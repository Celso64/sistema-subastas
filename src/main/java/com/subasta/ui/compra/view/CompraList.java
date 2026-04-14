package com.subasta.ui.compra.view;

import com.subasta.core.api.CompraAPI;
import com.subasta.core.model.Oferta;
import com.subasta.ui.compra.dto.OfertaShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class CompraList extends JPanel {

    private final Integer TAM_FILA = 16;
    private final CompraAPI compraAPI;
    private final JButton btn;
    private final JTable table;
    private final String[] titulos;

    @Autowired
    public CompraList(CompraAPI compraAPI) {

        this.compraAPI = compraAPI;
        this.table = new JTable();
        this.titulos = OfertaShowDTO.getTitles();
        btn = new JButton("Agregar Compra");

        setLayout(new BorderLayout());
        loadTable();
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        add(btn, BorderLayout.SOUTH);
        add(scrollPane);
    }

    public void alPresionarAgregar(ActionListener listener) {
        btn.addActionListener(listener);
    }

    @EventListener
    public void handleUpdateEvent(Oferta oferta){
        loadTable();
    }

    private void loadTable(){
        var datos = compraAPI.listarOfertas()
                .stream()
                .map(OfertaShowDTO::fromModel)
                .map(OfertaShowDTO::toArray)
                .toArray(Object[][]::new);

        DefaultTableModel model = new DefaultTableModel(datos, titulos){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        Integer cantidadFilas = datos.length;
        table.setPreferredScrollableViewportSize(new Dimension(800, TAM_FILA*cantidadFilas));
    }
}
