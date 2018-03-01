package br.com.campaigns.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.campaigns.api.CampaignApplication;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = CampaignApplication.class)
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "br.com.campaigns.api.controller";

	@Bean
	public Docket swaggerInit() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).useDefaultResponseMessages(Boolean.FALSE);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Campanha", "API RESTful de Campanhas", null, null,
				new Contact("Leandro Souza", null, "lramosouza@outlook.com"), null, null);
	}

}
