package com.soosoo.soosoo.controller.image.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ImageResponse {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class ImageForResponse {
        private Integer imageId;
        private String imageUrl;
        private Short type;
    }
}
