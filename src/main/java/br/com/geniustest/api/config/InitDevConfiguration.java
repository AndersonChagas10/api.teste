package br.com.geniustest.api.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Configuration
@Profile("!prod && !stag")
public class InitDevConfiguration {
    private static final Log logger = LogFactory.getLog(InitDevConfiguration.class);

    @PostConstruct
    public void init() {
        logger.info("Init DEV configurations...");

    }

}
