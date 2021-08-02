package com.jx.platform.dto.raffle;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RaffleResultUploadDto {

    @NotBlank
    private String lotNo;
    @NotNull
    private Integer id;
}
