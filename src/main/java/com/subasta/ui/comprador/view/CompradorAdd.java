package com.subasta.ui.comprador.view;

import com.subasta.core.api.CompradorAPI;
import com.subasta.ui.comprador.event.CompradorCreate;
import com.subasta.ui.share.util.Icon;
import com.subasta.ui.share.util.FindIcon;
import com.subasta.ui.share.util.ScaleIcon;
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

        var layout = new GridBagLayout();
        var layoutConstrains = new GridBagConstraints();

        layoutConstrains.insets = new Insets(100, 0, 100, 0);
        layoutConstrains.fill = GridBagConstraints.BOTH;
        layoutConstrains.weightx = 1.0;
        layoutConstrains.weighty = 1.0;

        layout.setConstraints(this, layoutConstrains);

        setLayout(layout);

        JPanel panel = new JPanel(new GridLayout(3, 2, 0, 24));
        panel.setVisible(true);

        add(new JLabel("Formulario de Nuevo Comprador"));
        add(panel);



//        panel.add(new JLabel(""));


        panel.add(new JLabel("Nombre de Comprador:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Numero de contacto:"));
        txtContacto = new JTextField();
        panel.add(txtContacto);

        btn = new JButton("Volver a lista");
        FindIcon.getIcon(Icon.ATRAS).ifPresent(imageIcon -> btn.setIcon(ScaleIcon.scale(imageIcon, ScaleIcon.ICONO_SMALL, ScaleIcon.ICONO_SMALL)));
        panel.add(btn);

        // 5. Botón de acción
        btnEnviar = new JButton("Guardar Comprador");
        FindIcon.getIcon(Icon.GUARDAR).ifPresent(imageIcon -> btnEnviar.setIcon(ScaleIcon.scale(imageIcon, ScaleIcon.ICONO_SMALL, ScaleIcon.ICONO_SMALL)));
        panel.add(btnEnviar);

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
