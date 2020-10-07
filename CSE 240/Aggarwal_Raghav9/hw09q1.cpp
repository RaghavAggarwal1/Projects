
// CSE240 Spring 2020 HW9
//Raghav Aggarwal
// Write the compiler used:  g++

// READ BEFORE YOU START:
// You are given a partially completed program which consist of a class 'Patient' defined in patient.h
// The definitions of class member functions are to be filled in patient.cpp
// hw09q1.c (this file) creates an array of objects 'p[]' and uses a menu driven program to add a patient, display patient info, 
// sort the patient list and to find the oldest patient(by age).
// You should start completing the program from from Q1. Question numbers are given around line 33.
// To begin, you should trace through the given code and understand how it works.
// Please read the instructions above each required function and follow the directions carefully.
// If you modify any of the given code, the return types, or the parameters, you risk getting compile error.
// You are not allowed to modify main ().

// ***** WRITE COMMENTS FOR IMPORANT STEPS OF YOUR CODE. *****
// ***** GIVE MEANINGFUL NAMES TO VARIABLES. *****

#include "patient.h"
#include <iostream>
#include <string>

#define MAX_PATIENTS 5

using namespace std;

// forward declaration of functions (already implmented)
void executeAction(char);

// functions that need implementation:
// in patient.cpp :
// Q1 Patient constructor		// 2 points
// Q2 Patient member functions // 18 points

// in this file (hw09q1.cpp) : Q3 to Q6
int addPatient(string name_input, int age_input, int DOByear_input, int ID_input); // 10 points
void displayPatients();				// 5 points
void sort();						// 10 points
void oldestPatient();		// 5 points


Patient p[MAX_PATIENTS];		// array of objects
int currentCount = 0;				// number of patients in the list


int main()
{
	char choice = 'i';		// initialized to a dummy value
	do
	{
		cout<<"\nCSE240 HW9\n";
		cout << "Please select an action:\n";
		cout << "\t a: add a new patient\n";
		cout << "\t d: display patient list\n";
		cout << "\t s: sort the patients in descending order based on DOB (within a range)\n";
		cout << "\t n: display the oldest patient whose name starts with a specific letter\n";
		cout << "\t q: quit\n";
		cin >> choice;
		cin.ignore();			// ignores the trailing \n
		executeAction(choice);
	} while (choice != 'q');

	return 0;
}


// Ask for details from user for the given selection and perform that action
// Read the function case by case
void executeAction(char c)
{
	string name_input;
	int age_input, DOByear_input, ID_input, result = 0;

	switch (c)
	{
	case 'a':	// add patient
				// input patient details from user
		cout << "Please enter patient name: ";
		getline(cin, name_input);
		cout << "Please enter age: ";
		cin >> age_input;
		cin.ignore();
		cout << "Please enter year of birth: ";
		cin >> DOByear_input;
		cin.ignore();
		cout << "Please enter ID: ";
		cin >> ID_input;
		cin.ignore();

		// add the patient to the list
		result = addPatient(name_input, age_input, DOByear_input, ID_input);
		if (result == 0)
			cout<<"\nThat patient is already in the list or list is full! \n\n";
		else
			cout << "\nPatient successfully added to the list! \n\n";
		break;

	case 'd':		// display the list
		displayPatients();
		break;
	
	case 's':		// sort the list
		sort();
		break;

	case 'n':		// find and display oldestt patient
		oldestPatient();
		break;

	case 'q':		// quit
		break;

	default: cout << c <<" is invalid input!\n";
	}
	
}

// Q3 addPatient (10 points)
// This function adds a new patient with the details given in function arguments.
// Add the patient in 'p' (array of objects) only if there is remaining capacity in the array and if the patient does not already exist in the list
// This function returns 1 if the patient is added successfully, else it returns 0 for the cases mentioned above.
// Assume user enters age in 0.0 - any positive integer range.
int addPatient(string name_input, int age_input, int DOByear_input, int ID_input)
{
    if(currentCount<=5){
        p[currentCount].setName(name_input);
        p[currentCount].setAge(age_input);
        p[currentCount].setDOByear(DOByear_input);
        p[currentCount].setID(ID_input);
        currentCount++;
        return 1;    // edit this line if needed
    }
    return 0;
}

// Q4 displayPatients (5 points)
// This function displays the list of patients.
// Parse the object array 'p' and display the details of all patientss in the array. See expected output given in question file.
// You can call the class function 'displayPatients()' here. Note that these are two different functions.
// Patient::displayPatient() displays details of one Patient object, while displayPatients() should display all patients
void displayPatients()
{
    if(currentCount>5){
        return;
    }
    for(int i=0; i<=currentCount;i++){
        p[i].displayPatient();
    }

}

// Q5 sort (10 points)
// This function sorts the patiens in descending order of age within a given range.
// You may use the 'temp' object for sorting logic, if needed.

void sort()
{
	Patient temp;
    int lb,ub;
	// enter code here
    cout<<"Please enter the lower bound of the range: ";
    cin>>lb;
    cout<<"Please enter the upper bound of the range: ";
    cin>>ub;
    for(int i=0;i<=currentCount;i++){
        if(p[i].getAge()>=lb && p[i].getAge()<=ub){
        for(int j=i+1; j<=currentCount;j++)
        if(p[j].getAge()>=lb && p[j].getAge()<=ub){
            if(p[i].getAge()<p[j].getAge()){
                temp = p[i];
                p[i] = p[j];
                p[j] =  temp;
            }
            }
        }
    }
    for(int i=0; i<=currentCount;i++){
        if(p[i].getAge()>=lb && p[i].getAge()<=ub){
        p[i].displayPatient();
    }
    }
}

// Q6 oldestPatient (5 points)
// This functions displays patients who is oldest and whose name starts with a specific letter
// Parse the array to check if the patient is the oldest patient based of the character input
// If the patient is the oldest patient year then copy that patient's details (object's data members) 
// to 'newPatient' object created using 'new' and display those patient details using 'newPatient' object.
// Finally delete the 'newPatient' object.
// NOTE: You necessarily have to use the 'newPatient' object to store the patient details in it and delete it after displaying.
//       You should not display patient details using 'p[]' object.

void oldestPatient()
{
	char startingCharacter;				// Ask the user for a character
	Patient* newPatient = new Patient;
	// enter code here
    string a;
    cout<<"Enter the first letter of patients' first name: ";
    cin>>startingCharacter;
    int age1=0;
    for(int i=currentCount;i>=0;i--){
        if(p[i].getName()[0]==startingCharacter){
            if (p[i].getAge()>age1) {
                *newPatient=p[i];
            }
        }
        newPatient->displayPatient();
        delete newPatient;
    }
}
