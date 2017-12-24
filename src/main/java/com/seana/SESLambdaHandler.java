package com.seana;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SESLambdaHandler implements RequestHandler<Object, String> {
  public String handleRequest(Object input, Context context) {
    LambdaLogger logger = context.getLogger();

    logger.log("Handler Invoked ooo^^^^^^^");
    Runtime.getRuntime().traceMethodCalls(true);

    logger.log("Input below.");
    logger.log(input.toString());

    try {
      SesClient client = new SesClient(logger);
      client.Send();
    } catch (Exception e) {
      logger.log("Exception sending email");
      logger.log(e.toString());

      throw new RuntimeException(e);
    }

    logger.log("Email SENT!!");

    return "TEST DONE!!";
  }
}
