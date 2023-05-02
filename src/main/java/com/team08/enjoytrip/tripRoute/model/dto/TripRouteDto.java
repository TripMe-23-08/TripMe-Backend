package com.team08.enjoytrip.tripRoute.model.dto;

import java.sql.Timestamp;
import java.util.List;

public class TripRouteDto {
    private int id;
    private String name;
    private Timestamp createdAt;
    private int userId;
    private String tripImgUrl;
    private List<TripPlaceDto> tripPlaces;

    public TripRouteDto() {
    }

    public TripRouteDto(int id, String name, Timestamp createdAt, int userId, String tripImgUrl, List<TripPlaceDto> tripPlaces) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.userId = userId;
        this.tripImgUrl = tripImgUrl;
        this.tripPlaces = tripPlaces;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public int getUserId() {
        return userId;
    }

    public String getTripImgUrl() {
        return tripImgUrl;
    }

    public List<TripPlaceDto> getTripPlaces() {
        return tripPlaces;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setTripImgUrl(String tripImgUrl) {
        this.tripImgUrl = tripImgUrl;
    }

    public void setTripPlaces(List<TripPlaceDto> tripPlaces) {
        this.tripPlaces = tripPlaces;
    }

    @Override
    public String toString() {
        return "TripRouteDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", userId=" + userId +
                ", tripImgUrl='" + tripImgUrl + '\'' +
                ", tripPlaces=" + tripPlaces +
                '}';
    }
}
