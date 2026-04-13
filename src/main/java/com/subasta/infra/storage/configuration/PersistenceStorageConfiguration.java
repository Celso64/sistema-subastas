package com.subasta.infra.storage.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class PersistenceStorageConfiguration implements CommandLineRunner {

    @Value("${spring.storage.base-path")
    private String basePath;

    @Value("${spring.storage.img-path")
    private String imgPath;

    @Override
    public void run(String... args) throws Exception {
        File folder = new File(imgPath);
        if (!folder.exists()) {
            folder.mkdirs(); // Esto crea 'data' y 'img' de una
        }
    }
}
