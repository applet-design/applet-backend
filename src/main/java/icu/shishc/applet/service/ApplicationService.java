package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.LeaveApplicationParam;
import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.controller.param.admin.AdoptMaterialApplicationParam;
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

    // 查看所有待审批的物资申请
    List<MaterialApplication> getPendingMaterialApplication();

    // 通过某个物资申请
    Integer adoptMaterialApplication(AdoptMaterialApplicationParam param);

    // 拒绝某个物资申请
    Integer refuseMaterialApplication(Long materialApplicationId, String refuseReason);

    // 出小区申请
    Long addLeaveApplication(LeaveApplicationParam leaveApplicationParam);

    // 查看出小区申请
    LeaveApplication getLeaveApplication(Long leaveId);

    // 取消出小区申请
    Integer cancelLeaveApplicationById(Long leaveId);

    // 查看某个用户的所有出小区申请
    List<LeaveApplication> getUserLeaveApplication(Long userId);

    // 查看所有未取消的出小区申请
    List<LeaveApplication> getAllLeaveApplication();

    // 查看所有待审批申请
    List<LeaveApplication> getPendingLeaveApplication();

    // 通过某个申请
    Integer adoptLeaveApplication(Long applicationId);

    // 拒绝某个申请
    Integer refuseLeaveApplication(Long applicationId, String refuseReason);

}
