package com.soosoo.soosoo.controller.notice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class NoticeDto {
    private Integer noticeId;
    private Integer imageId;
    private Integer topId;
    private Short type;
    private String mainText;
    private String subText;
}
