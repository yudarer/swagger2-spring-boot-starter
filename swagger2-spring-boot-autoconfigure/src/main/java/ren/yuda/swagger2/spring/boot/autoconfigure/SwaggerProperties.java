package ren.yuda.swagger2.spring.boot.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for Swagger2.
 *
 * @Author: yudaren
 */
@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER_PREFIX)
@Data
public class SwaggerProperties {
    private static final long serialVersionUID = 1L;

    public static final String SWAGGER_PREFIX = "swagger";
    /**
     * Whether to enable Swagger2
     */
    private Boolean enable;
    /**
     * Api information of Swagger2
     */
    private ApiInfoProperties apiInfo;

    /**
     * groupName
     */
    private String groupName;
    /**
     * basePackage
     */
    private String basePackage;


}
