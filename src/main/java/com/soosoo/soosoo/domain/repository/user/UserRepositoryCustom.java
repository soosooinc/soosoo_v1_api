package com.soosoo.soosoo.domain.repository.user;

import com.soosoo.soosoo.controller.user.dto.UserResponse;

import java.util.List;

public interface UserRepositoryCustom {
    UserResponse.UserInfoResponse getUserInfo(int userId);
}
