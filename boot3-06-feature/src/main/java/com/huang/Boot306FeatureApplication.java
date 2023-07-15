package com.huang;

import com.huang.bean.Cat;
import com.huang.bean.Dog;
import com.huang.bean.Pig;
import com.huang.robot.RobotAutoConfiguration;
import com.huang.robot.annotation.EnableRobot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;


/**
 * 1、标识环境
 * 1）区分环境：dev（开发）、test（测试）、prod（生产）
 * 2）指定组件在哪个环境有效。如果不区分环境那就是在默认环境：default
 * 3）默认只有激活指定的环境，这些组件才会生效
 * 2、激活环境
 * 方式：1）通过配置文件激活
 * 2）命令行激活：java -jar xxx.jar --spring.profiles.active=xxx
 */
@EnableRobot
@SpringBootApplication
@Slf4j
public class Boot306FeatureApplication {

    public static void main(String[] args) {
        // 1、SpringApplication：Boot应用的核心API入口
//        SpringApplication.run(Boot306FeatureApplication.class, args);

        // 1.自定义SpringApplication的底层设置
//        SpringApplication springApplication = new SpringApplication(Boot306FeatureApplication.class);
//
//        // 调整SpringApplication的参数
////        springApplication.setDefaultProperties();
//        // 这个程序化配置优先级低于配置文件配置
//        springApplication.setBannerMode(Banner.Mode.CONSOLE);
//
//        // 2.SpringApplication 运行
//        springApplication.run(args);

        // 2、Build方式构建SpringApplication：通过FluentAPI进行设置
        ConfigurableApplicationContext context = new SpringApplicationBuilder()
                .main(Boot306FeatureApplication.class)
                .sources(Boot306FeatureApplication.class)
                .bannerMode(Banner.Mode.CONSOLE)
//                .listeners(null)
//                .environment(null)
                .run(args);

        try {
            Cat cat = context.getBean(Cat.class);
            log.info("cat:{}", cat);
        } catch (Exception e) {

        }
        try {
            Dog dog = context.getBean(Dog.class);
            log.info("dog:{}", dog);
        } catch (Exception e) {

        }
        try {
            Pig pig = context.getBean(Pig.class);
            log.info("pig:{}", pig);
        } catch (Exception e) {

        }

    }
}
