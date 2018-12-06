package com.speedtalk.smartkab.pay.ws;

import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Calendar;
import java.util.Date;

public class TokenUtil {
    public static String getJwtToken(String account, Calendar expiry, Key key) {
        SignatureAlgorithm alg = SignatureAlgorithm.HS256;
        return Jwts.builder()
                .setIssuer("ST-JWT")
                .setIssuedAt(new Date())
                .setExpiration(expiry.getTime())
                .setAudience("client")
                .setSubject(account)
                .signWith(alg, key)
                .compact();
    }

    public static Jws<Claims> checkJwtToken(String token, Key key) throws ExpiredJwtException, SignatureException {
        try {
            return Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());
        } catch (ExpiredJwtException eje) {
            throw eje; //token过期
        } catch (SignatureException se) {
            throw se; //token签名异常
        } catch (Exception e) {
            return null;
        }
    }
}
