package com.seana;

public class Main {

    public static void main(String[] args) {
	    SesSimpleClient sesSimpleClient = new SesSimpleClient();
	    sesSimpleClient.Send();

	    System.out.println("Email Sent!");
    }
}
