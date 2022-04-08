package com.soosoo.soosoo.controller.kindergarten.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class KindergartenResponse {
    @Getter
    @Builder
    @NoArgsConstructor
    public static class TeacherInfoResponse {
        private int userId;
        private String name;
        private String imageUrl;

        public TeacherInfoResponse(int userId, String name, String imageUrl) {
            this.userId = userId;
            this.name = name;
            this.imageUrl = imageUrl;
        }
    }
}
