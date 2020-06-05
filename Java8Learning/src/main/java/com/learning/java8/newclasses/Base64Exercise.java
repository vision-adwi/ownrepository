package com.learning.java8.newclasses;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.UUID;

public class Base64Exercise {

	public static void main(String[] args) {
		String plainMsg = "Hi\nI am doing great.";
		String originalUrl = "https://www.google.co.nz/?gfe_rd=cr&ei=dzbFV&gws_rd=ssl#q=java";
		String mimeInput = getMimeBuffer().toString();
		
		
		Encoder encoder = Base64.getEncoder();
		Decoder decoder = Base64.getDecoder();
		encryptDecrypt(encoder, decoder, plainMsg);
		
		encoder = Base64.getUrlEncoder();
		decoder = Base64.getUrlDecoder();
		//encryptDecrypt(encoder, decoder, originalUrl);
		
		encoder = Base64.getMimeEncoder();
		decoder = Base64.getMimeDecoder();
		//encryptDecrypt(encoder, decoder, mimeInput);
	}
	
	private static void encryptDecrypt(Encoder encoder, Decoder decoder, String message) {
		System.out.println("Original content:\n" + message);
		
		String encodedString = encoder.encodeToString(message.getBytes());
		System.out.println("\nEncrypted:\n" + encodedString);

		byte[] msg = decoder.decode(encodedString);
		System.out.println("\nDecrypted:\n" + new String(msg));
	}
	
	private static StringBuilder getMimeBuffer() {
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<10; i++) {
			builder.append(UUID.randomUUID().toString());
		}
		
		return builder;
	}

}
