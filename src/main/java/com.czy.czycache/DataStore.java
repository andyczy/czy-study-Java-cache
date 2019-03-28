package com.czy.czycache;

/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-28 16:36
 * Description:缓存数据存储接口
 */
public interface DataStore<K, V> {

    ValueHolder<V> get(K key) throws CacheException;

    PutStatus put(K key, V value) throws CacheException;

    ValueHolder<V> remove(K key) throws CacheException;

    void clear() throws CacheException;

    enum PutStatus {
        /**
         * 新的数据插入
         */
        PUT,
        /**
         * 缓存中存在数据，进行缓存更新
         */
        UPDATE,
        /**
         * 缓存数据被删除
         */
        DROP
    }
}
