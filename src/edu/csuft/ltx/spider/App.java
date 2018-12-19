package edu.csuft.ltx.spider;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
	   //pool = Executors.newCachedThreadPool();
	   //一个线程
	   //pool = Executors.newSingleThreadExecutor();
	   
	   ArrayList<Film> list = new ArrayList<>();
	   String url = "https://movie.douban.com/top250?start";
	   
	   for(int i=0;i<10;i++) {
		   String path = String.format("%s=%d", url,i*25);
		   pool.submit(new Spider(path,list));
	   }
	   
	   pool.shutdown();
	   System.out.println(pool.isTerminated());
	   
	   while(!pool.isTerminated()) {
		   //加上休眠设置，每隔一段时间，做一次检测
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	   
	   //数据排序
	   System.out.println(list.size());
	   
	   ExecutorService pool2 = Executors.newFixedThreadPool(4);
	   
	   for(Film film :list) {
		   System.out.println(film.url);
		   pool2.execute(new Spider(film.url,null));
	   }
	   
	   //写入文件
//	   String file = "d:/film.csv";   //绝对路径
//	   file="film.csv";              //相对路径
//	   
//	   //排序
//	   Collections.sort(list);
	   
	   
	   try(FileWriter out = new FileWriter(file)) {
		   //写数据
		   for (Film film : list) {
			   out.write(film.toCSV());
		}
	   System.out.println("ok");
	} catch (Exception e) {
		// TODO: handle exception
	}   
}
}
