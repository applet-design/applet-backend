package icu.shishc.applet.controller;

import icu.shishc.applet.entity.Notice;
import icu.shishc.applet.service.NoticeService;
import icu.shishc.applet.util.ResultJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

// 通知接口
@RestController
@RequestMapping(value = "/api")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    // 查看通知
    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public ResultJson getNoticeById(@RequestParam Long noticeId){
        Notice notice = noticeService.getNoticeById(noticeId);
        return ResultJson.ok(notice);
    }

    // 获取通知列表
    @RequestMapping(value = "/notice/list", method = RequestMethod.GET)
    public ResultJson getNoticeList(){
        List<Notice> list = noticeService.getNoticeList();
        return ResultJson.ok(list);
    }
}
