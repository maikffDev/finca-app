package com.finca.app.infrastructure.repositories;

import com.finca.app.infrastructure.mappers.UserEntity;
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

    @Query("SELECT u FROM UserEntity u " +
            "WHERE (:nombre IS NULL OR LOWER(u.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
            "AND (:activo IS NULL OR u.activo = :activo)")
    Page<UserEntity> filterUsersByParams(Pageable pageable,
                                         @Param("nombre") String nombre,
                                         @Param("activo") Boolean activo);

    boolean existsByCorreo(String correo);
    boolean existsByUsername(String user);
}
