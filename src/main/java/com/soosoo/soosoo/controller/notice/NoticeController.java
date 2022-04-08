package com.soosoo.soosoo.controller.notice;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.service.notice.facade.NoticeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeFacade noticeFacade;

    @GetMapping("getNoticeInfo")
    public ResponseEntity<Response<Notice>> getNoticeInfo(
            @RequestParam(value = "noticeId") int noticeId
    ){
        return ResponseEntity.ok(
                Response.of(
                        noticeFacade.getNoticeInfo(noticeId),
                        "불러오기 완료"
                )
        );
    }

}
