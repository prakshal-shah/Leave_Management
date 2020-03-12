package Leave_mgmt;

import java.util.Scanner;

public class Employee {

	String rename, repass, mentor;
	int releave, usedleave, requestl;
	Scanner scs = new Scanner(System.in);

	public Employee(String scanname, String scanpassword, int leave, int usedl, int requestedleave, String ment) {
		this.rename = scanname;
		this.repass = scanpassword;
		this.releave = leave;
		this.usedleave = usedl;
		this.requestl = requestedleave;
		this.mentor = ment;

	}

	public Employee() {
	}

	// Displays available leaves
	public void viewleave() {

		System.out.println("Your free leaves are:" + GetleaveRE());
	}

	// method for requesting leave
	public void reqleave(int request) {

		// it checks if requested no. of leaves are available or not
		if (request > GetleaveRE()) {
			System.out.println("You don't have sufficient free leaves\n");
		} else {
			System.out.println("Requested for " + request + "days");
			setreq(request);

		}

	}

	// set the value of total leaves of regular employee
	protected void setreq(int request) {
		this.requestl = request;
	}

	// returns name of regular employee
	protected String GetnameRE() {
		return this.rename;
	}

	// returns password of regular employee
	protected String GetpassRE() {
		return this.repass;
	}

	// returns remaining leaves of regular employee
	protected int GetleaveRE() {
		return this.releave;
	}

	// returns used leaves of regular employee
	protected int GetusedleaveRE() {
		return this.usedleave;
	}

	// setting the value of used leaves of regular employee
	protected void setusedleaveRE(int used) {
		this.usedleave = used;
	}

	// returns no. of requesting leave
	protected int GETrequestedleaveRE() {
		return this.requestl;
	}

	// updating the value of total leaves of regular employee
	protected void updateleave(int update) {
		this.releave = update;
	}

	// returns the mentor name of regular employee
	protected String GETmentor() {
		return this.mentor;
	}

}
