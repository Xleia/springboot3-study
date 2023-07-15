package com.huang;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author HYL
 * @Date 2023/7/7
 * @Version 1.0
 * @Description
 */
public class SpringTest {
    @Test
    public void demoTest() {
        char ch = 'A';
        int num = 0;
        boolean bool = true;
        System.out.print(bool ? ch : 0);
        System.out.print(!bool ? num : ch);
    }
}
