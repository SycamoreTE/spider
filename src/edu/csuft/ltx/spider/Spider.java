package edu.csuft.ltx.spider;
/**
 * 抓取影片信息的爬虫
 * @author Administrator
 *
 */

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider implements Runnable{
	//页面路径
	String url;
	//存储抓取的数据
	ArrayList<Film> list;
	
	/**
	 * 创建爬虫
	 * 
	 * @param url
	 * @param list
	 */
	public Spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}


	public void run() {
		//获得执行该任务的线程的名称
		String name = Thread.currentThread().getName();
		System.out.println(name +"线程，处理"+url);
		
		//jSOUP
	    try {
	    	
			Document doc = Jsoup.connect(url).get();
			//从文档树中查找节点
			Elements es = doc.select(".grid_view .item");
			for(Element e :es){
				Film f=new Film();
				
				f.id=Integer.parseInt(e.select(".pic em").first().text());
				f.poster=e.select("img").first().attr("src");
				f.info=e.select(".bd p").first().text();
				f.title=e.select(".title").first().text();
				f.rating=Double.parseDouble(e.select(".rating_num").first().text());
				String num= e.select(".star span").last().text();
				f.num = Integer.parseInt(num.substring(0, num.length()-3));
				f.quote=e.select(".inq").first().text();
				f.url=e.select(".pic a").first().attr("href");
				
				
				/*Element t = e.select(".title").first();
				String num1=e.select(".star span").last().text();
				System.out.println(t.text()+","+num1);*/
				
//				f.id
//				f.title
				//System.out.println(name +":"+f);
				list.add(f);
			}
			
			System.out.println(name +"线程：完成"+url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
