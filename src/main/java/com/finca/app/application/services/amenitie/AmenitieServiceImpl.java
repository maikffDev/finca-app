package com.finca.app.application.service.amenitie;

import com.finca.app.application.dto.amenitie.AmenitieDTORequest;
import com.finca.app.application.dto.amenitie.AmenitieDTOResponse;
import com.finca.app.application.mappers.AmenitieDTOMapper;
import com.finca.app.domain.models.Amenitie;
import com.finca.app.domain.ports.in.amenitie.CreateAmenitieUseCase;
import com.finca.app.domain.ports.in.amenitie.DeleteAmenitieUseCase;
import com.finca.app.domain.ports.in.amenitie.FindAmenitieUseCase;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AmenitieServiceImpl implements AmenitieService {

    private final CreateAmenitieUseCase createAmenitieUseCase;
    private final FindAmenitieUseCase findAmenitieUseCase;
    private final DeleteAmenitieUseCase deleteAmenitieUseCase;
    private final AmenitieDTOMapper amenitieDTOMapper;

    public AmenitieServiceImpl(CreateAmenitieUseCase createAmenitieUseCase, FindAmenitieUseCase findAmenitieUseCase, DeleteAmenitieUseCase deleteAmenitieUseCase, AmenitieDTOMapper amenitieDTOMapper) {
        this.createAmenitieUseCase = createAmenitieUseCase;
        this.findAmenitieUseCase = findAmenitieUseCase;
        this.deleteAmenitieUseCase = deleteAmenitieUseCase;
        this.amenitieDTOMapper = amenitieDTOMapper;
    }

    @Override
    public AmenitieDTOResponse create(AmenitieDTORequest request) {
        Amenitie amenitie = amenitieDTOMapper.toModel(request);
        Amenitie createdAmenitie = createAmenitieUseCase.createAmenitie(amenitie);
        return amenitieDTOMapper.toDto(createdAmenitie);
    }

    @Override
    public List<AmenitieDTOResponse> getAll() {
        return amenitieDTOMapper.toDtoList(findAmenitieUseCase.getAllAmenities());
    }

    @Override
    public Optional<AmenitieDTOResponse> getById(Long id) {
        return findAmenitieUseCase.getAmenitieById(id)
                .map(amenitieDTOMapper::toDto);
    }

    @Override
    public boolean delete(Long id) {
        return deleteAmenitieUseCase.deleteAmenitieById(id);
    }
}