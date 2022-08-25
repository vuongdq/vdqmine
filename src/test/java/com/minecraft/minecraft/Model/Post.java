package com.minecraft.minecraft.Model;


import java.util.List;

public class Post {
    private Long id;
    private String title;
    private String content;
    private List<String> linkDatas;
    private List<String> imageDatas;

    public Post() {
    }

    public Post(Long id, String title, String content, List<String> linkDatas, List<String> imageDatas) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.linkDatas = linkDatas;
        this.imageDatas = imageDatas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getLinkDatas() {
        return linkDatas;
    }

    public void setLinkDatas(List<String> linkDatas) {
        this.linkDatas = linkDatas;
    }

    public List<String> getImageDatas() {
        return imageDatas;
    }

    public void setImageDatas(List<String> imageDatas) {
        this.imageDatas = imageDatas;
    }
}
