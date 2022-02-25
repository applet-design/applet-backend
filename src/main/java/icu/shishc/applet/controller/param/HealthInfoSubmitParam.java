package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class HealthInfoSubmitParam implements Serializable {
    private Long personId;
    private String submitDate;
    private String realName;
    private String address;
    private Float temperature;
    private Integer symptom;
    private String location;
    // 上次核酸时间.
    private String lastTime;
}
