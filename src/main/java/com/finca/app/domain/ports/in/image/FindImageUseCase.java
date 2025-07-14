package com.finca.app.domain.ports.in.image;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.models.Image;

import java.util.Optional;

public interface FindImageUseCase {

    Optional<Image> getById(Long id);
}
