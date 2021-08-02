package com.jx.platform.dto.raffle;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RaffleListDto {

    @NotNull
    private Integer pageNum;
    @NotNull
    private Integer pageSize;
    private String lotNo;
    private String name;
}
