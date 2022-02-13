package icu.shishc.applet.service.impl;

import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.entity.MaterialApplication;
import icu.shishc.applet.mapper.ApplicationMapper;
import icu.shishc.applet.service.ApplicationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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
        Long applicationId = applicationMapper.addMaterialApplication(materialApplication);
        if (applicationId == null) {
            return null;
        }
        return applicationId;
    }

}
