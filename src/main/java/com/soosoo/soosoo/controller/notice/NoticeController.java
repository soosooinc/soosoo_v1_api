package com.soosoo.soosoo.controller.notice;

import com.soosoo.soosoo.service.notice.facade.NoticeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeFacade noticeFacade;

}
