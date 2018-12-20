package edu.csuft.ltx.spider;

public class Film implements Comparable<Film>{
	/*
	 * 影片名称
	 */
	String info;
	
	
	/*
	 * 相关信息
	 */
	String title;
	
	
	/*
	 * 评分
	 */
	double rating;
	
	
	/*
	 * 评分人数
	 */
	int num;
	
	
	/*
	 * 排名
	 */
	int id;
	
	
	/*
	 * 海报
	 */
	String poster;
	
	
	/*
	 * 短评
	 */
	String quote;
	/*
	 * 影片详细信息
	 */
	String url;


	public String toCSV() {
	    return String.format("%d,%s,%d,%.1f\n",
	    		id,
	    		title,
	    		num,
	    		rating);
	}
	@Override
	public String toString() {
		return "Film [info=" + info + ", title=" + title + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + ", url=" + url + "]";
	}
	@Override
	public int compareTo(Film o) {
		return id - o.id;
	}
	
	

}
