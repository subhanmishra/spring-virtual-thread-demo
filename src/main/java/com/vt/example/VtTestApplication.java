package com.vt.example;

import com.vt.example.entity.Product;
import com.vt.example.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class VtTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtTestApplication.class, args);
    }

    @Bean
    public ApplicationRunner demo(ProductRepository repository) {
        return (args) -> {
            long id = 1000L;
            long price = 1000L;
            for(int i=0; i<100; i++){
                Product product = new Product(id + Integer.toUnsignedLong(i), "Name" + i, price + Integer.toUnsignedLong(i));
                repository.save(product);
            }
        };
    }


//    @Bean
//    public TomcatProtocolHandlerCustomizer<?> tomcatProtocolHandlerCustomizer() {
//        return protocolHandler -> {
//            protocolHandler.setExecutor(Executors.newVirtualThreadPerTaskExecutor());
//        };
//    }

}
