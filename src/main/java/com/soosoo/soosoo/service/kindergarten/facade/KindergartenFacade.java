package com.soosoo.soosoo.service.kindergarten.facade;

import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.TeacherInfoResponse;
import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import com.soosoo.soosoo.service.kindergarten.AddTeacherService;
import com.soosoo.soosoo.service.kindergarten.GetKindergartenInfoService;
import com.soosoo.soosoo.service.kindergarten.GetTeacherInfoService;
import com.soosoo.soosoo.service.user.GetUserInfoByNameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KindergartenFacade {
    private final GetKindergartenInfoService getKindergartenInfoService;
    private final GetTeacherInfoService getTeacherInfoService;
    private final GetUserInfoByNameService getUserInfoByNameService;
    private final AddTeacherService addTeacherService;

    @Transactional(readOnly = true)
    public KindergartenJoinImageForResponse getKindergartenInfo(int kindergartenId) {
        return getKindergartenInfoService.getKindergartenInfo(kindergartenId);
    }
  
    @Transactional(readOnly = true)
    public List<TeacherInfoResponse> getTeacherInfo(int kindergartenId){
        return getTeacherInfoService.getTeacherInfo(kindergartenId);
    }

    @Transactional
    public String addTeacher(int kindergartenId, int userId) {
        return addTeacherService.addTeacher(kindergartenId, userId);
    }

}
