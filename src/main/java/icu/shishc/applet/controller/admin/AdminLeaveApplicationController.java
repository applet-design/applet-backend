package icu.shishc.applet.controller.admin;

import icu.shishc.applet.controller.param.LeaveRefuseParam;
import icu.shishc.applet.entity.LeaveApplication;
import icu.shishc.applet.service.ApplicationService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminLeaveApplicationController {

    @Resource
    ApplicationService applicationService;

    // 查看所有申请
    @RequestMapping(value = "/leave/all", method = RequestMethod.GET)
    public ResultJson getAllLeaveApplication() {
        List<LeaveApplication> list = applicationService.getAllLeaveApplication();
        return ResultJson.ok(list);
    }

    // 查看所有待审批
    @RequestMapping(value = "/leave/all/pend", method = RequestMethod.GET)
    public ResultJson getPendingLeaveApplication() {
        List<LeaveApplication> list = applicationService.getPendingLeaveApplication();
        return ResultJson.ok(list);
    }

    // 通过某个申请
    @RequestMapping(value = "/leave/ado", method = RequestMethod.PUT)
    public ResultJson adoptLeaveApplication(@RequestParam Long applicationId) {
        return ResultJson.ok(applicationService.adoptLeaveApplication(applicationId));
    }

    // 拒绝某个申请
    @RequestMapping(value = "/leave/ref", method = RequestMethod.PUT)
    public ResultJson refuseLeaveApplication(@RequestBody LeaveRefuseParam leaveRefuseParam) {
        Long applicationId = leaveRefuseParam.getApplicationId();
        String refuseReason = leaveRefuseParam.getRefuseReason();
        return ResultJson.ok(applicationService.refuseLeaveApplication(applicationId, refuseReason));
    }
}
