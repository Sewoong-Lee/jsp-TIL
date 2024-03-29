package ex12_api;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

public class Ex03_NaverCrawling {

	public static void main(String[] args) throws IOException {
		// 네이버 랭킹 뉴스 크롤링
		//Jsoup 라이브러리 이용
		
		String url = "https://news.naver.com/main/ranking/popularDay.nhn?mid=etc&sid1=111";
		Document doc = Jsoup.connect(url).get();
		
		//System.out.println(doc);
		
		//가져올 내용의 div
		Elements selteg = doc.select("div.rankingnews_box");
		//System.out.println(teg);
		
		for(Element row : selteg) {
			//System.out.println("------------------------");
			//System.out.println(row);
			
			//언론사명
			Elements rowele = row.getElementsByClass("rankingnews_name");
			//System.out.println(rowele);
			String newsname = rowele.get(0).text();
			//System.out.println(newsname);
			
			//뉴스 타이틀
			Elements rowcontent = row.getElementsByClass("list_title nclicks('RBP.rnknws')");
			//배열을 풀기위한 반복문
			for(Element news : rowcontent) {
				String newscontent = news.text();
				//System.out.println(newscontent);
			}
			Elements listtime = row.getElementsByClass("list_time");
			//System.out.println(listtime);
			for(Element list : listtime) {
				String newstime = list.text();
				System.out.println(newstime);
			}
		}
			
		
	}

}
