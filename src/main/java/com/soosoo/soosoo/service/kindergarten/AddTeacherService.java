package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.common.exception.BaseException;
import com.soosoo.soosoo.common.response.ErrorCode;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AddTeacherService {
    private final KindergartenRepositoryCustom kindergartenRepositoryCustom;

    @Transactional
    public String addTeacher(int kindergartenId, int userId) {
        try {
            long result = kindergartenRepositoryCustom.addTeacher(kindergartenId, userId);
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
