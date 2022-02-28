package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.LeaveApplicationParam;
import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.LeaveApplication;
import icu.shishc.applet.entity.MaterialApplication;

import java.util.List;

public interface ApplicationService {

    // 添加一条物资申请
    Long addMaterialApplication(MaterialApplicationParam materialApplicationParam);

    // 通过申请id获取申请单
    MaterialApplication getMaterialApplicationById(Long materialApplicationId);

    // 取消物资申请
    Integer cancelMaterialApplicationById(Long materialApplicationId);

    // 获取某个用户的所有申请
    List<MaterialApplication> getUserMaterialApplication(Long userId);

    // 出小区申请
    Long addLeaveApplication(LeaveApplicationParam leaveApplicationParam);

    LeaveApplication getLeaveApplication(Long leaveId);

    Integer cancelLeaveApplicationById(Long leaveId);

    List<LeaveApplication> getUserLeaveApplication(Long userId);

    // 查看所有未取消的出小区申请
    List<LeaveApplication> getAllLeaveApplication();

    //查看所有待审批申请
    List<LeaveApplication> getPendingLeaveApplication();

    //通过某个申请
    Integer adoptLeaveApplication(Long applicationId);

    //拒绝某个申请
    Integer refuseLeaveApplication(Long applicationId, String refuseReason);

}
