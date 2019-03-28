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

package com.czy.czycache;


/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-28 16:32
 * Description: Cache缓存工具类
 */
public class CzyCache<K, V> {
	private final DataStore<K, V> store;

	public CzyCache(final DataStore<K, V> dataStore) {
		store = dataStore;
	}

	public V get(final K key) {
		try {
			ValueHolder<V> value = store.get(key);
			if (null == value) {
				return null;
			}
			return value.value();
		} catch (CacheException e) {
			System.out.println(e.getStackTrace().toString());
			return null;
		}
	}

	public void put(final K key, final V value) {
		try {
			store.put(key, value);
		} catch (CacheException e) {
			System.out.println(e.getStackTrace().toString());

		}
	}

	public V remove(K key) {
		try {
			ValueHolder<V> value = store.remove(key);
			return value.value();
		} catch (CacheException e) {
			System.out.println(e.getStackTrace().toString());

			return null;
		}
	}

	public void clear() {
		try {
			store.clear();
		} catch (CacheException e) {
			System.out.println(e.getStackTrace().toString());

		}
	}
}
