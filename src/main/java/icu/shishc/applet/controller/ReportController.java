package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.ReportParam;
import icu.shishc.applet.service.ReportService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class ReportController {

    @Resource
    ReportService reportService;

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public ResultJson addReport(@RequestBody ReportParam reportParam) {
        Long reportId = reportService.addReport(reportParam);
        return ResultJson.ok(reportId);
    }

}
