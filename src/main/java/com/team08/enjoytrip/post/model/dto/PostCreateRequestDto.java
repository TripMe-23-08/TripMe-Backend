package com.team08.enjoytrip.post.model.dto;

import lombok.*;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class PostCreateRequestDto {
    private int postId;
    private String title;
    private String content;
    private int tripRouteId;
    private int userId; // jwt에서 받아옴
    private List<FileInfoDto> fileInfos;
}
