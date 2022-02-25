package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.HealthInfoSubmitParam;
import icu.shishc.applet.entity.HealthInfo;
import icu.shishc.applet.mapper.HealthInfoMapper;
import icu.shishc.applet.service.HealthInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class HealthInfoServiceImpl implements HealthInfoService {

    @Resource
    HealthInfoMapper healthInfoMapper;

    @Override
    public Long searchUserTodaySubmitOrNot(Long userId, String today) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(new Date());
        if (!today.equals(str)) {
            return null;
        }
        Long infoId = healthInfoMapper.searchUserTodaySubmit(userId, today);
        return infoId;
    }

    @Override
    public Long addTodayInfo(HealthInfoSubmitParam param) {
        HealthInfo info = new HealthInfo();
        info.setAddress(param.getAddress());
        info.setLastTime(param.getLastTime());
        info.setLocation(param.getLocation());
        info.setPersonId(param.getPersonId());
        info.setRealName(param.getRealName());
        info.setSymptom(param.getSymptom());
        info.setTemperature(param.getTemperature());
        info.setSubmitDate(param.getSubmitDate());
        return healthInfoMapper.addTodayInfo(info);
    }

    @Override
    public HealthInfo getInfoByHealthInfoId(Long healthInfoId) {
        return healthInfoMapper.getInfoByHealthInfoId(healthInfoId);
    }
}
