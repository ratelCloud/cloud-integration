package com.ratel.common.config;

import com.ratel.common.util.redis.CacheFactory;
import com.ratel.common.util.redis.ObjectRedisTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * ObjectRedisTemplate用于Hash list等操作
     *
     * @return
     */
    @Bean("objectRedisTemplate")
    public ObjectRedisTemplate objectRedisTemplate() {
        ObjectRedisTemplate redisTemplate = new ObjectRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        logger.info("Use ObjectRedisTemplate init redis：【{}】", redisTemplate);
        CacheFactory.setObjectRedisTemplate(redisTemplate);
        return redisTemplate;
    }

    /**
     * 普通字符串
     * @return
     */
    @Bean("stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        logger.info("Use StringRedisTemplate init redis：【{}】", redisTemplate);
        CacheFactory.setStringRedisTemplate(redisTemplate);
        return redisTemplate;
    }
}
