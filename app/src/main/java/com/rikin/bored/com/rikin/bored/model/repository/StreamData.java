package com.rikin.bored.com.rikin.bored.model.repository;

import java.util.Date;
import java.util.List;

public class StreamData {

    String id;
    String userId;
    String gameId;
    List<String> communityIds;
    String type;
    String title;
    int viewerCount;
    Date startedAt;
    String language;
    String thumbnailUrl;

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getGameId() {
        return gameId;
    }

    public List<String> getCommunityIds() {
        return communityIds;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getViewerCount() {
        return viewerCount;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public String getLanguage() {
        return language;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
