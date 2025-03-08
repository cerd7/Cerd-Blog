package org.cerdBlog.blogServer.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class PostDTO {
    private Long id;
    private String name;
    private String content;
    private String postedBy;
    private String img;
    private Date date;
    private int likeCount;
    private int viewCount;
    private List<String> tags;
}
