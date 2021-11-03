package africa.semicolon.yarn.controllers;

import africa.semicolon.yarn.dto.requests.AddCommentRequest;
import africa.semicolon.yarn.dto.responses.CreatePostResponse;
import africa.semicolon.yarn.services.CommentService;
import africa.semicolon.yarn.services.CommentServiceImpl;
import africa.semicolon.yarn.services.PostService;
import africa.semicolon.yarn.services.PostServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class CommentController {
//    private final PostService commentService = new PostServiceImpl();
//
//    @PostMapping("/comment")
//    public CreatePostResponse addComment(@RequestBody AddCommentRequest addCommentRequest){
//        return commentService.addComment(addCommentRequest);
//    }
}