package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.Community;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CommunityMapperTest {

    @Resource
    CommunityMapper communityMapper;

    @Test
    public void test() {
        Community community = new Community(
                null,
                "shishc111",
                "test"
        );
        System.out.println(communityMapper.addCommunity(community));
        System.out.println(community.getCommunityId());
    }

}
