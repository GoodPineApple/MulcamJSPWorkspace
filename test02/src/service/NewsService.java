package service;

import dao.NewsDao;
import vo.News;

public class NewsService {
	private static NewsService instance = new NewsService();
	private NewsService(){}
	public static NewsService getInstance(){
		return instance;
	}
	private NewsDao dao = NewsDao.getInstance();
	public int collect(String url){
		News news = dao.select(url);
		int result = 0;
		return result;
	}
}
