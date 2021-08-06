package com.jx.platform.framework.security.jwt;

import com.jx.platform.framework.security.PlatformUserDetail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TokenAuthenticationHelper {
    private static final String SECRET_KEY = "boot-jx-token-secret";

    /**
     * 未设置记住我时 token 过期时间 1 天
     */
    public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24 ;

    /**
     * 对请求的验证
     */
    public static JwtToken getJwtToken(HttpServletRequest request) {
        String authInfo = request.getHeader("Authorization");
        String token = StringUtils.removeStart(authInfo, "Bearer ");
        if (token != null) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            JwtToken jwtToken = new JwtToken();
            jwtToken.setSign(claims.get("sign").toString());
            jwtToken.setSubject(claims.getSubject());
            return jwtToken;
        }
        return null;
    }


    /**
     * 设置登陆成功后令牌返回
     */
    public static String generateToken(PlatformUserDetail detail) {

        String jwt = Jwts.builder()
                // Subject 设置用户名
                .setSubject(detail.getUsername())
                // 设置用户权限
                .claim("sign", getSign(detail))
                // 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                // 签名算法
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
        return jwt;
    }

    public static String getSign(PlatformUserDetail detail) {

        return DigestUtils.md5DigestAsHex(DigestUtils.md5DigestAsHex((detail.getUsername() + detail.getLastLoginTime() + "jx" + detail.getSalt()).getBytes()).getBytes());
    }


    public static boolean checkSign(String sign, PlatformUserDetail detail) {
        if (StringUtils.isEmpty(sign) || detail == null) {
            return false;
        }
        return sign.equals(getSign(detail));
    }

}
