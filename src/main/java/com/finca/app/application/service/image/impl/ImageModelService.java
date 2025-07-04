package com.finca.app.application.service.image.impl;

import com.finca.app.domain.models.Image;
import com.finca.app.domain.ports.in.image.CreateImageUseCase;
import com.finca.app.domain.ports.in.image.DeleteImageUseCase;
import com.finca.app.domain.ports.in.image.FindImageUseCase;
import com.finca.app.domain.ports.in.image.UpdateImageUseCase;
import org.springframework.stereotype.Service;

import java.util.Optional;


public class ImageModelService implements CreateImageUseCase, DeleteImageUseCase, FindImageUseCase, UpdateImageUseCase {

    private final CreateImageUseCase createImageUseCase;
    private final DeleteImageUseCase deleteImageUseCase;
    private final FindImageUseCase findImageUseCase;
    private final UpdateImageUseCase updateImageUseCase;

    public ImageModelService(CreateImageUseCase createImageUseCase, DeleteImageUseCase deleteImageUseCase, FindImageUseCase findImageUseCase, UpdateImageUseCase updateImageUseCase) {
        this.createImageUseCase = createImageUseCase;
        this.deleteImageUseCase = deleteImageUseCase;
        this.findImageUseCase = findImageUseCase;
        this.updateImageUseCase = updateImageUseCase;
    }


    @Override
    public Image create(Image image) {
        return createImageUseCase.create(image);
    }

    @Override
    public boolean delete(Long id) {
        return deleteImageUseCase.delete(id);
    }

    @Override
    public Optional<Image> getById(Long id) {
        return findImageUseCase.getById(id);
    }

    @Override
    public Image update(Image discount) {
        return updateImageUseCase.update(discount);
    }
}
