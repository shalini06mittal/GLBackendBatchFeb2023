
package com.gl.HIbernateMavrnDemo;

import org.hibernate.SessionFactory;

import com.gl.HIbernateMavrnDemo.config.HibernateConfig;

/**
 *1. Create maven project - quickstart
 *		archetype - templates
 *		artifact id - project name
 *		group id - package
 *2. Add hibernate and mysql dependency
 *3. hibernate => needs connection parameters
 *	hibernate.cfg.xml file => src/main/resources
 *	Project => rt click => Build Path => Configure build path
 *	=> Sources tab => Add new folder  => Create nre folder => src/main/resources
 *4. mapping of java class with database table => need a class and add annotations
 *5. add <mapping> tag for your class in hibernate.cfg.xml file
 *6. load the configuration file => hibernateConfig.java
 *
 *
 */
public class App 
{
	private static SessionFactory factory = HibernateConfig.getSessionFactory();
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("config loaded");
        
    }
}
