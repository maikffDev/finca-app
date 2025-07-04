package com.finca.app.application.usecases.image;


import com.finca.app.domain.models.Image;
import com.finca.app.domain.ports.in.image.UpdateImageUseCase;
import com.finca.app.domain.ports.out.ImageModelPort;
import com.finca.app.infrastructure.mappers.ImageDomainMapper;
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
    public Image update(Image image) {
        return imageModelPort.update(image);
    }
}
