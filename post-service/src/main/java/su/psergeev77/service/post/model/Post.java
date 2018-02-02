package su.psergeev77.service.post.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String title;
    private String text;
    private Date date;

    public Post(String userName, String title, String text) {
        this.userName = userName;
        this.title = title;
        this.text = text;
        this.date = new Date();
    }

    public Post() {
    }

    public Post(Long id, String userName, String title, String text, Date date) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
