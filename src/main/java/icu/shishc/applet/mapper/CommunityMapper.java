package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.Community;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CommunityMapper {

    Long addCommunity(Community community);

}
