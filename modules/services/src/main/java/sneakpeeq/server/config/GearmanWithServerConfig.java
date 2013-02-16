package sneakpeeq.server.config;

import org.gearman.Gearman;
import org.gearman.GearmanServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
@Lazy
@Profile("server-with-gearman")
public class GearmanWithServerConfig {

    @Bean
    public Gearman gearmanInstance() {
        return Gearman.createGearman();
    }
    @Bean
    public GearmanServer gearmanServer() throws IOException {
        return gearmanInstance().startGearmanServer();
    }

    @PreDestroy
    private void preDestroy() {
        gearmanInstance().shutdown();
    }


}
