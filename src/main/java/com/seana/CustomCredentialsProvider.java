package com.seana;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.util.StringUtils;

public class CustomCredentialsProvider implements AWSCredentialsProvider {

  private LambdaLogger logger;

  public CustomCredentialsProvider(LambdaLogger logger) {
    this.logger = logger;
  }

  public AWSCredentials getCredentials() {
    logger.log("Attempting to get first key");
    String accessKey = System.getenv("SES_AWS_ACCESS_KEY_ID");

    logger.log("KEY ACQUIRED" + accessKey.length());
    String secretKey = System.getenv("SES_AWS_SECRET_KEY");

    accessKey = StringUtils.trim(accessKey);
    secretKey = StringUtils.trim(secretKey);

    return new BasicAWSCredentials(accessKey, secretKey);
  }

  public void refresh() {

  }
}
