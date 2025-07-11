package com.finca.app.application.usecases.image;

import com.finca.app.application.dto.reservation.ReservationDTORequest2;
import com.finca.app.domain.models.Image;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.image.CreateImageUseCase;
import com.finca.app.domain.ports.in.reservation.CreateReservationUseCase;
import com.finca.app.domain.ports.out.ImageModelPort;
import com.finca.app.infrastructure.mappers.ImageDomainMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CreateImageUseCaseImpl implements CreateImageUseCase {

    private final ImageModelPort imageModelPort;
    private final ImageDomainMapper imageDomainMapper;

    public CreateImageUseCaseImpl(ImageModelPort imageModelPort, ImageDomainMapper imageDomainMapper) {
        this.imageModelPort = imageModelPort;
        this.imageDomainMapper = imageDomainMapper;
    }

    @Override
    public Image create(Image image) {
        return imageModelPort.create(image);
    }
}
