package ren.yuda.swagger2.spring.boot.autoconfigure;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * {@link EnableAutoConfiguration Auto-Configuration} for Swagger2
 *
 * @Author: yudaren
 */
@Configuration
@EnableConfigurationProperties(SwaggerProperties.class)
@ConditionalOnProperty(name = "swagger.enable")
@EnableSwagger2
public class Swagger2AutoConfiguration {

    @Bean
    public Docket docket(SwaggerProperties properties) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(properties.getGroupName())
                .apiInfo(createApiInfo(properties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(properties.getBasePackage()))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo createApiInfo(SwaggerProperties properties) {
        ApiInfoProperties apiInfo = properties.getApiInfo();

        return new ApiInfoBuilder()
                .title(apiInfo.getTitle())
                .description(apiInfo.getDescription())
                .termsOfServiceUrl(apiInfo.getTermsOfServiceUrl())
                .contact(new Contact(apiInfo.getContactName(), apiInfo.getContactUrl(), apiInfo.getContactEmail()))
                .license(apiInfo.getLicense())
                .licenseUrl(apiInfo.getLicenseUrl())
                .version(apiInfo.getVersion())
                .build();
    }
}
