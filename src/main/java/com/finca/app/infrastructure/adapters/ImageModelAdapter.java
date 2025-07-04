package com.finca.app.infrastructure.adapters;

import com.finca.app.domain.models.Image;
import com.finca.app.domain.ports.out.ImageModelPort;

import java.util.Optional;

public class ImageModelAdapter implements ImageModelPort {
    @Override
    public Image create(Image image) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Optional<Image> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Image update(Image discount) {
        return null;
    }
}
