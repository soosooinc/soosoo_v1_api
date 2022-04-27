package com.soosoo.soosoo.domain.repository.user;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.soosoo.soosoo.controller.user.dto.UserResponse;
import com.soosoo.soosoo.domain.entity.QImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.soosoo.soosoo.domain.entity.QImage.image;
import static com.soosoo.soosoo.domain.entity.QUser.user;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserResponse.UserInfoResponse getUserInfo(int userId) {
        return null;
    }
}
