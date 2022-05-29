package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.common.exception.BaseException;
import com.soosoo.soosoo.common.response.ErrorCode;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class GetKindergartenInfoService {
    private final KindergartenRepository kindergartenRepository;

    @Transactional(readOnly = true)
    public KindergartenJoinImageForResponse getKindergartenInfo(int kindergartenId) {
        KindergartenJoinImageForResponse result = kindergartenRepository.getKindergartenInfo(kindergartenId);
        if(result == null) {
            throw new BaseException(ErrorCode.KINDERGARTEN_NOT_FOUND);
        }

        return result;
    }
}
