/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-08-24 15:34:14
 * @FilePath: \leetcode\设计模式\静态代理\StaticProxy.java
 * @LastEditTime: 2020-08-24 15:58:42
 */
// 抽象角色 : 一般使用接口或者抽象类来实现
// 真实角色 : 被代理的角色
// 代理角色 : 代理真实角色 ; 代理真实角色后 , 一般会做一些附属的操作 .
// 客户  :  使用代理角色来进行一些操作 .

// 比如租房，抽象角色就是租房，提供一个租房的接口，只是指定规范
// 真实角色比如房东，其需要实现租房接口
// 虚拟角色比如中介，其也需要实现租房接口，并且同时还要代理真实角色（因为中介其实没有房，所以其需要有真实角色做支撑），并且还要做后续操作，收中介费

// 租房接口
interface Rent{
    void rent();
}
// 房东 需要实现租房接口
class Host implements Rent{
    public void rent(){
        System.out.println("房子出租");
    }
}
// 租房中介，因为其也需要提供租房服务，所以也要实现接口
class Proxy implements Rent{
    Host host; //因为中介没房子，所以其是替房东做代理
    public Proxy(Host host){
        this.host = host;
    }
    public void rent(){
        seeHouse(); //中介可以提供其他服务，比如看房
        host.rent(); //中介没房子，所以是用的房东的房子
        fare(); // 中介可以提供其他服务，比如收中介费
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
// 客户类
// 我们在不改变原来的代码的情况下，实现了对原有功能的增强（比如租房多了看房和中介费），这也是AOP中最核心的思想
class StaticProxy{
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Host()); //替房东代理的中介
        // 客户通过中介租房
        proxy.rent();
    }
    
}