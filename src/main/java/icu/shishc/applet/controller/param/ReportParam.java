package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReportParam implements Serializable {
    private String name;
    private String idNum;
    private String phone;
    private String location;
    private String address;
    private Integer way;
    // 指的是车次或班次.
    private String tripNum;
    private Long approverId;
}
