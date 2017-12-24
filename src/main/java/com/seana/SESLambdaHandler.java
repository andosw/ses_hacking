package com.seana;

import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SESLambdaHandler implements RequestHandler<Request, String> {
  public String handleRequest(Request request, Context context) {
    System.out.println("Handler Invoked.");

    SesClient client = new SesClient();
    client.Send();
    System.out.println("Email SENT!!");

    return "Sent!!";

  }
}
