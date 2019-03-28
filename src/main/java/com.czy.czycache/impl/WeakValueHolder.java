package com.czy.czycache.impl;

import com.czy.czycache.ValueHolder;

import java.lang.ref.WeakReference;


/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-28 16:29
 * Description:基于引用淘汰算法：弱引用value数据类型
 */
public class WeakValueHolder<V> implements ValueHolder<V>{


    private WeakReference<V> v;

    /**
     * 使用 JDK 提供的 WeakReference 对象，建立引用。
     * 在没有强引用时，JVM GC将收回对象，调用WeakReference.get  将返回null。
     *
     * @param value
     */
    public WeakValueHolder(V value) {
        super();
        if (null == value) {
            return;
        }
        this.v = new WeakReference<V>(value);
    }


    @Override
    public V value() {
        return this.v.get();
    }
}
