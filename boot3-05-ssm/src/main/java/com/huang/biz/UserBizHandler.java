package com.huang.biz;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.function.ServerResponse;

/**
 * @Author HYL
 * @Date 2023/7/9
 * @Version 1.0
 * @Description
 */

@Service
public class UserBizHandler {

    public ServerResponse getUsers(ServerRequest request) {

        return ServerResponse.ok().build();
    }

}
