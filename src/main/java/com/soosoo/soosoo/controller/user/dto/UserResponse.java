package com.soosoo.soosoo.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class UserResponse {
    @Getter
    @Builder
    @AllArgsConstructor
    public static class UserInfoResponse {
        private Integer userId;
        private String kindergartenName;
        private String imageUrl;
        private String id;
        private String name;
        private Short type;
        private String phone;
        private String email;
    }
}
