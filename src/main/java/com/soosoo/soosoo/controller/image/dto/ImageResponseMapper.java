package com.soosoo.soosoo.controller.image.dto;

import com.soosoo.soosoo.controller.image.dto.ImageResponse.ImageForResponse;
import com.soosoo.soosoo.domain.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageResponseMapper {
    ImageResponseMapper INSTANCE = Mappers.getMapper(ImageResponseMapper.class);

    ImageForResponse of(Image image);
}
