package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.Perms;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermMapper {

    // 通过用户身份获取权限列表.
    List<Perms> getPermsByUserIdentity(Integer userIdentity);

}
