package icu.shishc.applet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("icu.shishc.applet.mapper")
public class AppletApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppletApplication.class, args);
    }
}
