package cn.hfanmo.lzspa.util;


import cn.cutenine.aisi.pojo.entity.BaseResult;
import cn.cutenine.aisi.pojo.entity.SetData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private BaseResult result = new BaseResult(200);

    private BaseResult paramResult = new BaseResult(4001);

    /**
     * setKv 单条插入
     *
     * @return
     */
    public BaseResult setKv(String key, String value) {
        if (!ObjectUtils.isEmpty(key) && !ObjectUtils.isEmpty(value)) {
            redisTemplate.opsForValue().set(key, value);
            return result;
        }
        return paramResult;
    }

    /**
     * SetData 单条插入
     *
     * @param data
     * @return
     */
    public BaseResult set(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKey()) && !ObjectUtils.isEmpty(data.getValue())) {
            if (ObjectUtils.isEmpty(data.getTime())) {
                redisTemplate.opsForValue().set(data.getKey(), data.getValue());
                return result;
            } else {
                redisTemplate.opsForValue().set(data.getKey(), data.getValue(), data.getTime(), TimeUnit.SECONDS);
                return result;
            }
        }
        return paramResult;
    }

    /**
     * Setdata批量插入
     *
     * @param data
     * @return
     */
    public BaseResult multiSet(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKvs())) {
            if (ObjectUtils.isEmpty(data.getTime())) {
                redisTemplate.opsForValue().multiSet(data.getKvs());
                return result;
            } else {
                data.getKvs().forEach((key, value) -> {
                    redisTemplate.opsForValue().set(key, value, data.getTime(), TimeUnit.SECONDS);
                });
                return result;
            }
        }
        return paramResult;
    }

    /**
     * Map批量插入
     *
     * @param map
     * @return
     */
    public BaseResult multiSetForAccess(Map<String, String> map) {
        if (!ObjectUtils.isEmpty(map)) {
            redisTemplate.opsForValue().multiSet(map);
            return result;
        }
        return paramResult;
    }

    /**
     * SetData单删
     *
     * @param data
     * @return
     */
    public BaseResult delete(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKey())) {
            Boolean delete = redisTemplate.delete(data.getKey());
            return new BaseResult(delete);
        }
        return paramResult;
    }

    /**
     * SetData批量删除
     *
     * @param data
     * @return
     */
    public BaseResult multiDelete(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKeys()) && data.getKeys().size() > 0) {
            List<String> keys = data.getKeys();
            Map<String, List<String>> map = new HashMap<>();
            List<String> successKey = new ArrayList<>();
            List<String> failKey = new ArrayList<>();
            for (String key : keys) {
                if (redisTemplate.hasKey(key)) {
                    successKey.add(key);
                    redisTemplate.delete(key);
                } else {
                    failKey.add(key);
                }
            }
            if (!ObjectUtils.isEmpty(successKey)) {
                map.put("successKey", successKey);
            }
            if (!ObjectUtils.isEmpty(failKey)) {
                map.put("failKey", failKey);
            }
            if (!ObjectUtils.isEmpty(map)) {
                return new BaseResult(map);
            }
            return result;
        }
        return paramResult;
    }

    /**
     * List批量删除
     *
     * @param keys
     * @return
     */
    public BaseResult multiDeleteForAccess(List<String> keys) {
        if (!ObjectUtils.isEmpty(keys) && keys.size() > 0) {
            Map<String, List<String>> map = new HashMap<>();
            List<String> successKey = new ArrayList<>();
            List<String> failKey = new ArrayList<>();
            for (String key : keys) {
                if (redisTemplate.hasKey(key)) {
                    successKey.add(key);
                    redisTemplate.delete(key);
                } else {
                    failKey.add(key);
                }
            }
            if (!ObjectUtils.isEmpty(successKey)) {
                map.put("successKey", successKey);
            }
            if (!ObjectUtils.isEmpty(failKey)) {
                map.put("failKey", failKey);
            }
            if (!ObjectUtils.isEmpty(map)) {
                return new BaseResult(map);
            }
            return result;
        }
        return paramResult;
    }


    /**
     * SetData单条查询
     *
     * @param key
     * @return
     */
    public BaseResult getByKey(String key) {
        if (!ObjectUtils.isEmpty(key)) {
            String value = redisTemplate.opsForValue().get(key);
            return new BaseResult(value);
        }
        return paramResult;
    }

    /**
     * SetData单条查询
     *
     * @param data
     * @return
     */
    public BaseResult get(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKey())) {
            String value = redisTemplate.opsForValue().get(data.getKey());
            return new BaseResult(value);
        }
        return paramResult;
    }

    /**
     * SetData批量查询
     *
     * @param data
     * @return
     */
    public BaseResult multiGet(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKeys())) {
            List<String> strings = redisTemplate.opsForValue().multiGet(data.getKeys());
            return new BaseResult(strings);
        }
        return paramResult;
    }

    /**
     * List批量查询
     *
     * @param keys
     * @return
     */
    public BaseResult multiGetForAccess(List<String> keys) {
        if (!ObjectUtils.isEmpty(keys)) {
            List<String> strings = redisTemplate.opsForValue().multiGet(keys);
            return new BaseResult(strings);
        }
        return paramResult;
    }

}
