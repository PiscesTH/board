package com.th.board.board;

import com.th.board.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Posts, Long> {
}
