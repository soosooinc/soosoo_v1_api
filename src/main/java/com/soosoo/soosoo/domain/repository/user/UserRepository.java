package com.soosoo.soosoo.domain.repository.user;

import com.soosoo.soosoo.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom{
    User findByUserId(int userId);
}
