package com.nnxx.util;

import io.jsonwebtoken.Claims;

public class ParseTokenUtils {
    public static Long parseToken(String token){
        String substring = token.substring(7);
        Claims claims = JwtUtils.parseJWT(substring);
        Object userid = claims.get("Token");
        return Long.valueOf(userid.toString());
    }
}
