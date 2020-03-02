# Leave_Management
Leave Management using java console

Admin's ID : Admin
Admin's password : 123

Two types of employees admin can create.
1. Regular Employee(RE)
2. Reporting Authority(RA)

RE can apply for leave and can view leave.

RA can view Employee's report which are under it's network(i.e. RE that works under that RA).
RA can also view report of all RE which are working under him/her.

WORKING:
		First Admin creates RA and after that RE can be created because in this system without RA, RE can't be generated.
		Admin can view name and password of both employees (RA and RE).
		
		RA can view request, grant or reject request and also can view report.
		If RA grants the request then the total levaes of the particular employee deduct otherwise the total leaves remain as it is.
		
		RE can apply for leave and can view leave.
		Here only RE can have same ID but password should be different and for RA every ID should be different.
		

In this system all report generate automatically as the changes occure, so you didn't need to do manual changes.
Working of this project is simple so anyone can easily understand the flow.