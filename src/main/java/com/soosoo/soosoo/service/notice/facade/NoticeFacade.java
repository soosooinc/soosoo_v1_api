package com.soosoo.soosoo.service.notice.facade;

import com.soosoo.soosoo.controller.notice.dto.NoticeDto;
import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.service.notice.AddNoticeInfoServcie;
import com.soosoo.soosoo.service.notice.GetNoticeInfoService;
import com.soosoo.soosoo.service.notice.GetNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeFacade {
    private final GetNoticeInfoService getNoticeInfoService;
    private final AddNoticeInfoServcie addNoticeInfoServcie;
    private final GetNoticeService getNoticeService;

    @Transactional(readOnly = true)
    public Notice getNoticeInfo(int noticeId) {
        return getNoticeInfoService.getNoticeInfo(noticeId);
    }
    @Transactional(readOnly = true)
    public List<Notice> getNoticeList(short type){
        return getNoticeInfoService.getNoticeList(type);
    }
    public Notice addNotice(NoticeDto noticeDto){
        return addNoticeInfoServcie.addNotice(noticeDto);
    }

    @Transactional(readOnly = true)
    public List<Notice> getNotice(String type, Integer kindergartenId, Pageable pageable) {
        return getNoticeService.getNotice(type, kindergartenId, pageable);
    }
}
