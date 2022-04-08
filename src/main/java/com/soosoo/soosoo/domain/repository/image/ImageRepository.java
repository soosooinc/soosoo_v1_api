package com.soosoo.soosoo.domain.repository.image;

import com.soosoo.soosoo.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer>, ImageRepositoryCustom {
    Image findByImageId(int imageId);
}
