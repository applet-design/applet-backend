package icu.shishc.applet.controller.param.admin;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdoptMaterialApplicationParam implements Serializable {
    private Long materialApplicationId;
    private Float price;
}
