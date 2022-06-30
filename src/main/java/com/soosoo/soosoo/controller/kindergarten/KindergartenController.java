package com.soosoo.soosoo.controller.kindergarten;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenDto;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;
import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.TeacherInfoResponse;
import com.soosoo.soosoo.service.kindergarten.facade.KindergartenFacade;
import com.soosoo.soosoo.service.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("kindergarten")
@RequiredArgsConstructor
public class KindergartenController {
    private final KindergartenFacade kindergartenFacade;
    private final UserFacade userFacade;

    @GetMapping("info")
    public ResponseEntity<Response<KindergartenJoinImageForResponse>> getKindergartenInfo(
            @RequestParam(value = "kindergartenId") int kindergartenId
    ) {
        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.getKindergartenInfo(kindergartenId), "불러오기 완료"
                )
        );
    }

    @GetMapping("teachers")
    public ResponseEntity<Response<List<TeacherInfoResponse>>> getTeachers(
            @RequestParam("kindergartenId") int kindergartenId
    ) {
        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.getTeacherInfo(kindergartenId),
                        "불러오기 완료"
                )
        );
    }

    @GetMapping("searchUserName")
    public ResponseEntity<Response<List<UserInfoResponse>>> searchUserName(
            @RequestParam("userName") String userName
    ){
        return ResponseEntity.ok(
                Response.of(
                        userFacade.getUserInfoByName(userName),
                        "불러오기 완료"
                )
        );
    }

    @PostMapping("addTeacher")
    public ResponseEntity<Response<String>> addTeacher(
            @RequestBody KindergartenDto kindergartenDto
            ) {
        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.addTeacher(kindergartenDto)
                )
        );
    }

    @GetMapping("deleteTeacher")
    public ResponseEntity<Response<String>> deleteTeacher(
            @RequestParam("kindergartenId") int kindergartenId,
            @RequestParam("userId") int userId
    ){
        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.deleteTeacher(userId)
                )
        );
    }
}
