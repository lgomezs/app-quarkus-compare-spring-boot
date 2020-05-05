package pe.lgomezs.swagger;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="transactions", description="transaction operations."),
                @Tag(name="querys", description="Operations querys")
        },
        info = @Info(
                title="Quarkus app",
                version = "1.0.0",
                contact = @Contact(
                        name = "Miguel Gomez",
                        url = "https://github.com/lgomezs",
                        email = "email@example.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class SwaggerDefinition extends Application {
}
