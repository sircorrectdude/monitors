package com.evodat.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * An implementation of a {@link HashMap} whose elements time out after a specified period of time.
 */
public class TimeoutMap<K, V> implements Map<K, V> {

	/** The _timeout millis. */
	private final long _timeoutMillis;

	/** The _map. */
	private final Map<K, V> _map = new HashMap<K, V>();

	/** The _timestamps. */
	private final Map<Long, K> _timestamps = new TreeMap<Long, K>();

	/** The _last timestamp. */
	private long _lastTimestamp = 0;

	/**
	 * Instantiates a new timeout map.
	 * 
	 * @param timeoutMillis
	 *            the timeout millis
	 */
	public TimeoutMap(final long timeoutMillis) {
		if (timeoutMillis < 0) {
			throw new IllegalArgumentException("Invalid timeout value: "
					+ timeoutMillis);
		}
		_timeoutMillis = timeoutMillis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#size()
	 */
	public synchronized int size() {
		prune();
		return _map.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#isEmpty()
	 */
	public synchronized boolean isEmpty() {
		prune();
		return _map.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public synchronized boolean containsKey(final Object key) {
		prune();
		return _map.containsKey(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public synchronized boolean containsValue(final Object value) {
		prune();
		return _map.containsValue(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public synchronized V get(final Object key) {
		prune();
		return _map.get(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public synchronized V put(final K key, final V value) {
		prune();
		_timestamps.put(getTimestamp(), key);
		return _map.put(key, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public synchronized V remove(final Object key) {
		prune();
		return _map.remove(key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public synchronized void putAll(final Map<? extends K, ? extends V> t) {
		prune();
		for (K key : t.keySet()) {
			_timestamps.put(getTimestamp(), key);
		}
		_map.putAll(t);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		_timestamps.clear();
		_map.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#keySet()
	 */
	public synchronized Set<K> keySet() {
		prune();
		return _map.keySet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#values()
	 */
	public synchronized Collection<V> values() {
		prune();
		return _map.values();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Map#entrySet()
	 */
	public synchronized Set<Map.Entry<K, V>> entrySet() {
		prune();
		return _map.entrySet();
	}

	/**
	 * Removes all entries that have timed out.
	 */
	private void prune() {
		long now = System.currentTimeMillis();
		Iterator<Long> i = _timestamps.keySet().iterator();
		while (i.hasNext()) {
			Long timestamp = i.next();
			if (now - timestamp.longValue() > _timeoutMillis) {
				Object key = _timestamps.get(timestamp);
				//                System.out.println("remove "+key);
				_map.remove(key);
				i.remove();
			} else {
				// The timestamp map is sorted, so we know all other
				// timestamps
				// are later
				return;
			}
		}
	}

	/**
	 * Returns the current system timestamp, possibly adjusted by a few milliseconds. Used to ensure
	 * that the timestamp TreeMap contains unique values.
	 * 
	 * @return the timestamp
	 */
	private Long getTimestamp() {
		long now = System.currentTimeMillis();
		if (now <= _lastTimestamp) {
			now = _lastTimestamp + 1;
		}
		_lastTimestamp = now;
		return new Long(_lastTimestamp);
	}
}