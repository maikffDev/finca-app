package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.User;
import com.finca.app.domain.ports.out.UserModelPort;
import com.finca.app.infrastructure.mappers.UserEntity;
import com.finca.app.infrastructure.mappers.UserDomainMapper;
import com.finca.app.infrastructure.repositories.JpaUserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserModelAdapter implements UserModelPort {
    private final JpaUserRepository jpaUserRepository;
    private final UserDomainMapper userDomainMapper;

    public UserModelAdapter(JpaUserRepository jpaUserRepository, UserDomainMapper userDomainMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userDomainMapper = userDomainMapper;
    }

    @Override
    @Transactional
    public User save(User user) {
        if (jpaUserRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("El usuario con username '" + user.getUsername() + "' ya existe.");
        }
        UserEntity entity = userDomainMapper.fromDomainModel(user);
        UserEntity saved = jpaUserRepository.save(entity);
        return userDomainMapper.toDomainModel(saved);
    }

    @Override
    public Boolean delete(Long id) {
        if (!jpaUserRepository.existsById(id)) {
            return false;
        }
        jpaUserRepository.deleteById(id);
        return true;
    }

    @Override
    public User logicalDeletion(User user) {
        Optional<UserEntity> optional = jpaUserRepository.findById(user.getUserId());
        if (optional.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado para borrado lógico.");
        }
        UserEntity entity = optional.get();
        entity.setActivo(false);
        UserEntity updated = jpaUserRepository.save(entity);
        return userDomainMapper.toDomainModel(updated);
    }

    @Override
    public User update(User user) {
        if (!jpaUserRepository.existsById(user.getUserId())) {
            throw new RuntimeException("Usuario no encontrado para actualizar.");
        }
        UserEntity entity = userDomainMapper.fromDomainModel(user);
        UserEntity updated = jpaUserRepository.save(entity);
        return userDomainMapper.toDomainModel(updated);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return jpaUserRepository.findAll(pageable)
                .map(userDomainMapper::toDomainModel);
    }

    @Override
    public Optional<User> getById(Long userId) {
        return jpaUserRepository.findById(userId)
                .map(userDomainMapper::toDomainModel);
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return jpaUserRepository.findByUsername(username)
                .map(userDomainMapper::toDomainModel);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return jpaUserRepository.findByCorreo(email)
                .map(userDomainMapper::toDomainModel);
    }

    @Override
    public List<User> getByRollId(Long rollId) {
        // falta el tema del roll, consultar Mati
        return List.of();
    }
}
