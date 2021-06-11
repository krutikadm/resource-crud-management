package com.krutika;

import java.util.Scanner;

import com.krutika.domain.Student;
import com.krutika.service.StudentDaoImpl;

/**
 * Submenu for students
 * @author Krutika Mohanty
 *
 */
public class SubMenu {
	Scanner scanner = new Scanner(System.in);
	StudentDaoImpl daoImpl = new StudentDaoImpl();

	public void stuMenu() {
		boolean exitFlag = false;
		do {
			System.out.println("----------------------");
			System.out.println("    1:AddStudent    ");
			System.out.println("    2:viewAllStudent    ");
			System.out.println("    3:viewStudent    ");
			System.out.println("    4:deleteStudent    ");
			System.out.println("    5:updateStudent    ");
			System.out.println("    6:Exit    ");
			System.out.println("----------------------");

			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			Student stu1 = null;
			int status = 0;
			switch (choice) {
			
			case 1:
				System.out.println("How many students are Joining:");
				int size= scanner.nextInt();
				Student[] studentList=new Student[size];
				for(int i=0;i<studentList.length;i++){
					System.out.println("Enter Student no: ");
					int sno= scanner.nextInt();
					System.out.println("Enter Student name: ");
					String sname= scanner.next();
					System.out.println("Enter Student address: ");
					String sadd= scanner.next();
					System.out.println();
					Student sb =new Student(sname,sno,sadd);
					studentList[i] = sb;
				}
				daoImpl.addStudents(studentList);

				break;
			case 2:
				Student[] veiwStudents = daoImpl.viewAllStudents();
				if (veiwStudents != null) {
					for (Student stu : veiwStudents) {
						System.out.println(stu);
					}
				} else {
					System.out.println("Resource not found");
				}
				System.out.println("Press any key to continue.");
				String v = scanner.next();
				break;
			case 3:
				System.out.println("Enter Student Number:");
				stu1 = daoImpl.veiwStudent(scanner.nextInt());
				if (stu1 != null) {
					System.out.println(stu1);
				} else {
					System.out.println("Student Record not found");
				}

				break;
			
			case 4:
				System.out.println("Enter Student Number:");
				status = daoImpl.deleteStudent(scanner.nextInt());
				if(status==1)
					System.out.println("Deleted student.");
				else
					System.out.println("Could not find the student");
				break;
			case 5:
				System.out.println("Enter Student no: ");
				int sno= scanner.nextInt();
				System.out.println("Enter Student name: ");
				String sname= scanner.next();
				System.out.println("Enter Student address: ");
				String sadd= scanner.next();
				System.out.println();
				Student sb =new Student(sname,sno,sadd);

				status = daoImpl.updateStudent(sb);
				if(status==1)
					System.out.println("Updated student.");
				else
					System.out.println("Could not find the student");
				break;	
			case 6:
				exitFlag = true;
				break;
			}
		} while (!exitFlag);

	}
}
