package com.subasta.ui.comprador.view;

import com.subasta.core.api.CompradorAPI;
import com.subasta.ui.comprador.event.CompradorCreate;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CompradorAdd extends JPanel {
    private JButton btn;
    private JTextField txtNombre;
    private JTextField txtContacto;
    private JButton btnEnviar;

    private final CompradorAPI compradorAPI;

    private ApplicationEventPublisher eventPublisher;

    public CompradorAdd(CompradorAPI compradorAPI, ApplicationEventPublisher applicationEventPublisher) {

        this.compradorAPI = compradorAPI;
        this.eventPublisher = applicationEventPublisher;

        add(new JLabel("Formulario de Nueva Compra"));
        btn = new JButton("Volver a lista");
        add(btn);

        setLayout(new GridLayout(7, 2, 10, 10)); // 5 filas, 2 columnas

        add(new JLabel("Nombre de Comprador:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Numero de contacto:"));
        txtContacto = new JTextField();
        add(txtContacto);


        // 5. Botón de acción
        btnEnviar = new JButton("Guardar Compra");
        add(new JLabel("")); // Espacio vacío
        add(btnEnviar);

        // Evento del botón
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarDatos();
                eventPublisher.publishEvent(new CompradorCreate());
            }
        });
    }

        public void alPresionarCancelar(ActionListener listener) {
            btn.addActionListener(listener);
        }

        private void procesarDatos() {
            try {
                String nombre = txtNombre.getText();
                String contacto = txtContacto.getText();

                compradorAPI.agregarComprador(nombre, new byte[0], contacto);

                // Mostrar resultado
                String mensaje = String.format("Datos guardados:\nNombre: %s\nContacto: %s",
                        nombre, contacto);

                JOptionPane.showMessageDialog(this, mensaje);

            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Error: Verifique el formato de UUID o del Precio.", "Error de conversión", JOptionPane.ERROR_MESSAGE);
            }
        }
}
