package com.jsf.javaandmysql.model;

import java.util.Date;

/**
 *
 * @author edwin
 */
public class Message {
    private int id;
    private String message;
    private String author;
    private Date date;
    
    public Message(){ }
    
    public Message(String message, String author) {
        this.message = message;
        this.author = author;
        this.date = new Date();
    }

    public Message(int id, String message, String author, Date date) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }
    
    public Date getActuallyDate() {
        this.date = new Date();
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
