package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Image;
import com.finca.app.infrastructure.entities.ImageEntity;

import java.util.Optional;

public interface ImageModelPort {

    public Image create(Image image);
    public boolean delete(Long id);
    Optional<ImageEntity> getById(Long id);
    ImageEntity update(ImageEntity imageEntity, String  newUrl);

}
