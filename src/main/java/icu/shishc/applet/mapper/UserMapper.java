package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    User getUserByUnionId(String unionId);

    int insertUser(User user);
}
