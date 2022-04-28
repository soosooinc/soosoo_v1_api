package com.soosoo.soosoo.service.kindergarten.facade;

import com.soosoo.soosoo.domain.entity.Kindergarten;
import com.soosoo.soosoo.service.kindergarten.GetKindergartenInfoService;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.service.kindergarten.GetTeacherInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KindergartenFacade {
    private final GetKindergartenInfoService getKindergartenInfoService;
    private final GetTeacherInfoService getTeacherInfoService;

    @Transactional(readOnly = true)
    public Kindergarten getKindergartenInfo(int kindergartenId) {
        return getKindergartenInfoService.getKindergartenInfo(kindergartenId);
    }
  
    @Transactional(readOnly = true)
    public List<KindergartenResponse.TeacherInfoResponse> getTeacherInfo(int kindergartenId){
        return getTeacherInfoService.getTeacherInfo(kindergartenId);
    }

}
