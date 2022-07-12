package com.soosoo.soosoo.domain.repository.kindergarten;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.common.enums.UserTypeEnum;
import com.soosoo.soosoo.controller.image.dto.ImageResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse;
import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenJoinImageForResponse;
import com.soosoo.soosoo.domain.entity.Image;
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
                .where(kindergarten.kindergartenId.eq(kindergartenId))
                .fetchOne();
    }

    @Override
    public long addTeacher(int kindergartenId, int userId){
        return jpaQueryFactory
                .update(user)
                .set(user.kindergartenId, kindergartenId)
                .where(user.userId.eq(userId).and(user.type.eq((short)UserTypeEnum.TEACHER.getUserType())))
                .execute();
    }

    @Override
    public long updateKindergartenInfo(KindergartenJoinImageForResponse kindergartenJoinImage){
        long kindergartenResult = jpaQueryFactory
                .update(kindergarten)
                .set(kindergarten.name, kindergartenJoinImage.getKindergarten().getName())
                .set(kindergarten.address, kindergartenJoinImage.getKindergarten().getAddress())
                .set(kindergarten.phone, kindergartenJoinImage.getKindergarten().getPhone())
                .set(kindergarten.imageId, kindergartenJoinImage.getKindergarten().getImageId())
                .where(kindergarten.kindergartenId.eq(kindergartenJoinImage.getKindergarten().getKindergartenId()))
                .execute();

        long imageResult = jpaQueryFactory
                .update(image)
                .set(image.imageUrl, kindergartenJoinImage.getImage().getImageUrl())
                .set(image.type, kindergartenJoinImage.getImage().getType())
                .where(image.imageId.eq(kindergartenJoinImage.getImage().getImageId()))
                .execute();

        return kindergartenResult & imageResult;
    }

}
