package com.jx.platform.framework.security.jwt;

import lombok.Data;

@Data
public class JwtToken {
    private String subject;
    private String sign;

}
