package com.subasta;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.subasta.ui.Ventana;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.io.File;

@Slf4j
@SpringBootApplication
public class SubastaApplication{

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        checkOrGenerateFolders();
        var context = buildContext(args);
        setTheme(new FlatDarculaLaf());
        createWindow(context);
	}

    private static void checkOrGenerateFolders(){
        File folder = new File("./data/img/");
        if (!folder.exists()) {
            if(folder.mkdirs()){
                log.info("Directorios \"data/\" \"data/img/\" creados.");
            }
        }
    }

    private static ConfigurableApplicationContext buildContext(String[] args){
        return new SpringApplicationBuilder(SubastaApplication.class)
                .headless(false)
                .run(args);
    }
    private static void setTheme(LookAndFeel tema) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(tema);
    }

    private static void createWindow(ConfigurableApplicationContext context){
        EventQueue.invokeLater(() -> {
            Ventana frame = context.getBean(Ventana.class);
            frame.setVisible(true);
        });
    }
}
