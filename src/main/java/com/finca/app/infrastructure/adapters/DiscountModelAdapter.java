package com.finca.app.infrastructure.adapters;

import com.finca.app.application.service.util.GenericErrorException;
import com.finca.app.domain.models.Discount;
import com.finca.app.domain.ports.out.DiscountModelPort;
import com.finca.app.infrastructure.entities.DiscountEntity;
import com.finca.app.infrastructure.mappers.DiscountDomainMapper;
import com.finca.app.infrastructure.repositories.JpaDiscountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiscountModelAdapter implements DiscountModelPort {

    private final JpaDiscountRepository jpaDiscountRepository;
    private final DiscountDomainMapper discountDomainMapper;

    public DiscountModelAdapter(JpaDiscountRepository jpaDiscountRepository, DiscountDomainMapper discountDomainMapper) {
        this.jpaDiscountRepository = jpaDiscountRepository;
        this.discountDomainMapper = discountDomainMapper;
    }

    @Override
    public Discount save(Discount discount) {
        try {
            DiscountEntity entity = discountDomainMapper.fromDomainModel(discount);
            DiscountEntity saved = jpaDiscountRepository.save(entity);
            return discountDomainMapper.toDomainModel(saved);
        } catch (Exception e) {
            throw new GenericErrorException("Failed to save Discount: " + e.getMessage());
        }
    }

    @Override
    public Boolean delete(Long id) {
        try {
            jpaDiscountRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new GenericErrorException("Failed to delete Discount: " + e.getMessage());
        }
    }

    @Override
    public List<Discount> findAll() {
        return jpaDiscountRepository.findAll()
                .stream()
                .map(discountDomainMapper::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return jpaDiscountRepository.findById(id)
                .map(discountDomainMapper::toDomainModel);
    }

    @Override
    public Optional<Discount> findByName(String name) {
        return jpaDiscountRepository.findByName(name)
                .map(discountDomainMapper::toDomainModel);
    }

    @Override
    public Optional<Discount> findByDiscountPercentage(Double discountPercentage) {
        return jpaDiscountRepository.findByDiscountPercentage(discountPercentage)
                .map(discountDomainMapper::toDomainModel);
    }

    @Override
    public Discount update(Discount discount) {
        return save(discount);
    }
}

