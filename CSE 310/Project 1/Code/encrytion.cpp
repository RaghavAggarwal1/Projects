//
// Created by raggar13 on 9/30/2020.
//CSE 310
//Raghav Aggarwal
//Project 1
//

#include <iostream>
#include <cstring>
#include <sstream>

using namespace std;

//Function to swap using pointers
void swap(string *a, string *b){
    string temp;
    temp = *a;
    *a = *b;
    *b = temp;
}

//Supporting function for quick sort using pointers
int partition(string *lastSort, int left, int right)
{
    string pivot;

    int i = left;
    int j = right-1;

    pivot = *(lastSort+right);

    while(i<j && i<(right-left) && j>=left)
    {
        //setting the location where elemeny is greater on left side
        while(*(lastSort+i)<pivot){
            i++;
        }
        //setting the location where elemeny is greater on right side
        while(*(lastSort+j)>pivot){
            j--;
        }
        //swapping if we find the above position
        if (i<j)
        {
            swap((lastSort+i),(lastSort+j));
        }
    }
//placing the pivot to right spot
    swap((lastSort+i),(lastSort+right));
//returning the new mid
    return(i);
}
//quick sort func using pointers
void quickSort(string *lastSort,int left,int right)
{
    //recursive calls
    int mid=0;
    if(left<right)
    {
        mid = partition(lastSort,left,right);
        quickSort(lastSort,left,mid-1);
        quickSort(lastSort,mid+1,right);
    }
}
//insertion sort function using pointers
void insertionSort(string *enc,int s){
    string key;
    for (int j = 1; j < s; j++) {
        //setting the key
        key =*(enc+j);
        int i = j - 1;
        while (i >= 0 && (key< *(enc+i)) ) {
            //swapping when it matches
            swap((enc+i),(enc+i+1));
            i = i - 1;
        }
        //updating the key
        *(enc+i + 1)= key;
    }
}

void encrytion(string cha) {
    string input;
    //reading the file input till end of file
    while (getline(cin, input) || input.length() == 1 || input.length() == 0) {
        //if there is an empty line it will still read it.
        while (input.length() == 1 || input.length() == 0)
            getline(cin, input);

        char ft; //to store first character
        int lt;
        //copying strings in array a
        string a, a2;
        a = input;
        a2 = input;

        //making variable = size of array
        const int size = input.size();


        string enc[size];
        string enc2[size];

        //encoding moving first element to last place
        for (int i = 0; i < input.size() -
                            1; i++) {                                                               //loop to run input-1 times
            ft = a[0];       //storing first element into ft
            for (int j = 0; j < input.size() - 1; j++) {
                a[j] = a[j + 1];     //shiting all other char by -1 pos
            }

            lt = input.size() - 1;
            a[lt] = ft; //storing first char into last of the array

            //copying the required array into a 3d array
            enc[i + 1] = a;
        }

        //pasting the original array back to the 2d array
        enc[0] = a2;
        int s = input.size();
        //insertion sort
//calling insertion and quick sort depending on the input from user
        string *ptr = &enc[0];
        if (cha=="insertion"||cha=="quick"){
            insertionSort(ptr,s);
        }
        else if(cha=="quick."){
              quickSort(ptr,0,s-1);
        }
        else{
              cout<<cha;
              cout<<"Selection not available.";
              break;
        }

        for(int i=0;i<input.size();i++){
            enc2[i]=*(ptr+i);
        }
        //finding the position of the original string in the sorted array
        int pos = -1;
        for (int i = 0; i < input.size() - 1; i++) {
            if (enc2[i] == a2) {
                pos = i;
                break;
            }
        }

        //making an array which contains the last col of sorted array
        string lastN;
        string lastChar;
        for (int i = 0; i < input.size(); i++) {
            lastN = enc2[i];
            lastChar[i] = lastN[input.size() - 1];
        }


        //function to count the clusters in the last col of sorted array
        int count = 1;
        int cluster = 0;
        string lastC = "";

        cout << pos << endl;
        for (int i = 0; i < input.size(); i++) {
            if (lastChar[i] != lastChar[i + 1]) {
                lastC = lastC + to_string(count);
                lastC = lastC + " ";
                lastC = lastC + lastChar[i];
                if (i + 1 != input.size()) {
                    lastC = lastC + " ";
                }

                count = 1;
                cluster++;
            } else {
                count++;
            }
        }
//printing the final encrypted string
        cout << lastC << endl;

    }
}

int main(int ch, char *cha[]){
    string a = cha[1];
    //taking input from user and passing it to our function
    encrytion(a);
    return 0;
}