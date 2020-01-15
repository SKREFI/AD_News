package ro.atelieruldigital.news.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import ro.atelieruldigital.news.model.db.ArticleDao;
import ro.atelieruldigital.news.model.db.ArticleRoomDatabase;

public class NewsRepository {

    private ArticleDao mArticleDao;
    private LiveData<List<Article>> mAllArticles;

    public NewsRepository(Application application) {
        ArticleRoomDatabase db = ArticleRoomDatabase.getDatabase(application);
        mArticleDao = db.articleDao();
        mAllArticles = mArticleDao.getArticlesOrderedByDate();
    }

    public LiveData<List<Article>> getAllArticles() {
        return mAllArticles;
    }

    public void insert(Article article) {
        ArticleRoomDatabase.databaseWriteExecutor.execute(() -> {
            mArticleDao.insert(article);
        });
    }
}
