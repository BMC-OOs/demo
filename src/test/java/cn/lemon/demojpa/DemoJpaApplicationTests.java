package cn.lemon.demojpa;

import cn.lemon.DemoJpaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = DemoJpaApplication.class)
class DemoJpaApplicationTests {


    @Test
    @Transactional
    void  contextLoads() {


    }

}
