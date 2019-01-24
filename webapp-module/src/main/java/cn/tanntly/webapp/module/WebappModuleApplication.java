package cn.tanntly.webapp.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"cn.tanntly.dao"} )
@EntityScan("cn.tanntly.entity")
public class WebappModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebappModuleApplication.class, args);
    }

}

