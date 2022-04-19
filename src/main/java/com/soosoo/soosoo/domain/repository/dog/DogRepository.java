package com.soosoo.soosoo.domain.repository.dog;

import com.soosoo.soosoo.domain.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer>, DogRepositoryCustom {
    Dog findByDogId(int dogId);
}


/*
package com.soosoo.soosoo.domain.repository.image;

import com.soosoo.soosoo.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer>, ImageRepositoryCustom {
    Image findByImageId(int imageId);
}
public interface NoticeRepository extends JpaRepository<Notice, Integer>, NoticeRepositoryCustom {
    Notice findByNoticeId(int noticeId);
}

 */