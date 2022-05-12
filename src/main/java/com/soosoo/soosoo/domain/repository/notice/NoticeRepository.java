package com.soosoo.soosoo.domain.repository.notice;

import com.soosoo.soosoo.domain.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer>, NoticeRepositoryCustom {
    Notice findByNoticeId(int noticeId);
    List<Notice> findByType(short type);
}