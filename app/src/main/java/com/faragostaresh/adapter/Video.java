package com.faragostaresh.adapter;

import java.util.ArrayList;

/**
 * Created by Belal on 11/9/2015.
 * https://www.simplifiedcoding.net/android-custom-listview-with-images-using-recyclerview-and-volley/
 */
public class Video {
    //Data Variables
    private int id;
    private String title;
    private String slug;
    private int time_create;
    private String time_create_view;
    private ArrayList<String> categories;
    private int hits;
    private int recommended;
    private int favourite;
    private String video_duration_view;
    private String body;
    private String channelUrl;
    private String videoUrl;
    private String largeUrl;
    private String qmeryDirect;
    private String qmeryScript;
    private int video_qmery_id;
    private String video_qmery_hash;

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getTimeCreate() {
        return time_create;
    }

    public void setTimeCreate(int time_create) {
        this.time_create = time_create;
    }

    public String getTimeCreateView() {
        return time_create_view;
    }

    public void setTimeCreateView(String time_create_view) {
        this.time_create_view = time_create_view;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> powers) {
        this.categories = categories;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getRecommended() {
        return recommended;
    }

    public void setRecommended(int recommended) {
        this.recommended = recommended;
    }

    public int getFavourite() {
        return favourite;
    }

    public void setFavourite(int favourite) {
        this.favourite = favourite;
    }

    public String getVideoDurationView() {
        return video_duration_view;
    }

    public void setVideoDurationView(String video_duration_view) {
        this.video_duration_view = video_duration_view;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setchannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public String getQmeryDirect() {
        return qmeryDirect;
    }

    public void setQmeryDirect(String qmeryDirect) {
        this.qmeryDirect = qmeryDirect;
    }

    public String getQmeryScript() {
        return qmeryScript;
    }

    public void setQmeryScript(String qmeryScript) {
        this.qmeryScript = qmeryScript;
    }

    public int getVideoQmeryId() {
        return video_qmery_id;
    }

    public void setVideoQmeryId(int video_qmery_id) {
        this.video_qmery_id = video_qmery_id;
    }

    public String getVideoQmeryHash() {
        return video_qmery_hash;
    }

    public void setVideoQmeryHash(String video_qmery_hash) {
        this.video_qmery_hash = video_qmery_hash;
    }
}