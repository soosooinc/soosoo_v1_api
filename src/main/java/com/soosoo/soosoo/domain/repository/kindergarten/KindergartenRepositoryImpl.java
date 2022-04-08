package com.soosoo.soosoo.domain.repository.kindergarten;

import com.soosoo.soosoo.domain.repository.user.UserRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.soosoo.soosoo.domain.entity.QUser.user;
import static com.soosoo.soosoo.domain.entity.QImage.image;

@Repository
@RequiredArgsConstructor
public class KindergartenRepositoryImpl implements KindergartenRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<KindergartenResponse.TeacherInfoResponse> getTeacherInfo(int kindergartenId) {
        return jpaQueryFactory
                .select(Projections.constructor(KindergartenResponse.TeacherInfoResponse.class, user.userId, user.name, image.imageUrl))
                .from(user)
                .join(image)
                .on(user.imageId.eq(image.imageId)).fetchJoin()
                .where(user.kindergartenId.eq(kindergartenId)
                        .and(user.type.eq((short)2)))
                .fetch();
    }
}
