package com.huang.cache;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author HYL
 * @Date 2023/7/16
 * @Version 1.0
 * @Description
 */

public class RedisTokenRepository implements PersistentTokenRepository {

    //Key名前缀，用于区分
    private final static String REMEMBER_ME_KEY = "spring:security:rememberMe";
    @Resource
    RedisTemplate<Object, Object> template;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        //这里要放置两个，一个存seriesId->Token，一个存username->seriesId，因为删除时是通过username删除
        template.opsForValue().set(REMEMBER_ME_KEY + "username:" + token.getUsername(), token.getSeries());
        template.expire(REMEMBER_ME_KEY + "username:" + token.getUsername(), 1, TimeUnit.DAYS);
        this.setToken(token);
    }

    //先获取，然后修改创建一个新的，再放入
    @Override
    public void updateToken(String series, String tokenValue, Date lastUsed) {
        PersistentRememberMeToken token = this.getToken(series);
        if (token != null) {
            this.setToken(new PersistentRememberMeToken(token.getUsername(), series, tokenValue, lastUsed));
        }
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return this.getToken(seriesId);
    }

    @Override
    public void removeUserTokens(String username) {
        String series = (String) template.opsForValue().get(REMEMBER_ME_KEY + "username:" + username);
        template.delete(REMEMBER_ME_KEY + series);
        template.delete(REMEMBER_ME_KEY + "username:" + username);
    }

    //由于PersistentRememberMeToken没有实现序列化接口，就只能使用Hash来存储，所以单独编写set和get操作
    private PersistentRememberMeToken getToken(String series) {
        Map<Object, Object> map = template.opsForHash().entries(REMEMBER_ME_KEY + series);
        if (map.isEmpty()) return null;
        return new PersistentRememberMeToken(
                (String) map.get("username"),
                (String) map.get("series"),
                (String) map.get("tokenValue"),
                new Date(Long.parseLong((String) map.get("date")))
        );
    }

    private void setToken(PersistentRememberMeToken token) {
        Map<String, String> map = new HashMap<>();
        map.put("username", token.getUsername());
        map.put("series", token.getSeries());
        map.put("tokenValue", token.getTokenValue());
        map.put("date", String.valueOf(token.getDate().getTime()));
        template.opsForHash().putAll(REMEMBER_ME_KEY + token.getSeries(), map);
        template.expire(REMEMBER_ME_KEY + token.getSeries(), 1, TimeUnit.DAYS);
    }
}
