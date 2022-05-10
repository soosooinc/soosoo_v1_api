package com.soosoo.soosoo.domain.repository.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.common.enums.UserTypeEnum;
import com.soosoo.soosoo.controller.user.dto.UserResponse.UserInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.soosoo.soosoo.domain.entity.QUser.user;
import static com.soosoo.soosoo.domain.entity.QImage.image;
import static com.soosoo.soosoo.domain.entity.QKindergarten.kindergarten;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserInfoResponse getUserInfo(int userId) {
        return jpaQueryFactory
                .select(Projections.constructor(UserInfoResponse.class,
                        user.userId, kindergarten.name, image.imageUrl,
                        user.id, user.name, user.type, user.phone, user.email
                        ))
                .from(user)
                .join(image).on(user.imageId.eq(image.imageId)).fetchJoin()
                .join(kindergarten).on(user.kindergartenId.eq(kindergarten.kindergartenId)).fetchJoin()
                .where(user.userId.eq(userId))
                .fetchOne();
    }

    @Override
    public List<UserInfoResponse> getUserInfoByName(String userName) {
        return jpaQueryFactory
                .select(Projections.constructor(UserInfoResponse.class,
                        user.userId, kindergarten.name, image.imageUrl,
                        user.id, user.name, user.type, user.phone, user.email
                ))
                .from(user)
                .join(image).on(user.imageId.eq(image.imageId)).fetchJoin()
                .join(kindergarten).on(user.kindergartenId.eq(kindergarten.kindergartenId)).fetchJoin()
                .where(user.name.contains(userName).and(user.type.eq((short)UserTypeEnum.TEACHER.getUserType())))
                .fetch();
    }
}
