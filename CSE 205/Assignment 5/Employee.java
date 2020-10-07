// Assignment #: 5
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35 - 5:50
//  Description: creating class employee to store the records of the employee

import java.text.DecimalFormat;     

public abstract class Employee{
    protected String firstName;
    protected String lastName;
    protected String employeeId;
    protected double payAmount;

    //using decimal and money format
    protected DecimalFormat money = new DecimalFormat("$##,##0.00");

    //constructor
    public Employee(String firstname, String lastname, String id)
    {
        firstName = firstname;
        lastName = lastname;
        employeeId = id;
        payAmount = 0.0;
    }

    //Accessor
    public String getEmployeeId()
    {
        return employeeId;
    }

    //since payamount for part time is different from full time so declaring it abstract
    public abstract void computePayAmount();

    //creating toString function
    public String toString()
    {
        String line;
        line = "\nFirst name:\t\t"+firstName+"\n"+ 
        "Last name:\t\t"+lastName+"\n"+
        "Employee ID:\t\t"+employeeId+"\n"+ 
        "Pay Amount:\t\t"+money.format(payAmount)+"\n";
        
        return line;
    }
}