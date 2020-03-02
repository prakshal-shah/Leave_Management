package Leave_mgmt;

import java.util.ArrayList;
import java.util.Scanner;

public class Reporting_Authority {

	String rmname, rmid;

	Scanner sc = new Scanner(System.in);

	public Reporting_Authority(String scanname, String scanpassword) {

		this.rmname = scanname;
		this.rmid = scanpassword;
	}

	public Reporting_Authority() {
	}

//print all Employee name, available leaves and used leaves
	public void view(ArrayList<Employee> rEdetails) {
		for (Employee getd : rEdetails) {
			if (GetnameRA().equalsIgnoreCase(getd.GETmentor())) {

				System.out.println("Name is  " + getd.GetnameRE() + "\t\tAvailable leaves  " + getd.GetleaveRE()
					+ "\t\tUsed leaves  " + getd.GetusedleaveRE() + "\n");
			}
		}

	}

// print all the requests of employee who are under the logged in Reporting Manager
	public void requests(ArrayList<Employee> rEdetails) {

		for (Employee getd : rEdetails) {

			if (GetnameRA().equalsIgnoreCase(getd.GETmentor())) {
				System.out.println("Name is  " + getd.GetnameRE() + "\t\tRequesting for " + getd.GETrequestedleaveRE()
						+ " Days \n");

			}
		}

	}

	// Confirmation for leave to be given or not
	public void grant(ArrayList<Employee> rEdetails) {

		for (Employee getd : rEdetails) {
			if (getd.GETmentor().equalsIgnoreCase(GetnameRA())) {
				System.out.println(
						"Name is  " + getd.GetnameRE() + "\t\tRequesting for  " + getd.GETrequestedleaveRE() + "\n");
				int a;
				System.out.println("1.Confirm " + "\n" + "2.Reject" + "\n" + "3.Don't change");
				a = sc.nextInt();
				switch (a) {

				// if RM confirms the request
				case 1:
					int leave = getd.GetleaveRE();
					int deduct = getd.GETrequestedleaveRE();
					leave -= deduct;

					getd.updateleave(leave);
					int used = getd.GetusedleaveRE() + getd.GETrequestedleaveRE();

					getd.setusedleaveRE(used);
					getd.setreq(0);
					System.out.println("Leaves granted\n");
					break;

				// if RM rejects the request
				case 2:
					System.out.println("Leaves Rejected\n");
					getd.setreq(0);
					break;
				// if RM selects pending option
				case 3:
					System.out.println("Leaves are as it is\n");
					break;
				default:
					break;
				}
			}
		}
	}

	// returns name of reporting manager
	protected String GetnameRA() {
		return this.rmname;
	}

	// returns password of reporting manager
	protected String GetpassRA() {
		return this.rmid;
	}
}
