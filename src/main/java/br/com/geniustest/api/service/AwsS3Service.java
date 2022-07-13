package br.com.geniustest.api.service;

import br.com.geniustest.api.config.AwsClientConfiguration;
import br.com.geniustest.api.enums.ImageContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


@Service
public class AwsS3Service {
    private final Logger logger = LoggerFactory.getLogger(AwsS3Service.class);

    @Autowired
    private AwsClientConfiguration awsClientConfiguration;

    public void upload(String bucketName, String key, ImageContentType contentType, byte[] fileBytes) {
        try {
            Map<String, String> metadata = new HashMap<>();
            metadata.put("Content-Type", contentType.contentType);

            PutObjectRequest objectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(key)
                    .metadata(metadata)
                    .build();

            awsClientConfiguration.getS3Client().putObject(objectRequest, RequestBody.fromBytes(fileBytes));
        } catch (AwsServiceException | SdkClientException e) {
            logger.error(e.getMessage());
        }
    }

    public URL getPresignUrl(String bucketName, String key, Duration duration) {
        URL url = null;

        try {
            GetObjectRequest getObjectRequest =
                    GetObjectRequest.builder()
                            .bucket(bucketName)
                            .key(key)
                            .build();

            GetObjectPresignRequest getObjectPresignRequest = GetObjectPresignRequest.builder()
                    .signatureDuration(duration)
                    .getObjectRequest(getObjectRequest)
                    .build();

            url = awsClientConfiguration.getS3Presigner().presignGetObject(getObjectPresignRequest).url();
        } catch (AwsServiceException | SdkClientException e) {
            logger.error(e.getMessage());
        }

        return url;
    }

}
