// Assignment #: 5
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35 - 5:50
//  Description: creating a child class of the class employee to store the records of the full time employee

import java.text.DecimalFormat;
public class FullTimeEmployee extends Employee
{
    protected double salary;
    protected double bonus;

    //using decimal and money format
    protected DecimalFormat money = new DecimalFormat("$##,##0.00");
    
    //constructor
    public FullTimeEmployee (String firstname, String lastname, String id, double salary, double bonus)
    {
    super(firstname, lastname, id);
    this.salary = salary;
    this.bonus=bonus;
    }

    //function computePayAmount
    public void computePayAmount()
    {
        payAmount = salary + bonus;
    }

    //creating toString function
    public String toString()
    {
        String line;
        line = "\nFull Time Employee:"+super.toString()+ 
        "Salary:\t\t\t"+money.format(salary)+"\n"+ 
        "Bonus:\t\t\t"+money.format(bonus)+"\n\n";
        return line;
    }
}