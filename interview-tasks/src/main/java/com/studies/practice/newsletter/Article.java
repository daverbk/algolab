package com.studies.practice.newsletter;

public class Article {
    private final int source;
    private String content;

    public Article(int source, String content) {
        this.source = source;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSource() {
        return source;
    }
}

