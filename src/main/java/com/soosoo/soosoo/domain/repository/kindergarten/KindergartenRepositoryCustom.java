package com.soosoo.soosoo.domain.repository.kindergarten;

import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenDto;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;

import java.util.List;

public interface KindergartenRepositoryCustom {
    List<KindergartenResponse.TeacherInfoResponse> getTeacherInfo(int kindergartenId);
    KindergartenJoinImageForResponse getKindergartenInfo(int kindergartenId);
    long addTeacher(KindergartenDto kindergartenDto);
}
