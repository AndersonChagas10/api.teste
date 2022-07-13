package br.com.geniustest.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AwsClientConfiguration {

    @Bean
    public S3Client getS3Client() {
        return S3Client.builder()
                .region(Region.US_EAST_1)
                .build();
    }

    @Bean
    public S3Presigner getS3Presigner() {
        return S3Presigner.builder()
                .region(Region.US_EAST_1)
                .build();
    }

    @Bean
    public CognitoIdentityProviderClient getCognitoClient() {
        return CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .build();
    }

}
