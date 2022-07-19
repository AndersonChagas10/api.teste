package br.com.geniustest.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;




public class GeniusTestConfiguration {


    @Autowired
    private Environment environment;

    @Value("${aws.s3.storageBucket}")
    private String storageBucket;

    @Value("${aws.s3.assetsBucket}")
    private String assetsBucket;

    @Value("${aws.appsync.baseUrl}")
    private String appSyncBaseUrl;

    public String getStorageBucket() {
        return storageBucket;
    }

    public String getAssetsBucket() {
        return assetsBucket;
    }

    public String getAppSyncBaseUrl() {
        return appSyncBaseUrl;
    }

}
