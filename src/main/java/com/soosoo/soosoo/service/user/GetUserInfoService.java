package com.soosoo.soosoo.service.user;

import com.soosoo.soosoo.domain.entity.User;
import com.soosoo.soosoo.domain.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetUserInfoService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public User getUserInfo(int userId) {
        return userRepository.findByUserId(userId);
    }
}
