package com.example.priority.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="area")
public class Area {
    @Id
    private Integer areaId;
    private String areaName;
}
