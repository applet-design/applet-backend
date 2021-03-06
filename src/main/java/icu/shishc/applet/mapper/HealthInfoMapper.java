package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.HealthInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HealthInfoMapper {

    // 今天是否已经填报
    Long searchUserTodaySubmit(Long userId, String today);

    // 上传今日填报
    Long addTodayInfo(HealthInfo info);

    // 查看填报表单
    HealthInfo getInfoByHealthInfoId(Long healthInfoId);

    // 用户查看自己的每日填报情况...
    List<Long> userSubmitLastTenDays(Long userId, List<String> days);

    // 某天已提交名单
    List<Long> getSubmitListSomeday(String date);
}
