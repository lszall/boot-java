package com.jx.platform.dto.raffle;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RaffleStatusDto {

    @NotBlank
    private String lotNo;
}
