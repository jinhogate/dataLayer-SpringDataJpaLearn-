package com.openclassrooms.datalayer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.datalayer.model.Comment;
import com.openclassrooms.datalayer.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	/**
	 * Retourne la liste des commentaires
	 * @return
	 */
	public Iterable<Comment> getAllComments(){
		return commentRepository.findAll();
	}

	/**
	 * Créer un nouveau commentaire
	 * @param newComment
	 * @return
	 */
	public Comment addComment(Comment newComment) {
		return commentRepository.save(newComment);
	}
}
