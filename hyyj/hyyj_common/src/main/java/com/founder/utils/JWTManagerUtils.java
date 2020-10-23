package com.founder.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTManagerUtils {

    /**
     * 生成token
     * @param claims
     * @param sercet
     * @return
     */
    public static String createToken(Claims claims,String sercet){
        JwtBuilder jwts=Jwts.builder();
        jwts.setClaims(claims);
        jwts.signWith(SignatureAlgorithm.HS256,sercet);
        return jwts.compact();
    }


    public static Claims getClaims(String token,String sercet){
        Claims claims=null;
        claims=Jwts.parser().setSigningKey(sercet).parseClaimsJws(token).getBody();
        return claims;
    }
    /**
     * 验证token
     * @param token
     * @param sercet
     * @return
     */
    public static boolean vaild(String token,String sercet){
        try {
            Jwts.parser().setSigningKey(sercet).parseClaimsJws(token.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Claims claims=Jwts.claims();
        claims.put("user","id");
        claims.put("role","admin");
        String token=createToken(claims,"Founder");
        String token2=createToken(claims,"Founder22");
        System.out.println(token);
        System.out.println(getClaims(token,"Founder"));
    }
}
