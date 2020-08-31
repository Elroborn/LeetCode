import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-24 15:57:57
 * @FilePath: \leetcode\设计模式\静态代理\DynamicProxy.java
 * @LastEditTime: 2020-08-30 17:09:31
 */
// 动态代理的角色和静态代理的一样 .
// 动态代理的代理类是动态生成的 . 静态代理的代理类是我们提前写好的
// 动态代理分为两类 : 一类是基于接口动态代理 （JDK动态代理）, 一类是基于类的动态代理（cglib）


// 基于接口的动态代理

// 抽象角色和真实角色和静态代理一样
// 租房接口
interface Rent{
    void rent();
    void test();
}
// 房东 需要实现租房接口
class Host implements Rent{
    public void rent(){
        System.out.println("房子出租");
    }
    public void test(){
        System.out.println("test");
    }
}


// 动态代理
class ProxyInvocationHandler implements InvocationHandler{
    private Rent rent;
    public void setRent(Rent rent){
        this.rent = rent;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), rent.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
        seeHouse();
        System.out.println(method);
        Object res = method.invoke(rent, args);
        fare();
        return res;
    }
    //看房
    public void seeHouse(){
        System.out.println("带房客看房");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }

}
class DynamicProxy{
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);

        Rent proxy = (Rent) pih.getProxy();
        proxy.rent();
        proxy.test();// 所有的方法都会被代理
    }
    
}