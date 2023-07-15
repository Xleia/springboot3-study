package com.example.web.biz;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Author HYL
 * @Date 2023/7/9
 * @Version 1.0
 * @Description 专门处理业务的
 */

@Service
public class UserBizHandler {

    /**
     * 查询指定id的用户
     *
     * @param request
     * @return
     */
    public ServerResponse getUser(ServerRequest request) throws Exception {
        //业务处理
        String s = "abc";
        //构造相应
        return ServerResponse
                .ok()
                .build();
    }
}
