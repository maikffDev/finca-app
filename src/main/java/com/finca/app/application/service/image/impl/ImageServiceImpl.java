package com.finca.app.application.service.image.impl;

import com.finca.app.application.dto.finca.FincaDTORequest;
import com.finca.app.application.dto.image.ImageDTORequest;
import com.finca.app.application.dto.image.ImageDTOResponse;
import com.finca.app.application.mappers.ImageDTOMapper;
import com.finca.app.application.service.image.ImageService;
import com.finca.app.domain.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageModelService imageModelService;
    private final ImageDTOMapper imageDTOMapper;

    public ImageServiceImpl(ImageModelService imageModelService, ImageDTOMapper imageDTOMapper) {
        this.imageModelService = imageModelService;
        this.imageDTOMapper = imageDTOMapper;
    }


    @Override
    public ImageDTOResponse create(FincaDTORequest fincaDTORequest,String urlImage) {
        Image image = imageDTOMapper.fromDTORequestToNewDomain(fincaDTORequest,urlImage);
        Image imageSaved = imageModelService.create(image);
        return imageDTOMapper.fromDomainToDTOResponse(imageSaved);
    }

    @Override
    public boolean delete(Long id) {
        return imageModelService.delete(id);
    }

    @Override
    public ImageDTOResponse getById(Long id) {
       Image image=imageModelService.getById(id).orElseThrow(() -> new RuntimeException("Error al obtener la Finca por ID"));
        return imageDTOMapper.fromDomainToDTOResponse(image);
    }

    @Override
    public ImageDTOResponse update(ImageDTORequest imageToUpdate) {
        Image image = imageDTOMapper.fromDTORequestToDomain(imageToUpdate);
        Image updatedImage =imageModelService.update(image);
        return imageDTOMapper.fromDomainToDTOResponse(updatedImage);
    }
}
