package t1.mystartproject.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import t1.mystartproject.acpects.LoggingAspect;
import t1.mystartproject.annotations.Logging;
import t1.mystartproject.properties.LoggingProperties;

@EnableConfigurationProperties(LoggingProperties.class)
@Configuration
public class LoggingAutoConfiguration {

    @Bean
    @ConditionalOnProperty(prefix = "logging.aspect", name = "enabled", havingValue = "true", matchIfMissing = true)
    public LoggingAspect loggingAspect(LoggingProperties loggingProperties) {
        return new LoggingAspect(loggingProperties);
    }
}