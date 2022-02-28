package icu.shishc.applet.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LeaveApplicationMapperTest {
    @Resource
    ApplicationMapper applicationMapper;

    @Test
    public void test() {
        System.out.println(applicationMapper.cancelLeaveApplicationById(1L));
    }
}
