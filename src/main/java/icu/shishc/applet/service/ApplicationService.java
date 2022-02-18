package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.MaterialApplicationParam;
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

}
