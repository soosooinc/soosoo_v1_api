package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTeacherInfoService {
    private final KindergartenRepository kindergartenRepository;

    @Transactional(readOnly = true)
    public List<KindergartenResponse.TeacherInfoResponse> getTeacherInfo(int kindergartenId) {
        return kindergartenRepository.getTeacherInfo(kindergartenId);
    }
}
