package com.huang.robot;

import com.huang.robot.controller.RobotController;
import com.huang.robot.properties.RobotProperties;
import com.huang.robot.service.RobotService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author HYL
 * @Date 2023/7/12
 * @Version 1.0
 * @Description
 */
@EnableConfigurationProperties(RobotProperties.class)
@Import({RobotController.class, /*RobotProperties.class,*/ RobotService.class})
@Configuration
public class RobotAutoConfiguration {
}
