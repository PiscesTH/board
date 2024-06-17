package com.th.board.board;

import com.th.board.entity.Pics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PicsRepository extends JpaRepository<Pics, Long> {
}
