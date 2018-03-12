package configuration.swagger;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnClass(Docket.class)
@ConditionalOnProperty(prefix = "swagger.api", name = "auto", havingValue = "true")
public class SwaggerApiAutoConfiguration {

  @Configuration
  @EnableSwagger2
  public static class SwaggerApiConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
          .paths(PathSelectors.any())
          .build();
    }
  }
}
