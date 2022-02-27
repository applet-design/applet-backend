package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.HealthInfoSubmitParam;
import icu.shishc.applet.entity.HealthInfo;
import icu.shishc.applet.entity.User;

import java.util.List;

public interface HealthInfoService {

    // 用户今天是否已经提交
    Long searchUserTodaySubmitOrNot(Long userId, String today);

    // 添加今天提交
    Long addTodayInfo(HealthInfoSubmitParam param);

    // 查看今日提交
    HealthInfo getInfoByHealthInfoId(Long healthInfoId);

    // 用户查看自己的提交情况
    List<Long> userSubmitLastTenDays(Long userId, List<String> days);

    // 查看某天未提交名单
    List<String> getUnSubmitListSomeday(String date);

    // 今日已提交人数
    Integer getTodaySubmitNum();
}
