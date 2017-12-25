package com.seana;

public class Main {

    public static void main(String[] args) {
	    SesClient sesClient = new SesClient();
	    sesClient.Send();

	    System.out.println("Email Sent!");
    }
}
