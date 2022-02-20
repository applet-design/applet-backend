package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class LeaveApplicationParam implements Serializable {
    private Long applicantId;
    private String applicantName;
    private String address;
    private Date leaveTime;
    private Date backTime;
    private Integer way;
    private String destination;
    private String Reason;
    private Long approverId;
}
