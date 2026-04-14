package com.subasta.ui.compra.view;

import com.subasta.core.api.CompraAPI;
import com.subasta.core.api.CompradorAPI;
import com.subasta.core.model.Comprador;
import com.subasta.ui.compra.event.OfertaCreate;
import lombok.Getter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

@Component
public class CompraAdd extends JPanel {

    private JButton btn;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JComboBox<String> comboCategoria;
    private JButton btnEnviar;

    private final ApplicationEventPublisher eventPublisher;

    private final CompradorAPI compradorAPI;
    private final CompraAPI compraAPI;
    private Map<String, Comprador> compradores;
    @Getter
    private Boolean sinCompradores = true;

    public CompraAdd(CompraAPI compraAPI, CompradorAPI compradorAPI, ApplicationEventPublisher applicationEventPublisher) {
        this.compraAPI = compraAPI;
        this.compradorAPI = compradorAPI;
        this.eventPublisher = applicationEventPublisher;

        if(compradorAPI.hayCompradores()){
            sinCompradores = false;
        }

        add(new JLabel("Formulario de Nueva Compra"));
        btn = new JButton("Volver a lista");
        add(btn);

        setLayout(new GridLayout(7, 2, 10, 10)); // 5 filas, 2 columnas

        // 1. Campo String (Nombre)
        add(new JLabel("Nombre de Carta:"));
        txtNombre = new JTextField();
        add(txtNombre);

        // 3. Campo Double (Precio)
        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        // 4. ComboBox (Categoría)
        add(new JLabel("Comprador:"));
//        String[] opciones = compradores.keySet().toArray(new String[0]);
//        comboCategoria = new JComboBox<>(opciones);

        comboCategoria = new JComboBox<>();
        loadCombobox();
        add(comboCategoria);

        // 5. Botón de acción
        btnEnviar = new JButton("Guardar Compra");
        add(new JLabel("")); // Espacio vacío
        add(btnEnviar);

        // Evento del botón
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarDatos();
                eventPublisher.publishEvent(new OfertaCreate());
            }
        });
    }

    public void alPresionarCancelar(ActionListener listener) {
        btn.addActionListener(listener);
    }

    @EventListener
    public void handleUpdateEvent(Comprador comprador){
        sinCompradores = false;
        loadCombobox();
    }

    private void procesarDatos() {
        try {
            // Conversión a String
            String nombre = txtNombre.getText();

            // Conversión a Double
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            // Obtener valor del ComboBox
            String categoria = (String) comboCategoria.getSelectedItem();
            Comprador c = compradores.get(categoria);

            compraAPI.agregarCompra(nombre, c.getId().toString(), precio, c.getContacto());

            // Mostrar resultado
            String mensaje = String.format("Datos guardados:\nNombre: %s\nPrecio: %.2f\nCategoría: %s",
                    nombre, precio, categoria);

            JOptionPane.showMessageDialog(this, mensaje);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error: Verifique el formato de UUID o del Precio.", "Error de conversión", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCombobox(){
        var listaCompradores = compradorAPI.getCompradores();
        compradores = new HashMap<>();

        for (Comprador c: listaCompradores){
            compradores.put(c.getNombre(), c);
        }

        List<String> claves = compradores.keySet().stream().toList();

        String[] opciones = new String[claves.size()];

        for(int i= 0; i<claves.size(); i++){
            opciones[i] = claves.get(i);
        }
        comboCategoria.setModel(new DefaultComboBoxModel<>(opciones));
    }


}
