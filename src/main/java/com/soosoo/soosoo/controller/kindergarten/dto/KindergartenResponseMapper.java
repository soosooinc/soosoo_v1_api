package com.soosoo.soosoo.controller.kindergarten.dto;

import com.soosoo.soosoo.controller.kindergarten.dto.KindergartenResponse.KindergartenForResponse;
import com.soosoo.soosoo.domain.entity.Kindergarten;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface KindergartenResponseMapper {
    KindergartenResponseMapper INSTANCE = Mappers.getMapper(KindergartenResponseMapper.class);

    KindergartenForResponse of(Kindergarten kindergarten);
}
