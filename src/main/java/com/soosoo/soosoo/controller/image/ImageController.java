package com.soosoo.soosoo.controller.image;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.domain.entity.User;
import com.soosoo.soosoo.service.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("image")
@RequiredArgsConstructor
public class ImageController {
    private final UserFacade userFacade;

    @GetMapping("info")
    public ResponseEntity<Response<User>> getUserInfo(
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

