package br.com.geniustest.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ClientConfiguration {

    @Value("${aws.s3.assetsBucket}")
    private String assetsBucket;

    public String getAssetsBucket() {
        return assetsBucket;
    }
}
