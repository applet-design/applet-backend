package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.HealthInfoSubmitParam;
import icu.shishc.applet.entity.HealthInfo;

public interface HealthInfoService {

    Long searchUserTodaySubmitOrNot(Long userId, String today);

    Long addTodayInfo(HealthInfoSubmitParam param);

    HealthInfo getInfoByHealthInfoId(Long healthInfoId);
}
