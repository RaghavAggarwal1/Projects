// Assignment #: 5
//         Name: Raghav Aggarwal
//    StudentID: 1215935292
//      Lecture: MW 4:35 - 5:50
//  Description: creating a child class of the class employee to store the records of the part time employee

import java.text.DecimalFormat;
public class PartTimeEmployee extends Employee
{
    private double hourlyRate;
    private int hours;

    //using decimal and money format
    protected DecimalFormat money = new DecimalFormat("$##,##0.00");

    //constructor
    public PartTimeEmployee (String firstname, String lastname, String id, double hourlyRate, int hours)
    {
        super(firstname,lastname,id);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    //function computePayAmount
    public void computePayAmount()
    {
        payAmount = hours * hourlyRate;
    }

    //creating toString function
    public String toString()
    {
        String line;
        line = "\nPart Time Employee:"+super.toString()+
        "HourlyRate:\t\t"+money.format(hourlyRate)+"\n"+ 
        "Hours:\t\t\t"+hours+"\n\n";
        return line;
    }
}