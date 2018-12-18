package edu.csuft.ltx.spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 * 
 * @author Administrator
 *
 */
public class App {
	
	//alt+/ 提示
   public static void main(String[] args) {
	   
	   ExecutorService pool = Executors.newFixedThreadPool(4);
	   //无限缓存
	   pool = Executors.newCachedThreadPool();
	   //一个线程
	   //pool = Executors.newSingleThreadExecutor();
	   
	   for(int i=1;i<=100;i++) {
		   pool.submit(new Task(i)); 
	   }
	   
	   
	   
	   
	   
	   
	   
//	   Thread thread1=new Thread(new Runnable){
//		   @Override
//		   public void run() {
//			   System.out.println("吉他");
//		   }
//	   }
//	   Thread thread1=new Thread(new Runnable){
//		   @Override
//		   public void run() {
//			   System.out.println("鼓");
//		   }
//	   }
	
	   //目标URL
//	   String url="https://movie.douban.com/top250";
//	   
//	   //jsoup抓取文件
//	  
//	   try {
//		Document doc=Jsoup.connect(url).get();
//		
//		Elements es = doc.select(".grid_view .item");
//		System.out.println(es.size());
//		
//		
//		ArrayList<Film> list = new ArrayList<>();
//		
//		for(Element e :es){
//			Film f=new Film();
//			
//			f.id=Integer.parseInt(e.select(".pic em").first().text());
//			f.poster=e.select("img").first().attr("src");
//			f.info=e.select(".bd p").first().text();
//			f.title=e.select(".title").first().text();
//			f.rating=Double.parseDouble(e.select(".rating_num").first().text());
//			String num= e.select(".star span").last().text();
//			f.num = Integer.parseInt(num.substring(0, num.length()-3));
//			f.quote=e.select(".inq").first().text();
//			
//			
//			/*Element t = e.select(".title").first();
//			String num1=e.select(".star span").last().text();
//			System.out.println(t.text()+","+num1);*/
//			
////			f.id
////			f.title
//			System.out.println(f);
//			list.add(f);
//		}
//		
////		String title=doc.title();
////		String data=doc.data();
//		
////		System.out.println(title);
////		System.out.println(data);
//		
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	   
	   
}
}
