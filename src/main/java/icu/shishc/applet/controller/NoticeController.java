package icu.shishc.applet.controller;

import icu.shishc.applet.controller.param.NoticeParam;
import icu.shishc.applet.entity.Notice;
import icu.shishc.applet.service.NoticeService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @RequestMapping(value = "/notice", method = RequestMethod.POST)
    public ResultJson addNotice(@RequestBody NoticeParam noticeParam){
        Long noticeId = noticeService.addNotice(noticeParam);
        return ResultJson.ok(noticeId);
    }

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ResultJson getNoticeById(@RequestParam Long noticeId){
        Notice notice = noticeService.getNoticeById(noticeId);
        return ResultJson.ok(notice);
    }

    @RequestMapping(value = "/notice/list", method = RequestMethod.GET)
    public ResultJson getNoticeList(){
        List<Notice> list = noticeService.getNoticeList();
        return ResultJson.ok(list);
    }
}
