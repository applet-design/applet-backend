package icu.shishc.applet.controller.admin;

import icu.shishc.applet.controller.param.NoticeParam;
import icu.shishc.applet.service.NoticeService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/admin")
public class AdminNoticeController {

    @Resource
    NoticeService noticeService;

    //发布一条通知
    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public ResultJson addNotice(@RequestBody NoticeParam noticeParam){
        Long noticeId = noticeService.addNotice(noticeParam);
        return ResultJson.ok(noticeId);
    }
}
