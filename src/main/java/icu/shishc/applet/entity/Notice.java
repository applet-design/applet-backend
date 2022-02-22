package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Notice {
    private Long noticeId;
    private Long sponsorId;
    private Date createTime;
    private String noticeTitle;
    private String noticeContent;
}
