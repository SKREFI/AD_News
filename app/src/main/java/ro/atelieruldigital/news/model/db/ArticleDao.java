package ro.atelieruldigital.news.model.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import ro.atelieruldigital.news.model.Article;

@Dao
public interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Article article);

    @Query("DELETE FROM article_table")
    void deleteAll();

    @Query("SELECT * from article_table ORDER BY title ASC")
    LiveData<List<Article>> getArticlesOrderedByDate();
}
