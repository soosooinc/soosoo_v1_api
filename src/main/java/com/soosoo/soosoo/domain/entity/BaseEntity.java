package com.soosoo.soosoo.domain.entity;

import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

@Getter
@DynamicInsert
@DynamicUpdate
@MappedSuperclass
public class BaseEntity {
    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date createdAt;

    private String createdBy;

    @Column(columnDefinition = "TIMESTAMP", nullable = false)
    private Date modifiedAt;

    private String modifiedBy;
}
