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

import com.czy.czycache.ValueHolder;


/**
 * Author: Chen zheng you
 * CreateTime: 2019-03-29 14:23
 * Description:缓存基础Vaule类，基础范型类
 */
public class BasicValueHolder<V> implements ValueHolder<V> {
	private final V refValue;

	public BasicValueHolder(final V value) {
		refValue = value;
	}

	public V value() {
		return refValue;
	}
}
