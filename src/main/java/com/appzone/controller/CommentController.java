/**
 * 
 */
package com.appzone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appzone.model.Comment;
import com.appzone.service.CommentService;
import com.appzone.util.ConstantValues;

/**
 * @author Hossam Youssef
 *
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/allComments", method = RequestMethod.GET)
	public List<Comment> findAllComments() {
		return commentService.findAllComments();
	}

	@RequestMapping(value = "/approvedComments", method = RequestMethod.GET)
	public List<Comment> findByStatusApprovedComments() {
		return commentService.findByStatus(ConstantValues.APPROVED_COMMENT);
	}

	@RequestMapping(value = "/pendingComments", method = RequestMethod.GET)
	public List<Comment> findByStatusPendingComments() {
		return commentService.findByStatus(ConstantValues.PENDING_COMMENT);
	}

	@RequestMapping(value = "/postComment", method = RequestMethod.GET)
	public Comment postComment(Comment comment) {
		return commentService.postComment(comment);
	}
}
