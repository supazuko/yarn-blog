package africa.semicolon.yarn.services;

import africa.semicolon.yarn.dto.requests.AddCommentRequest;
import africa.semicolon.yarn.dto.responses.CreatePostResponse;

public interface CommentService {
    CreatePostResponse addComment(AddCommentRequest addCommentRequest);
}
