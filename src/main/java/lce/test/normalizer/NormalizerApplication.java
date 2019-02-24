package lce.test.normalizer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class NormalizerApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder (NormalizerApplication.class);
        builder.headless(false);
        ApplicationContext context = builder.run(args);
        RunNormalizer runNormalizer = (RunNormalizer)context.getBean("runNormalizer");
        runNormalizer.start();
    }

}
