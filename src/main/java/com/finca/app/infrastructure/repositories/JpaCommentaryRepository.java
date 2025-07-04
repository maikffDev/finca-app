package com.finca.app.infrastructure.repositories;


import com.finca.app.infrastructure.entities.CommentaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaCommentaryRepository extends JpaRepository<CommentaryEntity , Long> {

    @Override
    boolean existsById(Long id);

    List<CommentaryEntity> findAllByUser_UserId(Long userId);

    List<CommentaryEntity> findAllByFinca_Id(Long fincaId);
}
