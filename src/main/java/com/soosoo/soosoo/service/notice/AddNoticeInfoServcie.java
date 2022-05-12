package com.soosoo.soosoo.service.notice;

import com.soosoo.soosoo.controller.notice.dto.NoticeDto;
import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.domain.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddNoticeInfoServcie {
    private final NoticeRepository noticeRepository;

    public Notice addNotice(NoticeDto noticeDto){
        Notice notice = Notice.builder().
                noticeId(noticeDto.getNoticeId())
                .imageId(noticeDto.getImageId())
                .subText(noticeDto.getSubText())
                .topId(noticeDto.getTopId())
                .mainText(noticeDto.getMainText())
                .type(noticeDto.getType())
                .build();
        return noticeRepository.save(notice);
    }
}
