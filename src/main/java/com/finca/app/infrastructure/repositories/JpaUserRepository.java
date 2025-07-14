package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findAll(Pageable pageable);

    Optional<UserEntity> findByCorreo(String correo);

    Optional<UserEntity> findByUsername(String username);

    @Query("""
        SELECT u FROM UserEntity u
        WHERE (:username IS NULL OR LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%')))
        AND (:activo IS NULL OR u.activo = :activo)
    """)
    Page<UserEntity> filterUsersByParams(Pageable pageable,
                                         @Param("username") String username,
                                         @Param("activo") Boolean activo);

    boolean existsByCorreo(String correo);
    boolean existsByUsername(String user);
}
