package sneakpeeq.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.io.IOException;

public class ServerMain {
    public static void main(String... args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        if (ctx.getEnvironment().getActiveProfiles().length == 0) {
            ctx.getEnvironment().setActiveProfiles("server-with-gearman");
        }
        ctx.scan("sneakpeeq.server.config");
        ctx.refresh();
        ctx.start();
    }

}
