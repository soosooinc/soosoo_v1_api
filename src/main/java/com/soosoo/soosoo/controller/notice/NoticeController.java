package com.soosoo.soosoo.controller.notice;

import com.soosoo.soosoo.common.response.Response;
import com.soosoo.soosoo.controller.notice.dto.NoticeDto;
import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.service.notice.facade.NoticeFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getNotice")
    public ResponseEntity<Response<List<Notice>>> getNotice(
            @RequestParam(value = "status") String status,
            @RequestParam(value = "kindergartenId") Integer kindergartenId,
            @PageableDefault(size = 10, page = 0)Pageable pageable
    ) {
        return ResponseEntity.ok(
                Response.of(
                        noticeFacade.getNotice(status, kindergartenId, pageable),
                        "불러오기 완료"
                )
        );
    }

    @GetMapping("getNoticeList/{type}")
    public ResponseEntity<Response<List<Notice>>> getNoticeList(
            @PathVariable("type") short type
    ){
        return ResponseEntity.ok(
                Response.of(
                        noticeFacade.getNoticeList(type),
                        "불러오기 완료"
                )
        );
    }

    @PostMapping("addNotice")
    public ResponseEntity<Response<Notice>> addNotice(
            @RequestBody NoticeDto noticeDto
            ){
        return ResponseEntity.ok(
                Response.of(
                        noticeFacade.addNotice(noticeDto),
                        "불러오기 완료"
                )
        );
    }
}
