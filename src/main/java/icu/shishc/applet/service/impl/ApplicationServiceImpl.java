package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.LeaveApplicationParam;
import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.LeaveApplication;
import icu.shishc.applet.entity.MaterialApplication;
import icu.shishc.applet.mapper.ApplicationMapper;
import icu.shishc.applet.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Resource
    ApplicationMapper applicationMapper;

    /**
     * 添加一条物资申请
     * @return 物资申请单id
     */
    @Override
    public Long addMaterialApplication(MaterialApplicationParam materialApplicationParam) {
        MaterialApplication materialApplication = new MaterialApplication();
        materialApplication.setApplicantId(materialApplicationParam.getApplicantId());
        materialApplication.setApplicantName(materialApplicationParam.getApplicantName());
        materialApplication.setApplicantReason(materialApplicationParam.getApplicantReason());
        materialApplication.setMaterialName(materialApplicationParam.getMaterialName());
        materialApplication.setMaterialNum(materialApplicationParam.getMaterialNum());
        materialApplication.setIsUrgency(materialApplicationParam.getIsUrgency());
        materialApplication.setLocation(materialApplicationParam.getLocation());
        materialApplication.setApproverId(materialApplicationParam.getApproverId());
        materialApplication.setCreateTime(new Date());
        return applicationMapper.addMaterialApplication(materialApplication);
    }

    /**
     * 查看一条物资申请单
     * @return materialApplication实体
     */
    @Override
    public MaterialApplication getMaterialApplicationById(Long materialApplicationId) {
        return applicationMapper.getMaterialApplicationById(materialApplicationId);
    }

    /**
     * 取消物资申请单
     * @return 1/0
     */
    @Override
    public Integer cancelMaterialApplicationById(Long materialApplicationId) {
        MaterialApplication application = applicationMapper.getMaterialApplicationById(materialApplicationId);
        // 已经取消不能再次取消. 已经拒绝或通过的不能取消
        if (application.getIsCancel() == 1 ||
            application.getResult() != 0) {
            return 0;
        }
        return applicationMapper.cancelMaterialApplicationById(materialApplicationId);
    }

    /**
     * 查看用户物资申请记录
     */
    @Override
    public List<MaterialApplication> getUserMaterialApplication(Long userId) {
        return applicationMapper.getUserMaterialApplication(userId);
    }

    /**
     * 添加一个出小区申请
     * @return 申请单id
     */
    @Override
    public Long addLeaveApplication(LeaveApplicationParam leaveApplicationParam) {
        LeaveApplication leaveApplication = new LeaveApplication();
        leaveApplication.setApplicantId(leaveApplicationParam.getApplicantId());
        leaveApplication.setApplicantName(leaveApplicationParam.getApplicantName());
        leaveApplication.setAddress(leaveApplicationParam.getAddress());
        leaveApplication.setLeaveTime(leaveApplicationParam.getLeaveTime());
        leaveApplication.setBackTime(leaveApplicationParam.getBackTime());
        leaveApplication.setWay(leaveApplicationParam.getWay());
        leaveApplication.setDestination(leaveApplicationParam.getDestination());
        leaveApplication.setReason(leaveApplicationParam.getReason());
        leaveApplication.setApproverId(leaveApplicationParam.getApproverId());
        return applicationMapper.addLeaveApplication(leaveApplication);
    }

    /**
     * 查看出小区申请单
     * @return 申请单实体类
     */
    @Override
    public LeaveApplication getLeaveApplication(Long leaveId) {
        return applicationMapper.getLeaveApplicationById(leaveId);
    }

    /**
     * 取消出小区申请
     * @return 0/1
     */
    @Override
    public Integer cancelLeaveApplicationById(Long leaveId) {
        LeaveApplication application = applicationMapper.getLeaveApplicationById(leaveId);
        if (application.getIsCancel() == 1 ||
            application.getResult() != 0) {
            return 0;
        }
        return applicationMapper.cancelLeaveApplicationById(leaveId);
    }

    /**
     * 查看某个用户的出小区申请
     */
    @Override
    public List<LeaveApplication> getUserLeaveApplication(Long userId) {
        return applicationMapper.getUserLeaveApplication(userId);
    }

    /**
     * 查看所有未取消的出小区申请
     */
    @Override
    public List<LeaveApplication> getAllLeaveApplication() {
        return applicationMapper.getAllLeaveApplication();
    }

    /**
     * 查看所有待审核的出小区申请
     */
    @Override
    public List<LeaveApplication> getPendingLeaveApplication() {
        return applicationMapper.getPendingLeaveApplication();
    }

    /**
     * 通过某个出小区申请
     */
    @Override
    public Integer adoptLeaveApplication(Long applicationId) {
        LeaveApplication application = applicationMapper.getLeaveApplicationById(applicationId);
        if (application.getIsCancel() == 0 && application.getResult() == 0) {
            return applicationMapper.adoptLeaveApplication(applicationId);
        }
        return 0;
    }

    /**
     * 拒绝某个出小区申请
     */
    @Override
    public Integer refuseLeaveApplication(Long applicationId, String refuseReason) {
        LeaveApplication application = applicationMapper.getLeaveApplicationById(applicationId);
        if (application.getIsCancel() == 0 && application.getResult() == 0) {
            return applicationMapper.refuseLeaveApplication(applicationId, refuseReason);
        }
        return 0;
    }

}
