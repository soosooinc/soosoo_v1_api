package com.soosoo.soosoo.service.notice;

import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.domain.repository.notice.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetNoticeService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public List<Notice> getNotice(String status, Integer kindergartenId, Pageable pageable) {
        return noticeRepository.getNotice(status, kindergartenId, pageable);
    }
}
