package com.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context
    	= new AnnotationConfigApplicationContext(App.class);
        EmpService empService = context.getBean(EmpService.class);
//        System.out.println(empService.getClass().getName());
//        System.out.println(empService.applyNow());
//        empService.setName("some value");
//        empService.setName("Sara");
//        
        empService.setName("Manish");
        
        CustomerServiceImpl cService = context.getBean(CustomerServiceImpl.class);
       // cService.applyForChequeBook(12345);
        
        System.out.println(empService.applyNow());
//        try {
//			empService.applyThen();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			System.out.println("erro");
//		}
//        System.out.println("Balance "+cService.balance(1234));
//        System.out.println(cService.getClass().getName());
    }
}
