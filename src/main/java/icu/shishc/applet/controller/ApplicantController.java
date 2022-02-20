package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.LeaveApplicationParam;
import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.LeaveApplication;
import icu.shishc.applet.entity.MaterialApplication;
import icu.shishc.applet.service.ApplicationService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

// 申请接口
@RestController
@RequestMapping("/api/apply")
public class ApplicantController {

    @Resource
    ApplicationService applicationService;

    // 申请物资
    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public ResultJson addMaterialApplication(@RequestBody MaterialApplicationParam materialApplicationParam) {
        Long applicationId = applicationService.addMaterialApplication(materialApplicationParam);
        return ResultJson.ok(applicationId);
    }

    // 查看物资申请
    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public ResultJson getMaterialApplicationById(@RequestParam Long materialApplicationId) {
        MaterialApplication materialApplication = applicationService.getMaterialApplicationById(materialApplicationId);
        return ResultJson.ok(materialApplication);
    }

    // 取消物资申请
    @RequestMapping(value = "/material", method = RequestMethod.DELETE)
    public ResultJson cancelMaterialApplication(@RequestParam Long materialApplicationId) {
        Integer result = applicationService.cancelMaterialApplicationById(materialApplicationId);
        return ResultJson.ok(result);
    }

    // 出小区申请
    @RequestMapping(value = "/leave", method = RequestMethod.POST)
    public ResultJson addLeaveApplication(@RequestBody LeaveApplicationParam leaveApplicationParam) {
        Long leaveId = applicationService.addLeaveApplication(leaveApplicationParam);
        return ResultJson.ok(leaveId);
    }

    // 查看出小区申请
    @RequestMapping(value = "/leave", method = RequestMethod.GET)
    public ResultJson getLeaveApplication(@RequestParam Long leaveId) {
        LeaveApplication leaveApplication = applicationService.getLeaveApplication(leaveId);
        return ResultJson.ok(leaveApplication);
    }

    // 取消出小区申请
    @RequestMapping(value = "/leave", method = RequestMethod.DELETE)
    public ResultJson cancelLeaveApplication(@RequestParam Long leaveId) {
        return ResultJson.ok(applicationService.cancelLeaveApplicationById(leaveId));
    }

}
