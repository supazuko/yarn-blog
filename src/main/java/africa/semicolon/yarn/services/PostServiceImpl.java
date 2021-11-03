package africa.semicolon.yarn.services;

import africa.semicolon.yarn.data.models.Comment;
import africa.semicolon.yarn.data.models.Post;
import africa.semicolon.yarn.data.repositories.CommentRepository;
import africa.semicolon.yarn.data.repositories.PostRepository;
import africa.semicolon.yarn.dto.requests.AddCommentRequest;
import africa.semicolon.yarn.dto.requests.CreatePostRequest;
import africa.semicolon.yarn.dto.responses.CreatePostResponse;
import africa.semicolon.yarn.dto.responses.FindPostResponse;
import africa.semicolon.yarn.exceptions.BlogException;
import africa.semicolon.yarn.utilities.ModelMapper;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService{
    private final PostRepository postRepository = new PostRepository();
    private final CommentRepository commentRepository = new CommentRepository();

    @Override
    public CreatePostResponse addPost(CreatePostRequest createPostRequest) {
        Post post = ModelMapper.map(createPostRequest);
        post = postRepository.save(post);
        return ModelMapper.map(post);
    }

    @Override
    public FindPostResponse findPostById(Integer id) {
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty()) throw new BlogException("Post does not exist");
        return ModelMapper.mapFindPostResponse(post.get());
    }

    @Override
    public CreatePostResponse addComment(AddCommentRequest addCommentRequest) {
        Optional<Post> post = postRepository.findById(addCommentRequest.getId());
        if(post.isEmpty()) throw new BlogException("Post does not exist");
        Comment comment = ModelMapper.map(addCommentRequest);
        comment = commentRepository.save(comment);
        Post updatedPost = post.get();
        post.get().getComments().add(comment);
        postRepository.save(updatedPost);
        return ModelMapper.map(updatedPost);
    }

    @Override
    public void deletePostById(Integer id) {
        postRepository.delete(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
