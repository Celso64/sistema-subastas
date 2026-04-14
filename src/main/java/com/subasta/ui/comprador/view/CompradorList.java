package com.subasta.ui.comprador.view;

import com.subasta.core.api.CompradorAPI;
import com.subasta.core.model.Comprador;
import com.subasta.ui.comprador.dto.CompradorShowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class CompradorList extends JPanel {

    private final Integer TAM_FILA = 16;
    private final CompradorAPI compradorAPI;
    private final JButton btn;
    private final JTable table;
    private final String[] titulos;

    @Autowired
    public CompradorList(CompradorAPI compradorAPI) {
        this.compradorAPI = compradorAPI;
        this.table = new JTable();
        this.titulos = CompradorShowDTO.getTitles();
        btn = new JButton("Agregar Comprador");

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
    public void handleUpdateEvent(Comprador comprador){
        loadTable();
    }

    private void loadTable(){
        var datos = compradorAPI.getCompradores()
                .stream()
                .map(CompradorShowDTO::fromModel)
                .map(CompradorShowDTO::toArray)
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
