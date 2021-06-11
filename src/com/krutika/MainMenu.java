package com.krutika;

import java.util.Scanner;

/**
 * Student client dashboard menu.
 * @author Krutika Mohanty
 *
 */
public class MainMenu {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.println("----------------------");
			System.out.println("        1:Student        ");
			System.out.println("        2:Exit        ");
			System.out.println("----------------------");
			
			System.out.println("Enter your Choice: ");
			int choice= scanner.nextInt();
			switch(choice){
			
			case 1:
				SubMenu details = new SubMenu();
				details.stuMenu();
				break;
				
			case 2:
				System.out.println("Thanks for using Application");
				System.exit(0);
			}
		}
		
	}

}
