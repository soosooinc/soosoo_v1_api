package com.soosoo.soosoo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "tb_notice")
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer noticeId;

    @Column(name = "image_id_fk")
    private Integer imageId;

    @Column(nullable = false)
    private Integer topId;

    @Column(nullable = false, columnDefinition = "smallint")
    private Short type;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mainText;

    @Column(columnDefinition = "TEXT")
    private String subText;

    @Column(name = "kindergarten_id_fk")
    private Integer kindergartenId;
}
