package com.health2gether.user.service;

import com.health2gether.user.dto.SportResponse;
import com.health2gether.user.entity.SportEntity;
import com.health2gether.user.repository.SportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author flaoliveira
 * @version : $<br/>
 * : $
 * @since 20/10/2019 22:46
 */
@Service
public class SportService {

    private SportRepository sportRepository;

    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }


    public List<SportResponse> findAll() {
        return sportRepository.findAll().stream()
                .map(sportEntity -> convertToSportResponse(sportEntity))
                .collect(Collectors.toList());
    }

    private SportResponse convertToSportResponse(final SportEntity sportEntity) {
        final SportResponse sportResponse = new SportResponse();
        BeanUtils.copyProperties(sportEntity, sportResponse);
        return sportResponse;
    }

}
