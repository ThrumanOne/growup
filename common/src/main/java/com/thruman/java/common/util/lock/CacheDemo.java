package com.thruman.java.common.util.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDemo {
    /**
     * 缓存器,这里假设需要存储1000左右个缓存对象，按照默认的负载因子0.75，则容量=750，大概估计每一个节点链表长度为5个
     * 那么数组长度大概为：150,又有雨设置map大小一般为2的指数，则最近的数字为：128
     */
    private Map<String, Object> map = new HashMap<>(128);
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public static void main(String[] args) {

    }
    public Object get(String id){
        Object value = null;
        rwl.readLock().lock(); //3
        try{

           if(map.get(id) == null){
            rwl.readLock().unlock();//2
            rwl.writeLock().lock();  //1
            try{
                if(map.get(id) == null){
                    value = "redis-value";
                }
                rwl.readLock().lock();
            }finally{
                rwl.writeLock().unlock();
            }

        }
        }finally{
            rwl.readLock().unlock(); //最后释放读锁
        }
        return value;
    }
}