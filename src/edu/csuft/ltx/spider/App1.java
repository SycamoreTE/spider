package edu.csuft.ltx.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App1 {
	public static void main(String[] args) {
		//1 路径
		String url = "https://movie.douban.com/subject/1292052/";
		//2 Jsoup
		try {
			Document d = Jsoup.connect(url).get();
			
			Elements es = d.select("subject clearfix .info");
			System.out.println(es.size());
			
			ArrayList<Info> list = new ArrayList();
			for(Element e:es){
				
				Info i = new Info();
				i.attrs = e.select(".span pl").first().text();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
