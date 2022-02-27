package icu.shishc.applet.controller.dto.admin;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class NotSubmitYetDTO implements Serializable {
    List<String> realNameList;
    Integer unSubmitNum;
}
