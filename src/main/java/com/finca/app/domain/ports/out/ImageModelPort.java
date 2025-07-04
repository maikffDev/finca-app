package com.finca.app.domain.ports.out;

import com.finca.app.domain.models.Image;

import java.util.Optional;

public interface ImageModelPort {

    public Image create(Image image);
    public boolean delete(Long id);
    Optional<Image> getById(Long id);
    Image update(Image discount);

}
