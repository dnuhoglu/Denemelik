package com.denemelik.demo;

        import com.denemelik.demo.config.TokenProvider;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.Bean;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

        import javax.annotation.PostConstruct;
        import java.util.TimeZone;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
