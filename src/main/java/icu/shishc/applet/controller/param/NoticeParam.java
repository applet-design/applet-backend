package icu.shishc.applet.controller.param;

import lombok.Data;
import java.io.Serializable;

@Data
public class NoticeParam implements Serializable {
    private Long sponsorId;
    private String title;
    private String content;
}
