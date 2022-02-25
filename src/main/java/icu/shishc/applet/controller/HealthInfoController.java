package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.HealthInfoSearchParam;
import icu.shishc.applet.controller.param.HealthInfoSubmitParam;
import icu.shishc.applet.entity.HealthInfo;
import icu.shishc.applet.service.HealthInfoService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/api")
public class HealthInfoController {

    @Resource
    HealthInfoService healthInfoService;

    @RequestMapping(value = "/health/u", method = RequestMethod.GET)
    public ResultJson submitOrNot(@RequestBody HealthInfoSearchParam searchParam) {
        Long userId = searchParam.getUserId();
        String today = searchParam.getToday();
        Long infoId = healthInfoService.searchUserTodaySubmitOrNot(userId, today);
        return ResultJson.ok(infoId);
    }

    @RequestMapping(value = "/health", method = RequestMethod.POST)
    public ResultJson addTodayInfo(@RequestBody HealthInfoSubmitParam healthInfoSubmitParam) {
        Long infoId = healthInfoService.addTodayInfo(healthInfoSubmitParam);
        return ResultJson.ok(infoId);
    }

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public ResultJson getInfoById(@RequestParam Long infoId) {
        HealthInfo healthInfo = healthInfoService.getInfoByHealthInfoId(infoId);
        return ResultJson.ok(healthInfo);
    }
}
