package t1.mystartproject.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "logging.aspect")
@Getter
@Setter
public class LoggingProperties {
    private boolean enabled = true;
    private String level = "info";

}