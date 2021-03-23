package com.wing.proxy03;

/**
 * @author memory125
 */
public class Tenant {
    public static void main(String[] args) {
        // 真实角色
        LandLord landLord = new LandLord();
        
        // 代理角色
        ProxyInvocationHanlder proxyInvocationHanlder = new ProxyInvocationHanlder();

        // 通过调用程序处理角色来处理要调用的接口对象
        proxyInvocationHanlder.setRent(landLord);

        Rent proxy = (Rent) proxyInvocationHanlder.getProxy();

        proxy.rentHouse();

    }
}
