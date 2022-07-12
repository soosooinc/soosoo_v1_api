package com.soosoo.soosoo.controller.kindergarten;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.controller.image.dto.ImageResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;
import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.TeacherInfoResponse;
import com.soosoo.soosoo.domain.entity.Kindergarten;
import com.soosoo.soosoo.service.kindergarten.facade.KindergartenFacade;
import com.soosoo.soosoo.service.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.TeacherInfoResponse;

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

    @PostMapping("updateInfo")
    public  ResponseEntity<Response<String>> updateKindergartenInfo(
            @RequestBody KindergartenJoinImageForResponse KindergartenJoinImage
    ){
        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.updateKindergartenInfo(KindergartenJoinImage),"불러오기 완료"
                )
        );

    }

    @GetMapping("teacherInfo")
    public ResponseEntity<Response<List<TeacherInfoResponse>>> getTeacherInfo(
            @RequestParam("kindergartenId") int kindergartenId
    ) {
        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.getTeacherInfo(kindergartenId),
                        "불러오기 완료"
                )
        );
    }

    @GetMapping("searchName")
    public ResponseEntity<Response<List<UserInfoResponse>>> searchName(
            @RequestParam("userName") String userName
    ){
        return ResponseEntity.ok(
                Response.of(
                        userFacade.getUserInfoByName(userName),
                        "불러오기 완료"
                )
        );
    }

    @GetMapping("addTeacher")
    public ResponseEntity<Response<String>> addTeacher(
            @RequestParam("kindergartenId") int kindergartenId,
            @RequestParam("userId") int userId
    ) {

        return ResponseEntity.ok(
                Response.of(
                        kindergartenFacade.addTeacher(kindergartenId, userId)
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
