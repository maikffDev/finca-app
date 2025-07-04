package com.finca.app.application.usecases.image;


import com.finca.app.domain.models.Image;
import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.image.FindImageUseCase;
import com.finca.app.domain.ports.in.reservation.FindReservationUseCase;
import com.finca.app.domain.ports.out.ImageModelPort;
import com.finca.app.infrastructure.mappers.ImageDomainMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class FindImageUseCaseImpl implements FindImageUseCase {

    private final ImageModelPort imageModelPort;
    private final ImageDomainMapper imageDomainMapper;

    public FindImageUseCaseImpl(ImageModelPort imageModelPort, ImageDomainMapper imageDomainMapper) {
        this.imageModelPort = imageModelPort;
        this.imageDomainMapper = imageDomainMapper;
    }

    @Override
    public Optional<Image> getById(Long id) {
        return imageModelPort.getById(id);
    }
}
