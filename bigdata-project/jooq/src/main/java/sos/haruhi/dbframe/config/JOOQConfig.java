package sos.haruhi.dbframe.config;

import lombok.extern.slf4j.Slf4j;
import org.jooq.ExecuteContext;
import org.jooq.tools.LoggerListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class JOOQConfig {

    @Bean
    public LoggerListener loggerListener() {
        class MyListener extends LoggerListener {
            @Override
            public void end(ExecuteContext ctx) {
                String sql = ctx.sql();
                log.info(sql);
                super.end(ctx);
            }
        }

        return new MyListener();
    }
}
