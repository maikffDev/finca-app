package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Image;
import com.finca.app.domain.ports.out.ImageModelPort;
import com.finca.app.infrastructure.entities.ImageEntity;
import com.finca.app.infrastructure.repositories.JpaImageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageModelAdapter implements ImageModelPort {

    private final JpaImageRepository jpaImageRepository;

    public ImageModelAdapter(JpaImageRepository jpaImageRepository) {
        this.jpaImageRepository = jpaImageRepository;
    }

    @Override
    public Image create(Image image) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        boolean check =false;
        try {
            jpaImageRepository.deleteById(id);
            check=true;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
        return check;
    }

    @Override
    public Optional<ImageEntity> getById(Long id) {
        return jpaImageRepository.findById(id);
    }

    @Override
    public ImageEntity update(ImageEntity imageEntity,String newUrl) {
        imageEntity.setUrlImage(newUrl);
        ImageEntity savedNewImage =jpaImageRepository.save(imageEntity);
        return savedNewImage;
    }
}
