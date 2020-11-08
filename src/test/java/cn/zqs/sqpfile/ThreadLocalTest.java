package cn.zqs.sqpfile;

import sun.misc.Unsafe;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {
    static  Unsafe unsafe=Unsafe.getUnsafe();

    public static void main(String[] args) {
        long address = unsafe.getAddress(111);
        boolean set = unsafe.compareAndSwapInt("set", 111, 23, 12);
        System.out.println();
    }
}
