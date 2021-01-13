package com.example.priority.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userpriority")
@IdClass(UserPriorityId.class)
public class UserPriority  {
    @Id
    private Integer userId;
    @Id
    private Integer areaId;
    private Integer priority;
    private Integer rating;
}
