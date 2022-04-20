package com.soosoo.soosoo.controller.dog;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.domain.entity.Dog;
import com.soosoo.soosoo.service.dog.facade.DogFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dog")
@RequiredArgsConstructor
public class DogController {
    private final DogFacade dogFacade;

    @GetMapping("getDogInfo")
    public ResponseEntity<Response<String>> getDogInfo(
            @RequestParam("dogId") int dogId
    ){
        return ResponseEntity.ok(
                Response.of(
                        dogFacade.getDogInfo(dogId),
                        "불러오기 완료"
                )
        );
    }

}
