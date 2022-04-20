package com.soosoo.soosoo.service.dog;

import com.soosoo.soosoo.domain.repository.dog.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.soosoo.soosoo.domain.entity.Dog;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetDogInfoService {
    private final DogRepository dogRepository;

    @Transactional(readOnly = true)
    public String getDogInfo(int dogId){
        return dogRepository.findByDogId(dogId).getName();
    }
}

