package com.finca.app.application.service.hourhand.impl;

import com.finca.app.application.dto.hourhand.HourHandDTORequest;
import com.finca.app.application.dto.hourhand.HourHandDTOResponse;
import com.finca.app.application.mappers.HourHandDTOMapper;
import com.finca.app.application.service.hourhand.HourHandService;
import com.finca.app.domain.models.HourHand;
import org.springframework.stereotype.Service;
import com.finca.app.application.service.hourhand.impl.HourHandModelService;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class HourHandServiceImpl implements HourHandService {

    //private final HourHandModelService hourHandModelService;
    private final HourHandDTOMapper hourHandDTOMapper;

    public HourHandServiceImpl(HourHandDTOMapper hourHandDTOMapper) {
        this.hourHandDTOMapper = hourHandDTOMapper;
    }


    @Override
    public HourHandDTOResponse create(HourHandDTORequest dto) {
        return null;
    }

    @Override
    public List<HourHandDTOResponse> findAll() { //todo rehacer, por error al usar collect
        return null;
        //return hourHand.findAll().stream().map(HourHandDTOMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

    }

   /* @Override
    public HourHandDTOResponse update(HourHand dto) {
        return null;
    }*/

    /*@Override
    public void delete(Long id) {
        deleteById(id);
    }*/

    /*@Override
    public void deleteById(Long id) {


    }*/
}

