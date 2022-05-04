package com.soosoo.soosoo.controller.kindergarten.dto;

import com.soosoo.soosoo.controller.image.dto.ImageResponse.ImageForResponse;
import com.soosoo.soosoo.controller.image.dto.ImageResponseMapper;
import com.soosoo.soosoo.domain.entity.Image;
import com.soosoo.soosoo.domain.entity.Kindergarten;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class KindergartenResponse {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class TeacherInfoResponse {
        private Integer userId;
        private String name;
        private String imageUrl;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class KindergartenForResponse {
        private Integer kindergartenId;
        private String name;
        private String address;
        private String phone;
        private Integer imageId;
        private String imageUrl;
        private Short type;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class KindergartenJoinImageForResponse {
        private KindergartenForResponse kindergarten;
        private ImageForResponse image;

        public KindergartenJoinImageForResponse(Kindergarten kindergarten, Image image) {
            this.kindergarten = KindergartenResponseMapper.INSTANCE.of(kindergarten);
            this.image = ImageResponseMapper.INSTANCE.of(image);
        }
    }
}
