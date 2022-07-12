package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.common.exception.BaseException;
import com.soosoo.soosoo.common.response.ErrorCode;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateKindergartenInfoService {
    private final KindergartenRepository kindergartenRepository;

    @Transactional
    public String updateKindergartenInfo(KindergartenResponse.KindergartenJoinImageForResponse kindergartenJoinImage){
        try {
            long result = kindergartenRepository.updateKindergartenInfo(kindergartenJoinImage);
            if (result != 0) {
                return "유치원 정보 수정 완료";
            } else {
                throw new BaseException(ErrorCode.KINDERGARTEN_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new BaseException(ErrorCode.KINDERGARTEN_NOT_FOUND);
        }
    }
}
