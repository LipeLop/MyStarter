package t1.mystartproject.acpects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import t1.mystartproject.properties.LoggingProperties;

import java.util.Map;
import java.util.function.Consumer;


@Aspect
@Slf4j
public class LoggingAspect {

    private final Map<String, Consumer<String>> logLevelMap = Map.of(
            "debug", log::debug,
            "info", log::info,
            "warn", log::warn,
            "error", log::error
    );

    private final LoggingProperties loggingProperties;

    public LoggingAspect(LoggingProperties loggingProperties) {
        this.loggingProperties = loggingProperties;
    }

    @Before("@annotation(t1.mystartproject.annotations.Logging)")
    public void logging(JoinPoint joinPoint) {
        logging(String.format("The method %s of class %s was called",
                joinPoint.getSignature().getName(), joinPoint.getTarget().getClass().getName()), loggingProperties.getLevel());
    }
    private void logging(String message, String level) {
        logLevelMap.getOrDefault(level.toLowerCase(), log::info).accept(message);
    }


}
