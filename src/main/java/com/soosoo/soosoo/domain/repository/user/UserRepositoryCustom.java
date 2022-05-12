package com.soosoo.soosoo.domain.repository.user;

import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;

import java.util.List;

public interface UserRepositoryCustom {
    UserInfoResponse getUserInfo(int userId);
    List<UserInfoResponse> getUserInfoByName(String userName);
}
