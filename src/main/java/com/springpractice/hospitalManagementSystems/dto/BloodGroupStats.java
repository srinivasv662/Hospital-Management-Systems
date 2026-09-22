package com.springpractice.hospitalManagementSystems.dto;

import com.springpractice.hospitalManagementSystems.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType bloodGroupType;
    private final Long count;
}
