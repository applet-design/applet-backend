package icu.shishc.applet.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class LoginDTO implements Serializable {
    String token;
    Long userId;
}
