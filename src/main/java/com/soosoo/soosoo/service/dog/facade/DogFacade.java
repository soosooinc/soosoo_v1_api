package com.soosoo.soosoo.service.dog.facade;

import com.soosoo.soosoo.service.dog.GetDogInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DogFacade {
    private final GetDogInfoService getDogInfoService;

    @Transactional(readOnly = true)
    public String getDogInfo(int dogId) {
        return getDogInfoService.getDogInfo(dogId);
    }
}


