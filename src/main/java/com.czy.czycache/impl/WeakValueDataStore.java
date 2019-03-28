/*
 * Copyright (c) 2008-2018  monkey01 All Rights Reserved.
 *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 */

package com.czy.czycache.impl;



import com.czy.czycache.CacheException;
import com.czy.czycache.DataStore;
import com.czy.czycache.ValueHolder;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-28 16:32
 * Description: 弱引用数据类型缓存数据类型
 */
public class WeakValueDataStore<K, V> implements DataStore<K, V> {

	ConcurrentHashMap<K, ValueHolder<V>> map = new ConcurrentHashMap<K, ValueHolder<V>>();

	@Override
	public ValueHolder<V> get(K key) throws CacheException {
		return map.get(key);
	}

	@Override
	public DataStore.PutStatus put(K key, V value) throws CacheException {
		ValueHolder<V> v = new WeakValueHolder<V>(value);
		map.put(key, v);
		return PutStatus.PUT;
	}

	@Override
	public ValueHolder<V> remove(K key) throws CacheException {
		return map.remove(key);
	}

	@Override
	public void clear() throws CacheException {
		map.clear();
	}

}
