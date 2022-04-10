package com.soosoo.soosoo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    MANAGER(0),
    BOSS(1),
    TEACHER(2),
    USER(3);

    private final int userType;
}
