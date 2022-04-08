package com.soosoo.soosoo.service.image.facade;

import com.soosoo.soosoo.service.image.GetImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ImageFacade {
    private final GetImageService getImageService;

    @Transactional(readOnly = true)
    public String getImage(int imageId) {
        return getImageService.getImage(imageId);
    }
}
