package com.finca.app.application.usecases.image;


import com.finca.app.domain.models.Image;
import com.finca.app.domain.ports.in.image.UpdateImageUseCase;
import com.finca.app.domain.ports.out.ImageModelPort;
import com.finca.app.infrastructure.entities.ImageEntity;
import com.finca.app.infrastructure.mappers.ImageDomainMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UpdateImageUseCaseImpl implements UpdateImageUseCase {

    private final ImageModelPort imageModelPort;
    private final ImageDomainMapper imageDomainMapper;

    public UpdateImageUseCaseImpl(ImageModelPort imageModelPort, ImageDomainMapper imageDomainMapper) {
        this.imageModelPort = imageModelPort;
        this.imageDomainMapper = imageDomainMapper;
    }

    @Override
    public Image update(@NotNull Image image) {
        ImageEntity imageEntity = imageDomainMapper.toEntity(image);
        String newUrl = image.getUrlImage();
        ImageEntity updatedImage= imageModelPort.update(imageEntity,newUrl);
        return imageDomainMapper.toDomain(updatedImage);
    }
}
