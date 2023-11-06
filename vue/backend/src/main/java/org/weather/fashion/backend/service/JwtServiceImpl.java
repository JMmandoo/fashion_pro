package org.weather.fashion.backend.service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.xml.bind.DatatypeConverter;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtServiceImpl implements JwtService{

  private String secretKey = "acbahjci1asda@@@s24asdiasdi15i1!!!5asdaisdasdiasdhi113";

  @Override
  public String getToken(String key, Object value) {

    Date expTime = new Date();
    expTime.setTime(expTime.getTime() + 1000 * 60 * 5);
    byte[] secretByteKey = DatatypeConverter.parseBase64Binary(secretKey);
    Key signKey = new SecretKeySpec(secretByteKey, SignatureAlgorithm.HS256.getJcaName());
    Map<String , Object> headerMap = new HashMap<>();
    headerMap.put("typ", "jwt");
    headerMap.put("alg", "HS256");

    Map<String, Object> map =new HashMap<>();
    map.put(key, value);

    JwtBuilder builder = Jwts.builder().setHeader(headerMap)
        .setClaims(map)
        .setExpiration(expTime)
        .signWith(signKey, SignatureAlgorithm.HS256);

    return builder.compact();
  }
}
