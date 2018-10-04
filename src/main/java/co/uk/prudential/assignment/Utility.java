package co.uk.prudential.assignment;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.validator.routines.UrlValidator;

public class Utility {
	public static String getDomainName(String urlStr) throws MalformedURLException {
		URL url = new URL(urlStr);
		String domain = url.getHost();
		return domain.startsWith("www.") ? domain.substring(4) : domain;
	}

	public static void processDomain(String url) throws Exception {

		URL aURL = new URL(url);

		System.out.println("protocol = " + aURL.getProtocol()); // http
		System.out.println("authority = " + aURL.getAuthority()); // example.com:80
		System.out.println("host = " + aURL.getHost()); // example.com
		System.out.println("port = " + aURL.getPort()); // 80
		System.out.println("path = " + aURL.getPath()); // /docs/books/tutorial/index.html
		System.out.println("query = " + aURL.getQuery()); // name=networking
		System.out.println("filename = " + aURL.getFile()); /// docs/books/tutorial/index.html?name=networking
		System.out.println("ref = " + aURL.getRef()); // DOWNLOADING
	}

	public static void isURLValid(String url) throws MalformedURLException {
		if (!url.startsWith("http://") && !url.startsWith("https://")) {
			url = "http://" + url;
		}
		URL aURL = new URL(url);
		System.out.println("protocol = " + aURL.getProtocol());
		String[] schemes = { "http", "https" }; // DEFAULT schemes = "http",
												// "https", "ftp"
		UrlValidator urlValidator = new UrlValidator(schemes);
		if (urlValidator.isValid(url)) {
			System.out.println(url + " URL is valid");
		} else {
			System.out.println(url + " URL is invalid");
		}
	}

	public static void main(String args[]) throws Exception {
		System.out.println(getDomainName("https://www.www2.google.com"));
		processDomain("https://www.www2.google.com");
		isURLValid("ww.google.com");
	}
}