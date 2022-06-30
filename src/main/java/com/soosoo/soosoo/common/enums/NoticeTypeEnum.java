package com.soosoo.soosoo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NoticeTypeEnum {
    ANNOUNCE((short)0),
    NOTICE((short)1),
    POST((short)2),
    COMMENT((short)3);

    private final short noticeType;
}
