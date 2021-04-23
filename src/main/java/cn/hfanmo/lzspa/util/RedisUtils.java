package cn.hfanmo.lzspa.util;


import cn.hfanmo.lzspa.pojo.common.BaseResult;
import cn.hfanmo.lzspa.pojo.common.SetData;
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
     * 鍗曟潯鏌ヨ
     *
     * @param key
     * @return
     */
    public String getByKey(String key) {
        if (!ObjectUtils.isEmpty(key)) {
            return redisTemplate.opsForValue().get(key);
        }
        return null;
    }

    /**
     * SetData鍗曟潯鏌ヨ
     *
     * @param data
     * @return
     */
    public String getBySetData(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKey())) {
            return redisTemplate.opsForValue().get(data.getKey());
        }
        return null;
    }

    /**
     * SetData鎵归噺鏌ヨ
     *
     * @param data
     * @return
     */
    public List<String> multiGet(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKeys())) {
            return redisTemplate.opsForValue().multiGet(data.getKeys());
        }
        return null;
    }

    /**
     * List鎵归噺鏌ヨ
     *
     * @param keys
     * @return
     */
    public List<String> multiGetForList(List<String> keys) {
        if (!ObjectUtils.isEmpty(keys)) {
            return redisTemplate.opsForValue().multiGet(keys);
        }
        return null;
    }


    /**
     * setKv 鍗曟潯鎻掑叆
     *
     * @return
     */
    public boolean setKv(String key, String value) {
        if (!ObjectUtils.isEmpty(key) && !ObjectUtils.isEmpty(value)) {
            redisTemplate.opsForValue().set(key, value);
            return true;
        }
        return false;
    }

    /**
     * SetData 鍗曟潯鎻掑叆
     *
     * @param data
     * @return
     */
    public boolean set(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKey()) && !ObjectUtils.isEmpty(data.getValue())) {
            if (ObjectUtils.isEmpty(data.getTime())) {
                redisTemplate.opsForValue().set(data.getKey(), data.getValue());
                return true;
            } else {
                redisTemplate.opsForValue().set(data.getKey(), data.getValue(), data.getTime(), TimeUnit.SECONDS);
                return true;
            }
        }
        return false;
    }

    /**
     * Setdata鎵归噺鎻掑叆
     *
     * @param data
     * @return
     */
    public boolean multiSet(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKvs())) {
            if (ObjectUtils.isEmpty(data.getTime())) {
                redisTemplate.opsForValue().multiSet(data.getKvs());
                return true;
            } else {
                data.getKvs().forEach((key, value) -> {
                    redisTemplate.opsForValue().set(key, value, data.getTime(), TimeUnit.SECONDS);
                });
                return true;
            }
        }
        return false;
    }

    /**
     * Map鎵归噺鎻掑叆
     *
     * @param map
     * @return
     */
    public boolean multiSetForMap(Map<String, String> map) {
        if (!ObjectUtils.isEmpty(map)) {
            redisTemplate.opsForValue().multiSet(map);
            return true;
        }
        return false;
    }

    /**
     * SetData鍗曞垹
     *
     * @param data
     * @return
     */
    public boolean delete(SetData data) {
        if (!ObjectUtils.isEmpty(data.getKey())) {
            return redisTemplate.delete(data.getKey());
        }
        return false;
    }

    /**
     * SetData鎵归噺鍒犻櫎
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
     * List鎵归噺鍒犻櫎
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
}