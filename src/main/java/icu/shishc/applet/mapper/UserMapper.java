package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getUserByOpenId(String openId);

    int insertUser(User user);
}
