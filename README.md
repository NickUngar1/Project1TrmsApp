Nicholas Ungar Project 1: Tuition Reimbursement Management System Application

This application allows employees from my make-believe company to sign in to their accounts and perform a variety of actions.
Employees are able to create tuition reimbursement forms. Upon filling out the required information on the form page, this will add a new form into the database.
Employees are also able to check their pending reimbursement along with the approval status from their supervisors/department heads/ceo. Depending on the level of the employee, some of these statuses will already be filled out.
Employees can also approve/decline tuition forms if there is someone directly under them, they are a department head, or they are a ceo. The application will internally manage whos forms each employee is able to see and approve or deny.
Once a form is approved/denied, the pending reimbursement along with the approval statuses will automatically update so that the employee who created the form can see.

This application requires a connection to an RDS or other cloud-based database system. I have removed the connecton.properties file needed to connect to my database.

Required dependencies for this application include: UTF-8, JUnit, Oracle JDBC, Javax Servlet, Selenium, Cucumber, and Gson.
