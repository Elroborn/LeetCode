/*
 * @Descripttion: 
 * @Author: coderwangson
 * @Date: 2020-04-18 09:02:40
 * @FilePath: \leetcode\test.java
 * @LastEditTime: 2020-08-02 11:23:31
 */ 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
class Person implements Cloneable{
    int a;
    public Person(int x){
        a = x;
    }
    @Override
    public Object clone(){
        try{
            return  super.clone();
            }catch(CloneNotSupportedException e){
            return null;
        }
    }
}
public class test{
    public static void pp(int[][] a){

    }

    public static void main(String[] args) {
        // Person p1 = new Person(2);
        // Person p2 = (Person)p1.clone();
        // List<Integer> l1 = new ArrayList<>();
        // List<Integer> l2 = new ArrayList<>();
        // l1.add(1);
        // l2.add(1);
        // System.out.println(l1.hashCode());
        // System.out.println(l2.hashCode());
        // System.out.println(l1==l2);
        // System.out.println(l1.equals(l2));
        // System.out.println(System.identityHashCode(l1));
        // System.out.println(System.identityHashCode(l2));
        // HashSet<List> ss = new HashSet<>();
        // ss.add(l1);
        // ss.add(l2);
        // for (List list : ss) {
        //     System.out.println(list);
        // }
        // List<Integer> l1 = new ArrayList<>();
        // l1.add(1);
        // l1.add(2); 
        // l1.add(2);
        // l1.add(2);
        // l1.add(3);
        // l1.add(4);
        // Iterator<Integer> it = l1.iterator();
        // while(it.hasNext()){
        //     if(it.next()==2){
        //         it.remove();
        //     }
        // }
        // System.out.println(l1);
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int q = in.nextInt();

        // String s = in.nextLine(); //因为int只读到回车前面，所以需要nextLine()
        // System.out.println(s);
        // s = in.nextLine();//
        
        String s = in.next(); //直接会帮忙处理
        System.out.println(s.equals("abc"));
 
    }

}