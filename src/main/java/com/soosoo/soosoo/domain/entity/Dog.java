package com.soosoo.soosoo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "tb_dog")
@DynamicInsert
@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dog extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer dogId;

    @Column(name = "user_id_fk", nullable = false, columnDefinition = "TEXT")
    private Integer userId;

    @Column(name = "image_id_fk")
    private Integer imageId;

    @Column(columnDefinition = "TEXT")
    private String name;

    @Column(columnDefinition = "TEXT")
    private String kind;

    @Column(columnDefinition = "TEXT")
    private String birthday;

    @Column(columnDefinition = "TEXT")
    private String size;

    @Column(columnDefinition = "TEXT")
    private String etc;
}
