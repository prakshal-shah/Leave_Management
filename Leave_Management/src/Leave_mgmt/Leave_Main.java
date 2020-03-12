package Leave_mgmt;

import java.util.ArrayList;
import java.util.Scanner;

public class Leave_Main {
	Login l;
	ArrayList<Reporting_Authority> RMdetails = new ArrayList<Reporting_Authority>();
	ArrayList<Employee> REdetails = new ArrayList<Employee>();

	// constructor for initializing objects
	Leave_Main() {
		l = new Login();
	}

	public static void main(String[] args) {
		// new Leave_Main();
		Leave_Main leave = new Leave_Main();
		leave.Display();
	}

	// void Display();
	void Display() {

		Scanner sc = new Scanner(System.in);
		String name, password;
		int a = 0, total = 0;

		System.out.println(
				"Select any one for login procedure\n\n" + "1.Admin \n" + "2.Reporting Authority \n" + "3.Employee");
		try {
			a = sc.nextInt();

			System.out.println("Enter Username or ID");
			name = sc.next();
			System.out.println("Enter Password");
			password = sc.next();
			switch (a) {
			case 1:
				Admin admin = l.checkadmin(name, password); // Login validation for Admin

				if (admin == null) {
					Display();
				}
				while (true) {

					System.out.println("\nPress 1 to ADD Emp." + "\n" + "Press 2 to View Report of RA" + "\n"
							+ "Press 3 to View Report of RE" + "\n" + "Press 4 to LOGOUT");

					a = sc.nextInt();

					switch (a) {

					case 1:
						System.out.println("Press 1 to add Reporting Manager || press 2 to add Regular Employee");

						a = sc.nextInt();

						if (a == 1) { // Creates Reporting Manager

							System.out.println("how many employees you want to create??");
							total = sc.nextInt();
							admin.AddRA(RMdetails, total);
							continue;
						} else if (a == 2) { // Creates Regular Employee

							System.out.println("how many employees you want to create??");
							total = sc.nextInt();
							admin.AddRE(REdetails, RMdetails, total);
							continue;
						} else {

							System.out.println("Enter valid choice");
							continue;
						}

					case 2: // View report of Reporting Authority
						admin.viewra(RMdetails);

						continue;
					case 3: // View report of Regular Employee
						admin.viewre(REdetails);

						continue;
					case 4: // Display is called for logout
						Display();
					default:
						continue;
					}

				}
			case 2:
				// Login validation for Reporting Manager
				Reporting_Authority rlogin = l.MatchRA(name, password, RMdetails);

				if (rlogin != null) {
					System.out.println("Welcome" + name);
				} else {
					Display();
				}

				while (true) {

					int c = 0;
					System.out.println("1.View Report\n2.View Requests\n3.Grant\n4.Logout");
					c = sc.nextInt();
					if (c == 1) { // View his/her Employee's leave report

						rlogin.view(REdetails);
						continue;
					}

					else if (c == 2) { // View request of his/her allocated employee

						rlogin.requests(REdetails);
						continue;
					} else if (c == 3) { // Call the Grant method for Accepting or Rejecting or Pending request

						rlogin.grant(REdetails);
						continue;
					}

					else if (c == 4)
						Display();

				}
			case 3:
				// Login validation for Employee

				Employee e = l.MatchRE(name, password, REdetails);

				if (e != null) {
					System.out.println("Welcome " + name);

					while (true) {
						int b = 0, req = 0;
						System.out.println(
								"1. View  Leaves" + "\n" + "2. Apply for leave application" + "\n" + "3. Logout");
						b = sc.nextInt();
						switch (b) {
						case 1: // case 1: Viewing his/her available leave

							e.viewleave();
							break;

						case 2: // case 2: requesting leave

							System.out.println("Your total leaves are:" + e.GetleaveRE());
							System.out.println("\nHow many leaves do you want");
							req = sc.nextInt();
							e.reqleave(req);
							break;

						case 3: // case 2: Logout

							Display();
							break;

						default:
							break;
						}
					}
				}
			default:
				System.out.println("Enter valid number");
				Display();

			}
		} catch (Exception e) {
			System.out.println("EXCEPTION Occured");
			Display();
		}
		sc.close();

	}
}
