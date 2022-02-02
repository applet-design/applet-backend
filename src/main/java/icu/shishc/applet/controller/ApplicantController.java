package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.MaterialApplicationParam;
import icu.shishc.applet.service.ApplicationService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/apply")
public class ApplicantController {

    @Resource
    ApplicationService applicationService;

    @RequestMapping(value = "/material", method = RequestMethod.POST)
    public ResultJson addMaterialApplication(@RequestBody MaterialApplicationParam materialApplicationParam) {
        Long applicationId = applicationService.addMaterialApplication(materialApplicationParam);
        return ResultJson.ok(applicationId);
    }

}
