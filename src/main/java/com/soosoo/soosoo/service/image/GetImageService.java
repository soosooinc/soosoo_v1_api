package com.soosoo.soosoo.service.image;

import com.soosoo.soosoo.domain.entity.Image;
import com.soosoo.soosoo.domain.repository.image.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetImageService {
    private final ImageRepository imageRepository;

    @Transactional(readOnly = true)
    public String getImage(int imageId) {
        return imageRepository.findByImageId(imageId).getImageUrl();
    }
}
