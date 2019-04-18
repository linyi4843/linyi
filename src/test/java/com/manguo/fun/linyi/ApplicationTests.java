package com.manguo.fun.linyi;

import com.manguo.fun.linyi.ly.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Test
    public void test() {
    }
}