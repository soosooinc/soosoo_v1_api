package com.soosoo.soosoo.service.user.facade;

import com.soosoo.soosoo.domain.entity.User;
import com.soosoo.soosoo.service.user.GetUserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFacade {
    private final GetUserInfoService getUserInfoService;

    @Transactional(readOnly = true)
    public User getUserInfo(int userId) {
        return getUserInfoService.getUserInfo(userId);
    }
}
