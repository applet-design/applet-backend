package icu.shishc.applet.controller;

import icu.shishc.applet.entity.Material;
import icu.shishc.applet.service.MaterialStatisticsService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

// 物资接口
@RestController
@RequestMapping(value = "/api")
public class MaterialController {

    @Resource
    MaterialStatisticsService materialStatisticsService;

    // 查看当前可申请的物资
    @RequestMapping(value = "/material", method = RequestMethod.GET)
    public ResultJson getMaterialList() {
        List<Material> list = materialStatisticsService.getAllMaterial();
        return ResultJson.ok(list);
    }

}
