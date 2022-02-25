package icu.shishc.applet.controller.param;

import lombok.Data;

import java.io.Serializable;

@Data
public class HealthInfoSearchParam implements Serializable {
    private Long userId;
    private String today;
}
