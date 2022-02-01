package icu.shishc.applet.controller.param;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UserUpdateParam implements Serializable {
    private Long userId;
    private String wxName;
    private String avatar;
    private String realName;
    private String address;
    private String phone;
    private Integer age;
    private Integer gender;
}
