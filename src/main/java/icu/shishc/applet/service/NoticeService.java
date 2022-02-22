package icu.shishc.applet.service;

import icu.shishc.applet.controller.param.NoticeParam;
import icu.shishc.applet.entity.Notice;

import java.util.List;

public interface NoticeService {

    // 新增一条通知
    Long addNotice(NoticeParam noticeParam);

    // 通过通知id查看这条通知
    Notice getNoticeById(Long noticeId);

    // 获取通知列表. (按照时间进行倒序，最新的放在最前面)
    List<Notice> getNoticeList();

}
