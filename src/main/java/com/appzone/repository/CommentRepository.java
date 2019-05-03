/**
 * 
 */
package com.appzone.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.appzone.model.Comment;

/**
 * @author Hossam Youssef
 *
 */
public interface CommentRepository extends CrudRepository<Comment, Integer>{//, CommentRepositoryCustom {
	
	public List<Comment> findByStatus(Integer status);
}
