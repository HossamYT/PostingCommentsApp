/**
 * 
 */
package com.appzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appzone.model.Comment;
import com.appzone.repository.CommentRepository;

/**
 * @author Hossam Youssef
 *
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<Comment> findAllComments() {

		List<Comment> comments = (List<Comment>) commentRepository.findAll();
		if (comments != null)
			return comments;
		else
			return null;
	}

	@Override
	public List<Comment> findByStatus(Integer status) {
		List<Comment> comments = commentRepository.findByStatus(status);
		if (comments != null)
			return comments;
		else
			return null;
	}

	@Override
	public Comment postComment(Comment comment) {
		Comment postedComment = commentRepository.save(comment);
		if(postedComment!=null)
			return postedComment;
		else
			return null;
	}
}
