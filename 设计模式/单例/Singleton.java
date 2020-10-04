/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-10-04 10:33:16
 * @FilePath: \leetcode\设计模式\单例\Singleton.java
 * @LastEditTime: 2020-10-04 10:53:09
 */
// 懒汉 延迟加载 线程不安全
public class Singleton{
    private static Singleton instance;
    private Singleton(){};
    public static Singleton getInstance(){
        if(instance==null){
            // 线程2停在这里，然后线程1又判断仍然是null 之后new Sing会执行两次
            instance = new Singleton();
        }
        return instance;
    }
}
// 懒汉 线程安全在getInstance上面加入sychronized，效率会低
class Singleton1{
    private static Singleton1 instance;
    private Singleton1(){};
    public static synchronized Singleton1 getInstance(){
        if(instance==null){
            instance = new Singleton1();
        }
        return instance;
    }
}
// 饿汉模式 非延迟加载，在开始就加载（浪费内存），但不用加锁
class Singleton2{
    private static Singleton2 instance = new Singleton2();
    private Singleton2(){};
    public static Singleton2 getInstance(){
        return instance;
    }
}

// 双重校验锁
class Singleton3{
    private volatile static Singleton3 instance;
    private Singleton3(){};
    public static Singleton3 getInstance(){ 
        if(instance==null){
            synchronized(Singleton3.class){ // 这样只有初始的时候instance为null才会加锁，避免每次加锁造成开销
                if(instance==null){
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}

