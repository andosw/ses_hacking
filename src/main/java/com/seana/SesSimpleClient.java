package com.seana;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;

public class SesSimpleClient {

  private final AmazonSimpleEmailService simpleEmailService;

  static final String FROM = "andosw@gmail.com";
  static final String TO = "andosw@gmail.com";

  static final String BOUNCE_TO = "bounce@simulator.amazonses.com";
  static final String OOTO_TO = "ooto@simulator.amazonses.com";
  static final String COMPLAINT_TO = "complaint@simulator.amazonses.com";
  static final String SUPPRESSION_TO = "complaint@simulator.amazonses.com";

  static final String SUBJECT = "Amazon SES prototype test w/ Lambda";

  // The HTML body for the email.
  static final String HTMLBODY = "<h1>Amazon SES test (AWS SDK for Java)</h1>"
      + "<p>This email was sent with <a href='https://aws.amazon.com/ses/'>"
      + "Amazon SES</a> using the <a href='https://aws.amazon.com/sdk-for-java/'>"
      + "AWS SDK for Java</a>";

  // The email body for recipients with non-HTML email clients.
  static final String TEXTBODY = "This email was sent through Amazon SES "
      + "using the AWS SDK for Java.";

  static final String CONFIGSET = "basic_config_set";

  public SesSimpleClient() {

    AWSCredentialsProvider credentialsProvider = new CustomCredentialsProvider();

    simpleEmailService = AmazonSimpleEmailServiceClientBuilder.standard()
        .withCredentials(credentialsProvider)
        .withRegion(Regions.US_WEST_2.getName())
        .build();
  }

  public void Send() {
    SendEmailRequest request = new SendEmailRequest()
        .withDestination(
            new Destination().withToAddresses(TO))
        .withMessage(new Message()
            .withBody(new Body()
                .withHtml(new Content()
                    .withCharset("UTF-8").withData(HTMLBODY))
                .withText(new Content()
                    .withCharset("UTF-8").withData(TEXTBODY)))
            .withSubject(new Content()
                .withCharset("UTF-8").withData(SUBJECT)))
        .withSource(FROM)
        .withTags(new MessageTag()
            .withName("Custom-Tag-Name-Foo")
            .withValue("FOOBARBAZ"))
        .withConfigurationSetName(CONFIGSET);


    simpleEmailService.sendEmail(request);
  }
}
