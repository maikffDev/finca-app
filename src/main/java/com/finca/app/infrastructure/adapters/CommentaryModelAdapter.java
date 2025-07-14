package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Commentary;
import com.finca.app.domain.ports.out.CommentaryModelPort;
import com.finca.app.infrastructure.entities.CommentaryEntity;
import com.finca.app.infrastructure.mappers.CommentaryDomainMapper;
import com.finca.app.infrastructure.repositories.JpaCommentaryRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentaryModelAdapter implements CommentaryModelPort {

    private final JpaCommentaryRepository jpaCommentaryRepository;
    private final CommentaryDomainMapper commentaryDomainMapper;

    public CommentaryModelAdapter(JpaCommentaryRepository jpaCommentaryRepository, CommentaryDomainMapper commentaryDomainMapper) {
        this.jpaCommentaryRepository = jpaCommentaryRepository;
        this.commentaryDomainMapper = commentaryDomainMapper;
    }

    @Override
    @Transactional
    public Commentary save(Commentary commentary) {
        CommentaryEntity entity = commentaryDomainMapper.fromDomainModel(commentary);
        CommentaryEntity saved = jpaCommentaryRepository.save(entity);
        return commentaryDomainMapper.toDomainModel(saved);
    }

    @Override
    public Boolean delete(Long id) {
        if (!jpaCommentaryRepository.existsById(id)) {
            return false;
        }
        jpaCommentaryRepository.deleteById(id);
        return true;
    }

    @Override
    public Commentary logicalDeletion(Commentary commentary) {
        CommentaryEntity entity = commentaryDomainMapper.fromDomainModel(commentary);
        CommentaryEntity updated = jpaCommentaryRepository.save(entity);
        return commentaryDomainMapper.toDomainModel(updated);
    }

    @Override
    public List<Commentary> getAll() {
        return jpaCommentaryRepository.findAll()
                .stream()
                .map(commentaryDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Commentary> getById(Long id) {
        return jpaCommentaryRepository.findById(id)
                .map(commentaryDomainMapper::toDomainModel);
    }

    @Override
    public List<Commentary> getByUserId(Long userId) {
        return jpaCommentaryRepository.findAllByUser_UserId(userId)
                .stream()
                .map(commentaryDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Commentary> getByFincaId(Long fincaId) {
        return jpaCommentaryRepository.findAllByFinca_Id(fincaId)
                .stream()
                .map(commentaryDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Commentary update(Commentary commentary) {
        CommentaryEntity entity = commentaryDomainMapper.fromDomainModel(commentary);
        CommentaryEntity updated = jpaCommentaryRepository.save(entity);
        return commentaryDomainMapper.toDomainModel(updated);
    }
}
