package com.jx.platform.dto.raffle;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RaffleStatusDto {

    @NotBlank
    private String lotNo;

    @NotNull
    private Integer status;
}
