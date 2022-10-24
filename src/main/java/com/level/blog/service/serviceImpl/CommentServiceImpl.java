package com.level.blog.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.blog.entity.Comment;
import com.level.blog.entity.Post;
import com.level.blog.exception.ResourceNotFoundException;
import com.level.blog.payload.CommentDto;
import com.level.blog.repository.CommentRepo;
import com.level.blog.repository.PostRepo;
import com.level.blog.service.CommentService;

@Service
public class CommentServiceImpl  implements CommentService{
	@Autowired
	private CommentRepo commentRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private PostRepo postRepo;
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		//TODO don't fetch all data only check the OK id contains or not
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId.toString()));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId.toString()));
		this.commentRepo.delete(com);
		
	}
	
}
