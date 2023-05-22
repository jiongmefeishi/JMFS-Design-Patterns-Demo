package me.jmfs.pattern.sdk.command.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 囧么肥事
 * @Date: 2023/5/15
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: BoundedConcurrentHashMap 是一个具有固定大小边界（bound）的线程安全的哈希表。
 * 当哈希表达到边界时，新插入的键值对会替换掉最早被插入的键值对。
 */
public class BoundedConcurrentHashMap<K, V> extends LinkedHashMap<K, V> {

    private static final Logger logger = LoggerFactory.getLogger(BoundedConcurrentHashMap.class);
    private static final long serialVersionUID = 2615986629983154259L;
    private static final int DEFAULT_CAPACITY = 389;
    protected volatile int capacity;
    /**
     * 可重入锁，ReentrantLock 通常用来保护临界区资源的访问，从而避免竞态条件和数据竞争问题
     */
    private final Lock lock = new ReentrantLock();

    public BoundedConcurrentHashMap(int capacity) {
        super(capacity * 4 / 3 + 1, 0.75f, true);
        this.capacity = capacity;
    }

    public BoundedConcurrentHashMap() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        ;
        boolean ret = size() > capacity;
        if (logger.isDebugEnabled()) {
            if (ret) {
                logger.debug("removeEldestEntry size: " + size() + ", capacity: " + capacity);
            }
        }
        return ret;
    }

    @Override
    public void clear() {
        lock.lock();
        try {
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object clone() {
        lock.lock();
        try {
            return super.clone();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        lock.lock();
        try {
            return super.equals(o);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int hashCode() {
        lock.lock();
        try {
            return super.hashCode();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        lock.lock();
        try {
            return super.toString();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsValue(Object value) {
        lock.lock();
        try {
            return super.containsValue(value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        lock.lock();
        try {
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean containsKey(Object key) {
        lock.lock();
        try {
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        lock.lock();
        try {
            return super.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    /**
     */
    @Override
    public Set<K> keySet() {
        //throw new UnsupportedOperationException();
        return new HashSet<K>(super.keySet());
    }

    @Override
    public V put(K key, V value) {
        lock.lock();
        try {
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        lock.lock();
        try {
            super.putAll(m);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V remove(Object key) {
        lock.lock();
        try {
            return super.remove(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int size() {
        lock.lock();
        try {
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }
}