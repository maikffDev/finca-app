package com.finca.app.application.service.image;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.image.ImageDTORequest;
import com.finca.app.application.dto.image.ImageDTOResponse;
import com.finca.app.domain.models.Image;

import java.util.Optional;

public interface ImageService {
    public ImageDTOResponse create(FincaDTORequest fincaDTORequest, String urlImage);
    public boolean delete(Long id);
   ImageDTOResponse getById(Long id);
    ImageDTOResponse update(ImageDTORequest imageToUpdate);
}
