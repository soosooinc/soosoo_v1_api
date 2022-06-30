package com.soosoo.soosoo.domain.repository.notice;

import com.soosoo.soosoo.domain.entity.Notice;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoticeRepositoryCustom {
    List<Notice> getNotice(String type, Integer kindergartenId, Pageable pageable);
}
