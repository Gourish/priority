package com.example.priority.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPriorityId implements Serializable {
    private Integer userId;
    private Integer areaId;
}
