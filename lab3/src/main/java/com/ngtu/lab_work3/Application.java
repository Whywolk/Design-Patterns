package com.ngtu.lab_work3;

import java.util.List;

import com.ngtu.lab_work3.printers.*;
import com.ngtu.lab_work3.builder.*;
import com.ngtu.lab_work3.component.*;
import com.ngtu.lab_work3.database.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Laboratory work №3 of the course NNTU IRIT IVT Software Design Patterns on Java
 * Variant number 2
 *
 * Task: https://github.com/AlexShirshov/Design-Patterns-Java
 *
 * @author Yurchyk Mikhail	19-IVT-2 (github: https://github.com/w0rest		 )
 * @author Shirshov Alexey	19-IVT-2 (github: https://github.com/AlexShirshov)
 */

@Component("application")
@Scope("singleton")
public class Application {
	@Autowired
	ComputerBuilder computerbuilder;
	
	public static void main(String[] args) {
		// Getting context from the XML file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Creating bean for working with an application
		Application app = context.getBean("application", Application.class);

		// Creating 'printer'
		Printer consolePrinter = context.getBean("printer", Printer.class);

		// Creating bean for working with a DataBase (SQLite)
		Handler handler = context.getBean("handler", Handler.class);
		
		// Getting CPU & GPU & MB
		List<CPU> cpuList = handler.getCPU();
		List<GPU> gpuList = handler.getGPU();
		List<Motherboard> mbList = handler.getMB();

		// Building the computer & Printing completed builds
		consolePrinter.Print(app.computerbuilder.Run(cpuList, gpuList, mbList));
		
		// Closing our context
		context.close();
	}
}
