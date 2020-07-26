package com.github.fascalsj.restapifull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiFullApplicationTests {


    @Test
    void contextLoads() {
        RestApiFullApplication.main(new String[]{
                "--spring.main.web-environment=false",
        });
        Assertions.assertTrue(true);
    }


}
