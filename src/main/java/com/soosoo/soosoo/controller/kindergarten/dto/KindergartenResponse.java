package com.soosoo.soosoo.controller.kindergarten.dto;

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
}
