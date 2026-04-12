package com.subasta.ui.compra.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;

@Component
public class CompraAdd extends JPanel {

    private JButton btn;
    private JTextField txtNombre;
    private JTextField txtID;
    private JTextField txtPrecio;
    private JComboBox<String> comboCategoria;
    private JButton btnEnviar;

    public CompraAdd() {
//        setLayout(new FlowLayout());
        add(new JLabel("Formulario de Nueva Compra"));
        btn = new JButton("Volver a lista");
        add(btn);

        setLayout(new GridLayout(7, 2, 10, 10)); // 5 filas, 2 columnas

        // 1. Campo String (Nombre)
        add(new JLabel("Nombre de Carta:"));
        txtNombre = new JTextField();
        add(txtNombre);

//        // 2. Campo UUID (Identificador)
//        add(new JLabel("ID (UUID):"));
//        txtID = new JTextField(UUID.randomUUID().toString()); // Sugerimos uno por defecto
//        add(txtID);

        // 3. Campo Double (Precio)
        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        // 4. ComboBox (Categoría)
        add(new JLabel("Comprador:"));
        String[] opciones = {"Electrónica", "Hogar", "Libros"};
        comboCategoria = new JComboBox<>(opciones);
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
            }
        });
    }

    public void alPresionarCancelar(ActionListener listener) {
        btn.addActionListener(listener);
    }

    private void procesarDatos() {
        try {
            // Conversión a String
            String nombre = txtNombre.getText();

//            // Conversión a UUID
//            UUID id = UUID.fromString(txtID.getText().trim());

            // Conversión a Double
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            // Obtener valor del ComboBox
            String categoria = (String) comboCategoria.getSelectedItem();

            // Mostrar resultado
            String mensaje = String.format("Datos guardados:\nNombre: %s\nPrecio: %.2f\nCategoría: %s",
                    nombre, precio, categoria);

            JOptionPane.showMessageDialog(this, mensaje);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Error: Verifique el formato de UUID o del Precio.", "Error de conversión", JOptionPane.ERROR_MESSAGE);
        }
    }
}
