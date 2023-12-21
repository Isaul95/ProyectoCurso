package mx.com.mrjob.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//anotaciones o estereotipos
@Configuration //IDENTIFICAR QUE NUESTRA CLASE ES DE TIPO CONFIGURCIÓN
@EnableWebMvc  //HABILITAR LA PARTE WEB MVC = MODELO VISTA CONTROLADOR
@ComponentScan("mx.com.mrjob") //SIRVE PARA INDICARLE A SPRING QUE SOBRE ESE 
//PAQUETE VA A BUSCAR AQUELLAS CLASES QUE NOSOTROS HAYAMOS
//AFILIADO/INTEGRADO A SPRING CON LAS ANOTACIONES
public class WebConfig {

	  @Bean
	  public InternalResourceViewResolver resolver() {
			InternalResourceViewResolver resol = new InternalResourceViewResolver();
			resol.setPrefix("/WEB-INF/views/");
			resol.setSuffix(".jsp");
			return resol;
	  }  
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("classpath:/resources/");	
	  }
	
}