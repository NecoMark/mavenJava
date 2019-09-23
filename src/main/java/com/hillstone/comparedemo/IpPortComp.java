package com.hillstone.comparedemo;

/**
 * @author: ljyang
 * @date: 2019/9/22 16:44
 * @description
 * hashcode默认是由计算一个对象的内存地址得到，equals默认比较内存地址
 * hashcode主要在HashMap和HashSet中使用，
 * 当比较key值是否相等时优先调用hashcode值比较，
 * hashcode值相等则调用equals方法比较（可能有hash冲突）
 *
 * 重写equals方法必须重写hashcode方法，比如new A(1,2)与new A(1,2)
 * 在使用时认为这两个对象是相等的，如果不重写hashcode方法，
 * 放在HashSet中，会认为是两个不同的对象，有歧义。
 * */

public class IpPortComp {
    private String ip;
    private Integer port;

    public IpPortComp() {
    }

    public IpPortComp(String ip, Integer port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IpPortComp){
            IpPortComp ipPortComp = (IpPortComp)obj;
            if(ipPortComp.ip.equals(this.ip) &&
            ipPortComp.port.equals(this.port)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ip.hashCode() + port.hashCode();
    }
}
