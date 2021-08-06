package com.jx.platform.dto.raffle;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class RaffleAwardInsertDto {

    /**
     *
     */
    @NotBlank
    private String prizesName;

    /**
     *
     */
    @NotNull
    @Min(1)
    private Integer prizesNum;
}
