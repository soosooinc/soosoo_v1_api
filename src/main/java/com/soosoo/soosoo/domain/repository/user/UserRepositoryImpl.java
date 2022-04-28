package com.soosoo.soosoo.domain.repository.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.controller.user.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.soosoo.soosoo.domain.entity.QUser.user;
import static com.soosoo.soosoo.domain.entity.QImage.image;
import static com.soosoo.soosoo.domain.entity.QKindergarten.kindergarten;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserResponse.UserInfoResponse getUserInfo(int userId) {
        return jpaQueryFactory
                .select(Projections.constructor(UserResponse.UserInfoResponse.class,
                        user.userId, kindergarten.name, image.imageUrl,
                        user.id, user.name, user.type, user.phone, user.email
                        ))
                .from(image)
                .innerJoin(user).on(image.imageId.eq(user.imageId))
                .innerJoin(kindergarten).on(kindergarten.kindergartenId.eq(user.kindergartenId))
                .where(user.userId.eq(userId))
                .fetchOne();
    }
}
