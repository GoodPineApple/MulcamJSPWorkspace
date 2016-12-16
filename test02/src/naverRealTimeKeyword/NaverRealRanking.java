package naverRealTimeKeyword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import vo.News;
import vo.RealTimeKeyword;

public class NaverRealRanking {
	private static NaverRealRanking instance = null;

	public static NaverRealRanking getInstance() {
		if (instance == null) {
			instance = new NaverRealRanking();
		}
		return instance;
	}

	private NaverRealRanking() {
	}

	public static Document getDocument(String url) {
		HttpPost http = new HttpPost(url);
		Document doc = null;
		// 2.가져오기를 실행할 클라이언트 객체 생성
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			// 3.실행결과를 response객체에 담기
			HttpResponse httpResponse = httpClient.execute(http);
			// 4.Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
			HttpEntity httpEntity = httpResponse.getEntity();
			// 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴
			ContentType contentType = ContentType.getOrDefault(httpEntity);
			Charset charset = contentType.getCharset();
			// 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은
			// 개인취향)
			BufferedReader br = new BufferedReader(new InputStreamReader(httpEntity.getContent(), "UTF-8"));
			// 8. 가져온 DOM 데이터를 담기위한 그릇
			StringBuffer dom = new StringBuffer();

			// 9. DOM 데이터 가져오기
			String line = "";
			while ((line = br.readLine()) != null) {
				dom.append(line + "\n");
			}
			doc = Jsoup.parse(dom.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}

	public List<RealTimeKeyword> getRealRanking() {
		List<RealTimeKeyword> realTimeKeywordList = new ArrayList<>();
		// 1.가져올 url세팅 (naver)
		Document doc = getDocument("http://www.naver.com");
		Elements elements = doc.select("ol#realrank > li:not(#lastrank) > a");
		for (int i = 0; i < elements.size(); i++) {
			RealTimeKeyword realTimeKeyword = new RealTimeKeyword();
			realTimeKeyword.setRanking(i + 1); // 순위
			realTimeKeyword.setKeyword(elements.get(i).attr("title")); // 검색어
			realTimeKeyword.setKeywordUrl(elements.get(i).attr("href")); // 링크
			realTimeKeywordList.add(realTimeKeyword);
		}
		return realTimeKeywordList;
	}

	public void getNewsList(List<RealTimeKeyword> newsList) {
		for (RealTimeKeyword keyword : newsList) {
			Document doc = null;
			try {
				doc = Jsoup.connect(keyword.getKeywordUrl()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div.news.section > ul.type01 > li");
			if (el != null) {
				// for(int i = 0;i<el.size();i++){
				for (int i = 0; i < 1; i++) {
					News news = new News();
					news.setImgUrl(el.get(i).select("div.thumb > a > img").attr("src"));
					news.setTitle(el.get(i).select("dl > dt > a").attr("title"));
					news.setContent(el.get(i).select("dl > dd:nth-child(3)").text());
					news.setPress(el.get(i).select("dl > dd.txt_inline > span._sp_each_source").text());
					news.setNewsLink(el.get(i).select("dl > dt > a").attr("href"));
					news.setKeyword(keyword.getKeyword());
					// collectNews(news);
					collectNews();
					// System.out.println("기사번호 : "+(i+1));
					// System.out.println(news);
				}
			}
		}
	}

	public void collectNews(News news) {
		Document doc = null;

		if (news.getPress().equals("YTN")) {
			System.out.println("YTN일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div#czone > div#zone1");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					news.setMainTitle(el.get(i).select("div.article_tit").text());
					news.setMainContent(el.get(i).select("div.article_wrap > div.article_paragraph > span").text());
				}
			}
		} else if (news.getPress().equals("마이데일리")) {
			System.out.println("마이데일리일 경우");
			doc = getDocument(news.getNewsLink());
			Elements el = doc.select("div.read_view_wrap");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("dt").first();
					Element contentEl = el.get(i).select("dd > div#article").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}
					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("머니투데이")) {
			System.out.println("머니투데이일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div#article");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("h1").first();
					Element contentEl = el.get(i).select("div#gisa_section > table > tbody > tr > td > div.view_text > div#textBody").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}
					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("노컷뉴스")) {
			System.out.println("노컷뉴스일 경우");
			doc = getDocument(news.getNewsLink());
			Elements el = doc.select("div#pnlWrap");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("div#pnlContainer > div#pnlViewTop > div.reporter_info > h2").first();
					Element contentEl = el.get(i).select("div#pnlContainer > div.content > div#pnlViewBox > div#pnlContent").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}
					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("SBS 뉴스")) {
			System.out.println("SBS 뉴스일 경우");
			doc = getDocument(news.getNewsLink());
			Elements el = doc.select("div.w_article");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("div.w_article_title > h3#vmNewsTitle").first();
					Element contentEl = el.get(i).select("div.w_article_cont > div.w_article_left > div.article_cont_area > div.main_text").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}

					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("스포탈코리아")) {
			System.out.println("스포탈코리아일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div#contentBox01");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("div#reView > h2").first();
					Element contentEl = el.get(i).select("div#DivContents > div#CmAdContent div.review_text02").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}

					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("매일경제")) {
			
		} else if (news.getPress().equals("아시아경제")) {
			System.out.println("아시아경제일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div.view_bg_box");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("div.area_title > h1").first();
					Element contentEl = el.get(i).select("div#bodyContents > div.article > div.txt").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}

					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("스포츠조선")) {
			System.out.println("스포츠조선일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div.deatail1");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("div.acle_c > h1").first();
					Element contentEl = el.get(i).select("div.article > div.news_content > dijv.news_text > font.article").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}

					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("조선일보")) {
			System.out.println("조선일보일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div#csContent");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("header.news_title > div.news_title_text > h1").first();
					Element contentEl = el.get(i).select("article.news_article > div#news_body_id > div.par").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					for(TextNode node : contentEl.textNodes()){
						mainContent += node.text().trim();
					}
					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		} else if (news.getPress().equals("블로터")) {
			System.out.println("블로터일 경우");
			try {
				doc = Jsoup.connect(news.getNewsLink()).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Elements el = doc.select("div.denim__wrapper");
			if (el != null) {
				for (int i = 0; i < el.size(); i++) {
					String mainTitle = "";
					String mainContent = "";
					Element titleEl = el.get(i).select("div.denim--body__container div.article--header__wrapper > header.article--header > div.denim-layout--width.denim-layout--adjust-width > h1").first();
					for(TextNode node : titleEl.textNodes()){
						mainTitle += node.text().trim();
					}
					mainContent = el.get(i).select("div.denim--body__container div.article--body__wrapper.denim-layout--width.denim-layout--adjust-width > div.denim-layout--pannel__container > div.denim-layout--pannel.denim-layout--with-sidebar > div.article--content").text();
					news.setMainTitle(mainTitle);
					news.setMainContent(mainContent);
				}
			}
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void collectNews() {
//		Document doc = null;
////		doc = getDocument("http://news.sbs.co.kr/news/endPage.do?news_id=N1003892343&plink=STAND&cooper=NAVER");
////		 System.out.println(doc);
//		 try {
//		 doc =
//		 Jsoup.connect("http://uk.reuters.com/article/uk-southkorea-politics-endgame-idUKKBN13A0V1").get();
////		 System.out.println(doc);
//		 } catch (IOException e) {
//		 e.printStackTrace();
//		 }
//		 Elements el = doc.select("div#content");
////		 System.out.println("el : "+el);
//		if (el != null) {
//			for (int i = 0; i < el.size(); i++) {
//				String mainTitle = "";
//				String mainContent = "";
//				Element titleEl = el.get(i).select("section > div#rcs-articleHeader > div.column1.col.col-10 > div.article-header > h1").first();
//				Element contentEl = el.get(i).select("section > div#rcs-articleContent > div.column1.col.col-10 > span#article-text > p").first();
//				for(TextNode node : titleEl.textNodes()){
//					mainTitle += node.text().trim();
//				}
//				for(TextNode node : contentEl.textNodes()){
//					mainContent += node.text().trim();
//				}
//				System.out.println("title : " + mainTitle + " content : " + mainContent);
//			}
//		}
		Document doc = null;
//		doc = getDocument("http://news.joins.com/article/20872158");
//		 System.out.println(doc);
		 try {
		 doc =
		 Jsoup.connect("http://www.bloter.net/archives/267735").get();
//		 System.out.println(doc);
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 Elements el = doc.select("div.denim__wrapper");
		 System.out.println(el);
		if (el != null) {
			for (int i = 0; i < el.size(); i++) {
				String title = el.get(i).select("div.denim--body__container div.article--header__wrapper > header.article--header > div.denim-layout--width.denim-layout--adjust-width > h1").text();
				String content = el.get(i).select("div.denim--body__container div.article--body__wrapper.denim-layout--width.denim-layout--adjust-width > div.denim-layout--pannel__container > div.denim-layout--pannel.denim-layout--with-sidebar > div.article--content").text();

				System.out.println("title : " + title + "content : " + content);
			}
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
//		NewsCrawlingThread thread = new NewsCrawlingThread();
//		thread.run();
		collectNews();
	}
}

class NewsCrawlingThread extends Thread {
	@Override
	public void run() {
		int i = 1;
		while (true) {
			System.out.println(i + "번째 크롤링");
			NaverRealRanking n = NaverRealRanking.getInstance();
			List<RealTimeKeyword> realTimeKeywordList = n.getRealRanking();
			n.getNewsList(realTimeKeywordList);
			i++;
			try {
				Thread.sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
