package com.nithin.testLinks;

import java.net.HttpURLConnection;
import java.net.URL;

public class VerifyLinkStatusCode {
	public static int invalidLinkCount;

	public static void verifylinks(String link) {
		if (link != null && !link.isEmpty()) {
			try {
				URL url = new URL(link);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			
//			Set Timeout
				connection.setConnectTimeout(3000);
//	Set request method to HEAD to check only the headers not the entire content
				connection.setRequestMethod("HEAD");

				connection.connect();

				if (connection.getResponseCode() == 200) {

				} else {
					System.out.println(
							link + " : " + connection.getResponseMessage() + " : " + connection.HTTP_NOT_FOUND);
					invalidLinkCount++;
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public static void getInvalidLinkCount() {
		System.out.println("Total invalid links are: " + invalidLinkCount);
	}
}
