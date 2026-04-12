package com.subasta;

import com.subasta.core.api.CompraAPI;
import com.subasta.core.api.CompradorAPI;
import com.subasta.ui.Ventana;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.awt.*;
import java.util.UUID;

@SpringBootApplication
public class SubastaApplication implements CommandLineRunner {

    private CompradorAPI compradorAPI;
    private CompraAPI compraAPI;

    public SubastaApplication(CompradorAPI compradorAPI, CompraAPI compraAPI) {
        this.compradorAPI = compradorAPI;
        this.compraAPI = compraAPI;
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(SubastaApplication.class)
                .headless(false)
                .run(args);

        EventQueue.invokeLater(() -> {
            Ventana frame = context.getBean(Ventana.class);
            frame.setVisible(true);
        });
	}

    @Override
    public void run(String... args) throws Exception {
        addOferta();
    }

    private void addC(){
        compradorAPI.agregarComprador("Celso", new byte[1]);
        compradorAPI.agregarComprador("Daniel", new byte[1]);
        compradorAPI.agregarComprador("Eduardo", new byte[1]);
        compradorAPI.agregarComprador("Leo", new byte[1]);
    }

    private void addOferta(){
        compraAPI.agregarCompra("Pikachu", UUID.randomUUID().toString(), 1000.0, "2934 465657");
    }
}
