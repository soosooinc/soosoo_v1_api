package com.soosoo.soosoo.domain.repository.kindergarten;

import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;

import java.util.List;

public interface KindergartenRepositoryCustom {
    List<KindergartenResponse> getTeacherInfo(int kindergartenId);
}
