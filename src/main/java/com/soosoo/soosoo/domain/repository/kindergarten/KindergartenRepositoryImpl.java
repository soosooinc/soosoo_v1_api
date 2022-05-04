package com.soosoo.soosoo.domain.repository.kindergarten;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.common.enums.UserTypeEnum;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.soosoo.soosoo.domain.entity.QUser.user;
import static com.soosoo.soosoo.domain.entity.QImage.image;
import static com.soosoo.soosoo.domain.entity.QKindergarten.kindergarten;

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
                        .and(user.type.eq((short) UserTypeEnum.TEACHER.getUserType())))
                .fetch();
    }

    @Override
    public KindergartenJoinImageForResponse getKindergartenInfo(int kindergartenId){
        return jpaQueryFactory
                .select(Projections.constructor(KindergartenJoinImageForResponse.class, kindergarten, image))
                .from(kindergarten)
                .join(image)
                .on(kindergarten.imageId.eq(image.imageId)).fetchJoin()
                .fetchOne();
    }
}
