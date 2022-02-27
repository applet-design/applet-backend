package icu.shishc.applet.controller.admin;

import icu.shishc.applet.entity.Report;
import icu.shishc.applet.service.ReportService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminReportController {

    @Resource
    ReportService reportService;

    @RequestMapping(value = "/repost/list", method = RequestMethod.GET)
    public ResultJson getReportList() {
        List<Report> reportList = reportService.getReportList();
        return ResultJson.ok(reportList);
    }

}
