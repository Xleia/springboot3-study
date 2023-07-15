package com.huang.mapper;

import com.huang.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author HYL
 * @Date 2023/7/9
 * @Version 1.0
 * @Description
 */
public interface UserMapper {

    User getUserById(@Param("id") Long id);

}
