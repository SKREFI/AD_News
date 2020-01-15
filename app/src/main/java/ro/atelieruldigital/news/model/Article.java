package ro.atelieruldigital.news.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "article_table")
public class Article {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String author;
    private String title;
    @Ignore
    private String description;
    @Ignore
    private String url;
    @Ignore
    private String urlToImage;
    @Ignore
    @ColumnInfo(name = "publishedAt")
    private String date;
    @Ignore
    private String content;

    @Ignore
    public Article(String author, String title, String description, String url, String urlToImage, String date, String content) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.date = date;

        this.content = content;
    }

    public Article(String author, String title){
        this.author = author;
        this.title = title;
    }

    //TODO: Ask Cosmin, este necesar seter pentru ca ID nu este in Constructor?
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
    
    @Ignore
    public String getDescription() {
        return description;
    }
    @Ignore
    public String getUrl() {
        return url;
    }
    @Ignore
    public String getUrlToImage() {
        return urlToImage;
    }
    @Ignore
    public String getDate() {
        return date;
    }
    @Ignore
    public String getContent() {
        return content;
    }
}
