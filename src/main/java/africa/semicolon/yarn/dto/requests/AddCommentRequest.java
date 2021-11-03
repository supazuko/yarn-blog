package africa.semicolon.yarn.dto.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddCommentRequest {
    private Integer id;
    private String comment;
    private String commenter;
    private LocalDateTime timeCommented;
}
