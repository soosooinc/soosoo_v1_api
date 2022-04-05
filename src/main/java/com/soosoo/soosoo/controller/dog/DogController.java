package com.soosoo.soosoo.controller.dog;

import com.soosoo.soosoo.service.dog.facade.DogFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notice")
@RequiredArgsConstructor
public class DogController {
    private final DogFacade noticeFacade;

}