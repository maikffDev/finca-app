package com.finca.app.application.usecases.image;


import com.finca.app.domain.models.Reservation;
import com.finca.app.domain.ports.in.image.DeleteImageUseCase;
import com.finca.app.domain.ports.in.reservation.DeleteReservationUseCase;
import com.finca.app.domain.ports.out.ImageModelPort;
import com.finca.app.infrastructure.mappers.ImageDomainMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DeleteImageUseCaseImpl implements DeleteImageUseCase {

    private final ImageModelPort imageModelPort;
    private final ImageDomainMapper imageDomainMapper;

    public DeleteImageUseCaseImpl(ImageModelPort imageModelPort, ImageDomainMapper imageDomainMapper) {
        this.imageModelPort = imageModelPort;
        this.imageDomainMapper = imageDomainMapper;
    }

    @Override
    public boolean delete(Long id) {
        return imageModelPort.delete(id);
    }
}
