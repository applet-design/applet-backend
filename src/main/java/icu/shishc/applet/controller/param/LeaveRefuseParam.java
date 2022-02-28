package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class LeaveRefuseParam implements Serializable {
    private Long applicationId;
    private String refuseReason;
}
