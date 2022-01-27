package icu.shishc.applet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private Long userId;
    private String unionId;
    private String wxName;
    private String realName;
    private String address;
    private String phone;
    private int age;
    private int gender;
}
