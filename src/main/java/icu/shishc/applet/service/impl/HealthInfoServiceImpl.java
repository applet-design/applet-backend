package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.HealthInfoSubmitParam;
import icu.shishc.applet.entity.HealthInfo;
import icu.shishc.applet.entity.User;
import icu.shishc.applet.mapper.HealthInfoMapper;
import icu.shishc.applet.mapper.UserMapper;
import icu.shishc.applet.service.HealthInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HealthInfoServiceImpl implements HealthInfoService {

    @Resource
    HealthInfoMapper healthInfoMapper;
    @Resource
    UserMapper userMapper;

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

    @Override
    public List<Long> userSubmitLastTenDays(Long userId, List<String> days) {
        // 返回填报的id列表，如果是null说明没填
        List<Long> infoIdList = healthInfoMapper.userSubmitLastTenDays(userId, days);
        return infoIdList;
    }

    @Override
    public List<String> getUnSubmitListSomeday(String date) {
        List<Long> userIdList = healthInfoMapper.getSubmitListSomeday(date);
        List<Long> allUserIds = userMapper.getSystemUserIds();
        allUserIds.removeAll(userIdList);
        List<User> userList = userMapper.getUserByList(allUserIds);
        List<String> resultList = new ArrayList<>();
        for (User user : userList) {
            resultList.add(user.getRealName());
        }
        return resultList;
    }

    @Override
    public Integer getTodaySubmitNum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(new Date());
        List<Long> infoList = healthInfoMapper.getSubmitListSomeday(today);
        return infoList.size();
    }
}
