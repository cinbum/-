package spring.camp.mall.config;

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

// Swagger : Open Api Secification 프레임워크
// API가 포함한 스펙(Spec)을 관리

// 현재 클래스가 Swagger를 구현한 것임을 나타내는 annotaion
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		final ApiInfo apiInfo= new ApiInfoBuilder()
				.title("명함관리 API")
				.description("<h2>명함관리 시스템의 Open API 문서를 제공</h2>")
				.contact(new Contact("SMART", "https://www.jj.ac.kr", "hgd@jj.ac.kr"))
				.license("JJ License")
				.version("0.8")
				.build();
		
		// ApiInfo 객체형으로 생성한 Swagger 문서 리턴
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo)
				.select()
				.apis(RequestHandlerSelectors.basePackage("spring.camp.com"))
				.paths(PathSelectors.ant("/namecardapi/**"))
				.build();
	}
}
