package Leave_mgmt;

import java.util.ArrayList;

public class Login {

	// Validation of Admin
	public Admin checkadmin(String name, String password) {
		if (name.equalsIgnoreCase("Admin") && password.equals("123")) {

			System.out.println("Welcome  " + name + "\n");
			return new Admin();
		}
		return null;
	}

	// Validation of Reporting Manager
	public Reporting_Authority MatchRA(String name, String password, ArrayList<Reporting_Authority> rmdetails) {
		for (Reporting_Authority getd : rmdetails) {
			if (name.equalsIgnoreCase(getd.GetnameRA()) && password.equals(getd.GetpassRA())) {

				return getd;
			}
		}

		return null;
	}

	// Validation of Regular Employee
	public Employee MatchRE(String name, String password, ArrayList<Employee> redetails) {
		for (Employee getd : redetails) {
			if (name.equalsIgnoreCase(getd.GetnameRE()) && password.equals(getd.GetpassRE())) {

				return getd;
			}
		}
		return null;
	}

}