package com.soosoo.soosoo.domain.repository.dog;

import com.soosoo.soosoo.domain.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer>, DogRepositoryCustom {
    Dog findByDogId(int dogId);
}
