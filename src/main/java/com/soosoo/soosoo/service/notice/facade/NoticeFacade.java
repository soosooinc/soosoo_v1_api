package com.soosoo.soosoo.service.notice.facade;

import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.service.notice.GetNoticeInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeFacade {
    private final GetNoticeInfoService getNoticeInfoService;

    @Transactional(readOnly = true)
    public Notice getNoticeInfo(int noticeId) {
        return getNoticeInfoService.getNoticeInfo(noticeId);
    }
    @Transactional(readOnly = true)
    public List<Notice> getNoticeList(short type){
        return getNoticeInfoService.getNoticeList(type);
    }
}
