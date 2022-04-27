package com.soosoo.soosoo.domain.repository.user;

import com.soosoo.soosoo.controller.user.dto.UserResponse;

public interface UserRepositoryCustom {
    UserResponse.UserInfoResponse getUserInfo(int userId);
}
