package com.davidcortijo.cliente;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.davidcortijo.configuracion.SpringConfigurationAuto;

import com.davidcortijo.negocio.impl.AutoresDTO;
import com.davidcortijo.negocio.impl.EditorialesDTO;

public class AppMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-embeddedDB.xml");
		//ConfigurableApplicationContext  para poder usar los metodos preDestroy, etc.
		//ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigurationInyec.class);

		AutoresDTO autoresDto = (AutoresDTO) context.getBean("autoresDTO");
		//autoresDto.consultarAutores();
		autoresDto.buscarAutor("Alberto Corbinos");
		autoresDto.insertarAutor("Lamonina Johnson", "Española","Pseudónimo de una conocida escritora de autoayuda española" );
		
		EditorialesDTO editorialesDto = (EditorialesDTO) context.getBean("editorialesDTO");
		editorialesDto.buscarEditorial("221232323-G");
		
		System.out.println("urn:experian:tallyman:image:/www/colma/config/Tallyman/signers/q250242.bmp".matches("urn:experian:tallyman:image:.*"));
		
		//context.close();
	}

}
