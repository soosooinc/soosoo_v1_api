package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.common.exception.BaseException;
import com.soosoo.soosoo.common.response.ErrorCode;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenDto;
import com.soosoo.soosoo.domain.entity.Kindergarten;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddTeacherService {
    private final KindergartenRepository kindergartenRepository;

    @Transactional
    public String addTeacher(KindergartenDto kindergartenDto) {
        try {
            long result = kindergartenRepository.addTeacher(kindergartenDto);
            if (result != 0) {
                return "선생님 등록 완료";
            } else {
                throw new BaseException(ErrorCode.USER_NOT_FOUND);
            }
        } catch (Exception e) {
            throw new BaseException(ErrorCode.USER_NOT_FOUND);
        }
    }

}
