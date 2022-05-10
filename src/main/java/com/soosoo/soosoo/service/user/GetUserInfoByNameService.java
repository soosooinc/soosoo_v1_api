package com.soosoo.soosoo.service.user;

import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import com.soosoo.soosoo.domain.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class GetUserInfoByNameService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserInfoResponse> getUserInfoByName(String userName) {
        return userRepository.getUserInfoByName(userName);
    }
}
