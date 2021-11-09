package com.example.recipeteam.board;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Post {

    public String uid;
    public String author;
    public String title;
    public String content;
    public Date regdate;

    public Post() {

    }

    public Post(String uid, String author, String title, String content, Date regdate) {
        this.uid = uid;
        this.author = author;
        this.title = title;
        this.content = content;
        this.regdate = regdate;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("author", author);
        result.put("title", title);
        result.put("content", content);
        result.put("regdate", regdate);

        return result;
    }
}
