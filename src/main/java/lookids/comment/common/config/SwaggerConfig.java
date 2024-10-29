package lookids.comment.common.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
	info = @io.swagger.v3.oas.annotations.info.Info(
		title = "Liikids Service API",
		version = "v1",
		description = "Liikids API Docs"
	)
)
@SecurityScheme(
	name = "Bearer Auth",
	type = SecuritySchemeType.HTTP,
	bearerFormat = "JWT",
	scheme = "bearer"
)

@Profile("!prod")
@Configuration
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		String[] paths = {"/api/v1/**"};
		return GroupedOpenApi.builder()
			.group("public-api")
			.pathsToMatch(paths)
			.build();
	}

}