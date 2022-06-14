package com.soosoo.soosoo.domain.repository.notice;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.common.enums.NoticeTypeEnum;
import com.soosoo.soosoo.domain.entity.Notice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.soosoo.soosoo.domain.entity.QNotice.notice;

@Repository
@RequiredArgsConstructor
public class NoticeRepositoryImpl implements NoticeRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Notice> getNotice(String status, Integer kindergartenId, Pageable pageable) {
        return jpaQueryFactory
                .selectFrom(notice)
                .where(notice.type.eq(NoticeTypeEnum.NOTICE.getNoticeType())
                        .and(notice.kindergartenId.eq(kindergartenId)))
                .limit(status.equals("main") ? 3 : pageable.getOffset())
                .offset(status.equals("main") ? 0 : pageable.getPageSize())
                .orderBy(notice.createdAt.desc())
                .fetch();
    }
}