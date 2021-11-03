package africa.semicolon.yarn.controllers;

import africa.semicolon.yarn.data.models.Post;
import africa.semicolon.yarn.dto.requests.AddCommentRequest;
import africa.semicolon.yarn.dto.requests.CreatePostRequest;
import africa.semicolon.yarn.dto.responses.CreatePostResponse;
import africa.semicolon.yarn.dto.responses.FindPostResponse;
import africa.semicolon.yarn.services.PostService;
import africa.semicolon.yarn.services.PostServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class PostController {
    private final PostService postService = new PostServiceImpl();

    @PostMapping("/post")
    public CreatePostResponse addPost(@RequestBody CreatePostRequest createPostRequest){
        return postService.addPost(createPostRequest);
    }

    @GetMapping("/post/{id}")
    public FindPostResponse findPostById(@PathVariable("id") Integer id){
        return postService.findPostById(id);
    }

    @PostMapping("/comment")
    public CreatePostResponse addComment(@RequestBody AddCommentRequest addCommentRequest){
        return   postService.addComment(addCommentRequest);
    }

    @DeleteMapping("/post/{id}")
    public void deletePostById(@PathVariable Integer id){
        postService.deletePostById ( id );
    }

    @GetMapping("/api/post")
    public List<Post> findAll(){
        return postService.findAll ();
    }
}
