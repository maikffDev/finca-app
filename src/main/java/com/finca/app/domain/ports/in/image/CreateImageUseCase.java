package com.finca.app.domain.ports.in.image;

import com.finca.app.domain.models.Image;

public interface CreateImageUseCase {

    public Image create(Image image);
}
