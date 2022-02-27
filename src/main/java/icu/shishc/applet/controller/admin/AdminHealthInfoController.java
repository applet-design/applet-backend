package icu.shishc.applet.controller.admin;

import icu.shishc.applet.controller.dto.admin.NotSubmitYetDTO;
import icu.shishc.applet.service.HealthInfoService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminHealthInfoController {

    @Resource
    HealthInfoService healthInfoService;

    // 今天已经填报的人数
    @RequestMapping(value = "/info/ty/num", method = RequestMethod.GET)
    public ResultJson getTodaySubmitNum() {
        Integer submitNum = healthInfoService.getTodaySubmitNum();
        return ResultJson.ok(submitNum);
    }

    // 某天未填报的名单
    @RequestMapping(value = "/info/tn/num", method = RequestMethod.GET)
    public ResultJson getNotSubmitYet(@RequestParam String someday) {
        List<String> realNameList = healthInfoService.getUnSubmitListSomeday(someday);
        Integer num = realNameList.size();
        NotSubmitYetDTO notSubmitYetDTO = new NotSubmitYetDTO(realNameList, num);
        return ResultJson.ok(notSubmitYetDTO);
    }

}
