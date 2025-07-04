package com.finca.app.domain.ports.in.image;

import com.finca.app.domain.models.Discount;
import com.finca.app.domain.models.Image;

public interface UpdateImageUseCase {
    Image update(Image discount);
}
