package com.soosoo.soosoo.service.kindergarten;

import com.soosoo.soosoo.domain.entity.Kindergarten;
import com.soosoo.soosoo.domain.entity.User;
import com.soosoo.soosoo.domain.repository.kindergarten.KindergartenRepository;
import com.soosoo.soosoo.domain.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetKindergartenInfoService {
    private final KindergartenRepository kindergartenRepository;

    @Transactional(readOnly = true)
    public Kindergarten getKindergartenInfo(int kindergartenId) {
        return kindergartenRepository.findByKindergartenId(kindergartenId);
    }
}
