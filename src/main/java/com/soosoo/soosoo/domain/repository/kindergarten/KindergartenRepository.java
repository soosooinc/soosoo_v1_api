package com.soosoo.soosoo.domain.repository.kindergarten;

import com.soosoo.soosoo.domain.entity.Kindergarten;
import com.soosoo.soosoo.domain.entity.User;
import com.soosoo.soosoo.domain.repository.user.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KindergartenRepository extends JpaRepository<Kindergarten,Integer>, KindergartenRepositoryCustom{
    Kindergarten findByKindergartenId(int kindergartenId);
}
