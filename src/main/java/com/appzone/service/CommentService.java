/**
 * 
 */
package com.appzone.service;

import java.util.List;

import com.appzone.model.Comment;

/**
 * @author Hossam Youssef
 *
 */
public interface CommentService {

	public List<Comment> findAllComments();

	public List<Comment> findByStatus(Integer status);
	
	public Comment postComment(Comment comment);

}
