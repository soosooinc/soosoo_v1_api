package com.soosoo.soosoo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeTypeEnum {
    ANNOUNCE(0),
    NOTICE(1),
    POST(2),
    COMMENT(3);

    private final int noticeType;
}
