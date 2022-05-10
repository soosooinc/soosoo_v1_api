package com.soosoo.soosoo.service.notice;

import com.soosoo.soosoo.domain.entity.Notice;
import com.soosoo.soosoo.domain.repository.notice.NoticeRepository;
import com.soosoo.soosoo.domain.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetNoticeInfoService {
    private final NoticeRepository noticeRepository;

    @Transactional(readOnly = true)
    public Notice getNoticeInfo(int noticeId){
        return noticeRepository.findByNoticeId(noticeId);
    }
    @Transactional(readOnly = true)
    public List<Notice> getNoticeList(short type){
        return noticeRepository.findByType(type);
    }
}