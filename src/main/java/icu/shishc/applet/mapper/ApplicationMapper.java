package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.LeaveApplication;
import icu.shishc.applet.entity.MaterialApplication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplicationMapper {

    //增加一条物资申请
    Long addMaterialApplication(MaterialApplication materialApplication);

    //通过物资单id查看物资单
    MaterialApplication getMaterialApplicationById(Long materialApplicationId);

    //取消物资申请
    Integer cancelMaterialApplicationById(Long materialApplicationId);

    //查看某个用户的物资申请
    List<MaterialApplication> getUserMaterialApplication(Long userId);

    //增加一条出小区申请
    Long addLeaveApplication(LeaveApplication leaveApplication);

    //通过申请表id查看出小区申请
    LeaveApplication getLeaveApplicationById(Long leaveApplicationId);

    //通过申请表id取消出小区申请
    Integer cancelLeaveApplicationById(Long leaveApplicationId);

    //通过用户id查看出小区申请
    List<LeaveApplication> getUserLeaveApplication(Long userId);

    //查看所有出小区申请
    List<LeaveApplication> getAllLeaveApplication();

    //查看所有待审批申请
    List<LeaveApplication> getPendingLeaveApplication();
//
//    //通过某个申请
//    Integer adoptLeaveApplication(Long applicationId);
//
//    //拒绝某个申请
//    Integer refuseLeaveApplication(Long applicationId, String refuseReason);

}
