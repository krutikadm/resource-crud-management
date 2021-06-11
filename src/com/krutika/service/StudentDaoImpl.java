package com.krutika.service;

import java.util.Scanner;

import com.krutika.domain.Student;

/**
 * Business Logic for CRUD operations
 * @author Krutika Mohanty
 *
 */
public class StudentDaoImpl {
	Scanner scanner = new Scanner(System.in);
	Student[] studentList=null;
	/**
	 * Add Student
	 * @param studentList
	 */
	public void addStudents(Student[] studentList){
		if(this.studentList != null){
			Student[] oldStudentList = this.studentList;
			Student[] newStudentList = new Student[oldStudentList.length+studentList.length];
			/**
			 * Copy old array into new array.
			 */
			int newStudentListIndex=0;
			for(Student s:oldStudentList){
				newStudentList[newStudentListIndex] = s;
				newStudentListIndex++;
			}
			/**
			 * Copy input array to new array
			 */
			int studentListIndex=0;
			for(int j=newStudentListIndex;j<newStudentList.length;j++){
				newStudentList[j] = studentList[studentListIndex];
				studentListIndex++;
			}
			this.studentList = newStudentList;
		} else{
			this.studentList = studentList;
		}
		
		
	}
	
	/**
	 * Delete Student
	 * @param studentNo
	 * @return
	 */
	public int deleteStudent(int studentNo){
		int status = 0;
		Student[] newStudentList = new Student[studentList.length-1];
		int index = 0;
		for(Student s: studentList){
			if(s.getSno()==studentNo){
				//don't do anything
				status = 1;
			} else{
				if(index < newStudentList.length){
					newStudentList[index] = s;
					index++;
				}
				
			}
		}
		studentList = newStudentList;
		return status;
	}
	
	/**
	 * View all students
	 * @return
	 */
	public Student[] viewAllStudents(){
		return studentList;
		
	}
	
	/**
	 * View one student details
	 * @param sno
	 * @return
	 */
	public Student veiwStudent(int sno){
		for(Student stu:studentList){
			if(stu!=null)
				
			if(stu.getSno()==sno){
				return stu;
			}
		}
		return null;
		
	}
	
	/**
	 * Update Student
	 * @param stu
	 * @return
	 */
	public int updateStudent(Student stu){
		int status = 0;
		for(Student s: studentList){
			if(s.getSno()==stu.getSno()){
				s.setSname(stu.getSname());
				s.setSadd(stu.getSadd());
				status = 1;
			} 
		}
		return status;
	}
}
