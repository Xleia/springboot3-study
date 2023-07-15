package com.huang;

import com.huang.service.Service;

import java.util.ServiceLoader;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        // 使用ServiceLoader加载Service接口的实现类
        ServiceLoader<Service> serviceLoader = ServiceLoader.load(Service.class);

        // 遍历并调用每个实现类的方法
        for (Service service:serviceLoader){
            service.execute();
        }
    }
}
