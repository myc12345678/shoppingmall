
package com.bjfu.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bjfu.entity.Comment;
/**
 * 评论数据层
 */
public interface CommtentDao extends JpaRepository<Comment, Integer> {
	/**
	 * 根据商品查询评论
	 * @param mallId
	 * @return
	 */
	@Override
	Page<Comment> findAll(Pageable pageable);
}
