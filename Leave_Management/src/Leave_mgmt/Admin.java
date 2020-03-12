package Leave_mgmt;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	Scanner scc = new Scanner(System.in);
	int total = 0;

	// it adds Reporting Manager
	protected void AddRA(ArrayList<Reporting_Authority> rmdetails, int total) {
		String scanname, scanpassword;

		for (int i = 0; i < total; i++) {
			System.out.println("\t\t\tRA");
			System.out.println("Enter name:");
			scanname = scc.next();
			boolean v = validatera(scanname, rmdetails);
			if (v != true) {
				System.out.println("Enter Password:");
				scanpassword = scc.next();

				rmdetails.add(new Reporting_Authority(scanname, scanpassword));
				System.out.println("RA Created \n");

			} else {
				break;
			}
		}
	}

	// it checks whether the new entered Reporting Manager exists or not
	private boolean validatera(String scanname, ArrayList<Reporting_Authority> rmdetails) {
		for (Reporting_Authority getd : rmdetails) {

			if (scanname.equalsIgnoreCase(getd.GetnameRA()))

			{
				System.out.println("Employee already exists please Enter again\n");
				return true;
			}
		}
		return false;
	}

	// it adds regular employee
	public void AddRE(ArrayList<Employee> redetails, ArrayList<Reporting_Authority> rmdetails, int total) {
		String scanname, scanpassword;

		for (int i = 0; i < total; i++) {
			System.out.println("\t\t\tRE");
			System.out.println("Enter name:");
			scanname = scc.next();
			System.out.println("Enter Password:");
			scanpassword = scc.next();
			boolean v = validatere(scanname, scanpassword, redetails);

			if (v == true) {
				break;
			} else {

				int leave = 10;
				int used = 0;
				int req = 0;
				System.out.println("\t\t\tRA LIST \n");	

				for (Reporting_Authority getd : rmdetails) {
					if (getd.GetnameRA() != null) {
						System.out.println("Name is  " + getd.GetnameRA());
					}
				}
				System.out.println("\n\nAssign RA");
				String ment;
				String mentor = scc.next();

				for (Reporting_Authority getd : rmdetails) {

					if (mentor.equalsIgnoreCase(getd.GetnameRA())) {

						ment = getd.GetnameRA();
						redetails.add(new Employee(scanname, scanpassword, leave, used, req, ment));
						System.out.println("RE Created \n");

					}
				}

			}
		}
	}

	// it checks whether the new entered employee exists or not
	private boolean validatere(String scanname, String scanpassword, ArrayList<Employee> redetails) {
		for (Employee getd : redetails) {

			if (scanname.equalsIgnoreCase(getd.GetnameRE()) && scanpassword.equalsIgnoreCase(getd.GetpassRE())) {
				System.out.println("Employee already exists please Enter again with different id or password\n");
				return true;
			}
		}
		return false;
	}

	// This function prints list of Reporting Authority with password
	public void viewra(ArrayList<Reporting_Authority> rmdetails) {

		System.out.println("\t\t\tRA LIST WITH PASSWORD\n");

		for (Reporting_Authority getd : rmdetails) {
			System.out.println("Name is  " + getd.GetnameRA() + "\t\tPassword is  " + getd.GetpassRA());

		}
	}

	// This function prints list of Regular Employee with password
	protected void viewre(ArrayList<Employee> redetails) {

		System.out.println("\t\t\tRE LIST WITH PASSWORD\n");

		for (Employee getd : redetails) {
			System.out.println("Name is  " + getd.GetnameRE() + "\t\tPassword is  " + getd.GetpassRE() + "\t\tMentor: "
					+ getd.GETmentor());

		}

	}

}