package ren.yuda.swagger2.spring.boot.autoconfigure;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yudaren
 */
@Data
public class ApiInfoProperties implements Serializable {
    private static final long serialVersionUID = 8471755917762607584L;

    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String contactName;
    private String contactUrl;
    private String contactEmail;
    private String license;
    private String licenseUrl;
    private String version;
}
