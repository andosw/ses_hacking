package com.seana;

import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.util.StringUtils;

public class CustomCredentialsProvider implements AWSCredentialsProvider {

  public AWSCredentials getCredentials() {
    String accessKey = System.getenv("SES_AWS_ACCESS_KEY_ID");
    String secretKey = System.getenv("SES_AWS_SECRET_KEY");

    accessKey = StringUtils.trim(accessKey);
    secretKey = StringUtils.trim(secretKey);

    return new BasicAWSCredentials(accessKey, secretKey);
  }

  public void refresh() {

  }
}
