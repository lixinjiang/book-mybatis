package cn.lxj.bookmybatis.chapter6.test;

import cn.lxj.bookmybatis.chapter6.Service.HelloService;
import cn.lxj.bookmybatis.chapter6.Service.impl.HelloServiceImpl;
import cn.lxj.bookmybatis.chapter6.Service.proxy.HelloServiceCgLib;
import cn.lxj.bookmybatis.chapter6.Service.proxy.HelloServiceProxy;

/**
 * TestProxy
 * description 测试helloservice的代理
 * create by lxj 2018/4/27
 **/
public class TestProxy {
    public static void main(String[] args) {
        System.out.println("********测试jdk动态代理*************");
        // 实例化代理类
        HelloServiceProxy HelloHandler1 = new HelloServiceProxy();
        // 代理类绑定哪个功能之下
        HelloService proxy1 = (HelloService) HelloHandler1.bind(new HelloServiceImpl());
        proxy1.sayHello("lisi");
        System.out.println("********测试cglib动态代理*************");
        HelloServiceCgLib helloServiceCgLib = new HelloServiceCgLib();
        HelloService target = (HelloService)helloServiceCgLib.getTarget(new HelloServiceImpl());
        target.sayHello("daxiong");
    }
}
