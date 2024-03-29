package com.team08.enjoytrip.post.model.dto;

import java.sql.Timestamp;
import java.util.List;

import com.team08.enjoytrip.tripRoute.model.dto.TripRouteDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PostDto {
    private int id;
    private int userId;
    private String nickName;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String title;
    private String content;
    private int view;
    private TripRouteDto tripRoute;
    private List<FileInfoDto> fileInfos;

}
