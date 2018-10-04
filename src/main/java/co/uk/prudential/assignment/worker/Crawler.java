package co.uk.prudential.assignment.worker;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {

	private static final int TRAVERSAL_DEPTH = 2;

	private Set<String> linksToBeCrawled;
	private Set<String> linksAlreadyCrawled;

	private String url;

	public Crawler(String url) {
		this.url = url;
		this.linksToBeCrawled = new HashSet<String>();
		this.linksAlreadyCrawled = new HashSet<String>();
	}

	public void crawlPage() {
		try

		{
			// Get file from resources folder
			String HTML_FILENAME = "input.html";
			ClassLoader classLoader = getClass().getClassLoader();
			File inputHtmlFile = new File(classLoader.getResource(HTML_FILENAME).getFile());
			Document htmlFileDocument = Jsoup.parse(inputHtmlFile, "UTF-8", "http://example.com/");
			Elements htmlFilelinks = htmlFileDocument.select("a[href]");

			Document document = Jsoup.connect(url).get();
			Elements links = document.select("a[href]");
			System.out.println(links.size());

			Elements imgs = document.select("img[src]");
			System.out.println(imgs.size());

			System.out.println(document.title() + " :: List of All Links on Page");
			System.out.println(
					"---------------------------------------------------------------------------------------------");
			for (Element link : links) {
				System.out.println(link.text() + " :: " + link.absUrl("href").toLowerCase());
				linksToBeCrawled.add(link.absUrl("href").toLowerCase());

			}
			System.out.println(linksToBeCrawled.size());

			System.out.println(
					"---------------------------------------------------------------------------------------------");
			for (Element img : imgs) {
				System.out.println(img.attr("alt") + " :: " + img.attr("abs:src"));
			}
		} catch (IOException exp) {
			System.out.println("Exception Occured: " + exp);
		}

	}
}
