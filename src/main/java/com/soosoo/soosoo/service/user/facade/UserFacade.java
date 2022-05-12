package com.soosoo.soosoo.service.user.facade;

import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import com.soosoo.soosoo.service.user.GetUserInfoByNameService;
import com.soosoo.soosoo.service.user.GetUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final GetUserInfoService getUserInfoService;
    private final GetUserInfoByNameService getUserInfoByNameService;

    @Transactional(readOnly = true)
    public UserInfoResponse getUserInfo(int userId) {
        return getUserInfoService.getUserInfo(userId);
    }

    @Transactional(readOnly = true)
    public List<UserInfoResponse> getUserInfoByName(String userName) {
        return getUserInfoByNameService.getUserInfoByName(userName);
    }
}
