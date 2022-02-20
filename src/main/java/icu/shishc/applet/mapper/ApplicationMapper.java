package icu.shishc.applet.mapper;

import icu.shishc.applet.entity.LeaveApplication;
import icu.shishc.applet.entity.MaterialApplication;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ApplicationMapper {

    Long addMaterialApplication(MaterialApplication materialApplication);

    MaterialApplication getMaterialApplicationById(Long materialApplicationId);

    Integer cancelMaterialApplicationById(Long materialApplicationId);

    List<MaterialApplication> getUserMaterialApplication(Long userId);

    Long addLeaveApplication(LeaveApplication leaveApplication);

    LeaveApplication getLeaveApplicationById(Long leaveApplicationId);

    Integer cancelLeaveApplicationById(Long leaveApplicationId);

    List<LeaveApplication> getUserLeaveApplication(Long userId);



}
