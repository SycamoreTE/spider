package edu.csuft.ltx.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderFilmDetail implements Runnable {
	/*
	 * 影片的URL
	 */
	String url;
	
	List<Film> list;

	public SpiderFilmDetail(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}

	@Override
	public void run() {
		
		try {
			Document doc = Jsoup.connect(url).get();
		
			Element e = doc.getElementById("content");
			
			String name = e.selectFirst("h1 span").text();
			String year = e.selectFirst(".year").text();
			
			String director = e.selectFirst("#info .attrs").selectFirst("a").text();
//			String script = e.select("#info span").get(1).select(".attrs a").text();
			String script = e.select("#info .attrs").get(1).text();
			String actor = e.selectFirst(".actor .attrs").text();
			
			System.out.printf("%s,%s,%s,%s,%s\n",
					year,
					name,
					director,
					script,
					actor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
