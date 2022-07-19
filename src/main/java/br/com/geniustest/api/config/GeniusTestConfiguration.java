package br.com.geniustest.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class GeniusTestConfiguration {

    @Value("${aws.s3.storageBucket}")
    private String storageBucket;

    @Value("${aws.s3.assetsBucket}")
    private String assetsBucket;

    public String getStorageBucket() {
        return storageBucket;
    }

    public String getAssetsBucket() {
        return assetsBucket;
    }
}
