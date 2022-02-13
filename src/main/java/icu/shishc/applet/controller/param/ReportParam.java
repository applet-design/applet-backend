package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportParam implements Serializable {
    private String name;
    private String idNum;
    private String phone;
    private String location;
    private Long communityId;
    private String address;
    private Integer way;
    private Long approverId;
}
