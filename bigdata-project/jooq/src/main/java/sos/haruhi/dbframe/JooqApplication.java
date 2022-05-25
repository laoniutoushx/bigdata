package sos.haruhi.dbframe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("sos.haruhi.dbframe.mybatis.mapper")
@SpringBootApplication
public class JooqApplication {
    public static void main(String[] args) {
        SpringApplication.run(JooqApplication.class, args);
    }
}
