package ro.atelieruldigital.news.model.db;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ro.atelieruldigital.news.model.Article;
import ro.atelieruldigital.news.model.NewsRepository;

public class ArticleViewModel extends AndroidViewModel {

    private NewsRepository mRepository;
    private LiveData<List<Article>> mAllArticles;

    public ArticleViewModel(Application application) {
        super(application);
        mRepository = new NewsRepository(application);
        mAllArticles = mRepository.getAllArticles();
    }

    public LiveData<List<Article>> getAllArticles() {
        return mAllArticles;
    }

    public void insert(Article article) {
        mRepository.insert(article);
    }
}
