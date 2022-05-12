package com.soosoo.soosoo.controller.user;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import com.soosoo.soosoo.service.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @GetMapping("info")
    public ResponseEntity<Response<UserInfoResponse>> getUserInfo(
            @RequestParam(value = "userId") int userId
    ) {
        return ResponseEntity.ok(
                Response.of(
                        userFacade.getUserInfo(userId),
                        "불러오기 완료"
                )
        );
    }
}
