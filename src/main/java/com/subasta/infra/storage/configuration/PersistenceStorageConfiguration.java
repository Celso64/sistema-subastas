package com.subasta.infra.storage.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class PersistenceStorageConfiguration implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(PersistenceStorageConfiguration.class);

    @Value("${spring.storage.path.img}")
    private String imgPath;

    @Override
    public void run(String... args) throws Exception {
        File folder = new File(imgPath);
        if (!folder.exists()) {
            if(folder.mkdirs()){
                log.info("Directorios \"data/\" \"data/img/\" creados.");
            }
        }
    }
}
