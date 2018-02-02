package su.psergeev77.service.facade.model;

import su.psergeev77.service.facade.client.Client;

import java.util.List;

public class Page {

    private String userName;
    private String firstName;
    private String lastName;

    private List<Post> posts;

    public Page(String userName, String firstName, String lastName, List<Post> posts) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public Page(Client client) {
        this.userName = client.getUserName();
        this.firstName = client.getFirstName();
        this.lastName = client.getLastName();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

class Post {
    private String title;
    private String text;
    private String date;

    public Post(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
