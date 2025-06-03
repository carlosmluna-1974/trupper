package mx.com.trupper.prueba.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import mx.com.trupper.prueba.constants.Constants;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                .title(Constants.SWAGGER_TITLE)
                .version(Constants.SWAGGER_VERSION)
                .description(Constants.SWAGGER_DESCRIPTION));
    }

}
