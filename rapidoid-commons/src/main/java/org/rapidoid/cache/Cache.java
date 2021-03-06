/*-
 * #%L
 * rapidoid-commons
 * %%
 * Copyright (C) 2014 - 2018 Nikolche Mihajlovski and contributors
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.rapidoid.cache;

import org.rapidoid.annotation.Authors;
import org.rapidoid.annotation.Since;
import org.rapidoid.cache.impl.CacheStats;

@Authors("Nikolche Mihajlovski")
@Since("5.3.0")
public interface Cache<K, V> {

	/**
	 * Returns the cached value for the given key, recalculating/reloading it if expired.
	 */
	V get(K key);

	/**
	 * Retrieves the cached value for the given key if it exists, or <code>null</code> otherwise.
	 */
	V getIfExists(K key);

	/**
	 * Invalidates the cached value for the given key.
	 */
	void invalidate(K key);

	/**
	 * Sets a new cached value for the given key.
	 */
	void set(K key, V value);

	/**
	 * Clears the cache.
	 */
	void clear();

	/**
	 * Returns (an estimation of) the number of entries in the cache.
	 */
	long size();

	/**
	 * Notifies the cache that it's being bypassed due to any reason (useful for stats).
	 */
	void bypass();

	/**
	 * Retrieves the cache statistics.
	 */
	CacheStats stats();

	/**
	 * Retrieves the cache name.
	 */
	String name();

	/**
	 * Retrieves the cache capacity.
	 */
	int capacity();

	/**
	 * Retrieves the cache TTL.
	 */
	long ttl();

}
