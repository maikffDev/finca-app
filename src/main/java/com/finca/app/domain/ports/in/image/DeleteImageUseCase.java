package com.finca.app.domain.ports.in.image;

import com.finca.app.domain.models.Image;

public interface DeleteImageUseCase {

    public boolean delete(Long id);
}
