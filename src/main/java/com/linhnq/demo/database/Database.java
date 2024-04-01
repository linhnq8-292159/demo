package com.linhnq.demo.database;

import com.linhnq.demo.entity.Product;
import com.linhnq.demo.repo.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(ProductRepo productRepo) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product( "MacPro M1", 2021, 2000.0, "");
                Product productB = new Product( "MacPro M2", 2021, 2000.0, "");
                logger.info("insert data: " + productRepo.save(productA));
                logger.info("insert data: " + productRepo.save(productB));
            }
        };
    }
}