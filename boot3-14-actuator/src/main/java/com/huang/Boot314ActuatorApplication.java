package com.huang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 整合Prometheus+Grafana
 * 1、改造springboot应用，产生Prometheus需要的格式化数据
 * 	- 导入：micrometer-registry-prometheus
 */
@SpringBootApplication
public class Boot314ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot314ActuatorApplication.class, args);
	}

}
