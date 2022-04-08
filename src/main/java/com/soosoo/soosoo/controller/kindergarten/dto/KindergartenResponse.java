package com.soosoo.soosoo.controller.kindergarten.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class KindergartenResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    public static class TeacherInfoResponse {
        private Integer userId;
        private String name;
        private String imageUrl;

        public TeacherInfoResponse(Integer userId, String name, String imageUrl) {
            this.userId = userId;
            this.name = name;
            this.imageUrl = imageUrl;
        }
    }
}
