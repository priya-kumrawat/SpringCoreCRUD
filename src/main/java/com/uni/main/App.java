package com.uni.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uni.dao.StudentDao;
import com.uni.daoImpl.StudentDaoImpl;
import com.uni.entity.Student;

public class App {
	public static void main(String[] args) {
		System.out.println("\n----------Spring jdbc Application started-----------");
		StudentCRUD();
	}
	
	public static void StudentCRUD(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);
		
		Scanner sc = new Scanner(System.in);
		
        System.out.println("\n\t\tStudent Operations ");
        System.out.println("\t *********************************");
        System.out.println("\t 1.Create");
        System.out.println("\t 2.Update");
        System.out.println("\t 3.Delete by Id");
        System.out.println("\t 4.Exit");
        System.out.println("\n\n-----------------------------------------------------\n");
        System.out.print("\t\t Enter Choice :");
        
        int userChoice = sc.nextInt();
        sc.nextLine();
       
        if(userChoice > 0 ){
        	
        	do {
        		switch(userChoice){
        		
        		case 1:studentDao.insert();
        		break;
        		
        		case 2:studentDao.update();
        		break;
        		
        		case 3:studentDao.delete();
        		break;
        		
        		case 4:System.out.println();
        		       System.out.println("\t\t********** Thank You..!! Visit Again **********");
        			   System.exit(0);
        		break;
        		
        		default:
        			throw new IllegalArgumentException("Unexpected value : " + userChoice);
        		
        		}
        		
        	}
        	while(userChoice != 4);
        	
        }else {
        	System.out.println("Your Choice must be greater than zero or positive number.");
        	
        }
		
	}	
}

//ctrl shift + f for formating
//ctrl shift + t for opentype