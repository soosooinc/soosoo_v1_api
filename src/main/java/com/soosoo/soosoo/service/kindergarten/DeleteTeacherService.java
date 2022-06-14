package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.common.exception.BaseException;
import com.soosoo.soosoo.common.response.ErrorCode;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteTeacherService {
    private final KindergartenRepository kindergartenRepository;

    @Transactional
    public String deleteTeacher(int userId){
        try {
            long result = kindergartenRepository.addTeacher(0, userId);
            if (result != 0) {
                return "선생님 삭제 완료";
            } else {
                throw new BaseException(ErrorCode.COMMON_INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new BaseException(ErrorCode.USER_NOT_FOUND);
        }
    }
}
