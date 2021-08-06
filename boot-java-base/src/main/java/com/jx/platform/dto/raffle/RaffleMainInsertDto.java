package com.jx.platform.dto.raffle;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class RaffleMainInsertDto {

    @NotBlank
    @Length(max = 50)
    private String lotNo;
    @NotBlank
    @Length(max = 50)
    private String name;
    @NotBlank
    @Length(max = 1,min = 1)
    private String raffleType;
    @NotNull
    private Integer totalNum;
    @NotBlank
    @Length(max = 255)
    private String coverUrl;
    @NotBlank
    private String noPrizesMsg;

    @NotEmpty
    @Valid
    private List<RaffleAwardInsertDto> awards;
}
