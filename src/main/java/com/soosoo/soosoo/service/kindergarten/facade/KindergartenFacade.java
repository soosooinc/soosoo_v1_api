package com.soosoo.soosoo.service.kindergarten.facade;

import com.soosoo.soosoo.domain.entity.Kindergarten;
import com.soosoo.soosoo.service.image.GetImageService;
import com.soosoo.soosoo.service.kindergarten.GetKindergartenInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class KindergartenFacade {
    private final GetKindergartenInfoService getKindergartenInfoService;

    @Transactional(readOnly = true)
    public Kindergarten getKindergartenInfo(int kindergartenId) {
        return getKindergartenInfoService.getKindergartenInfo(kindergartenId);
    }

}

