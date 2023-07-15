package com.huang.robot.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */
@Data
@ConfigurationProperties(prefix = "robot")
/*@Component*/
public class RobotProperties {
    private String name;
    private String age;
}
