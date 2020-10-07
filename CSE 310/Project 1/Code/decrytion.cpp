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
    int mid=0;
    //recursive calls
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

//decryption meathod taking input of the type of fuction to be used
void decrytion(string cha){
//taking input of the number
    string num;
    while (getline(cin, num)) {
        //converting string into int
        int pos2 = stoi(num);
        //taking in second line
        string lineI;
        getline(cin, lineI);

        string tem = lineI;
        //creating new string arrays
        int no[lineI.size() / 2];
        string chara[lineI.size() / 2];
        int total1 = 0;
        char h;

        int u = 0;


//**************************************************************************************************

        //reading the decoded line and seperating it into nos and char
        string g=" ";
        string temp;

        int w=0;
        u=0;
        string numf="";

        for(int i=0;i<lineI.size();i++){
            temp = lineI[i];
            if(i<lineI.size()) {
                //taking no till it finds " "
                while (temp != " " && i < lineI.size()) {
                    numf = numf + lineI[i];
                    i++;

                    temp = lineI[i];
                }
                if (i < lineI.size()) {
                    no[u] = stoi(numf);
                    total1 += no[u];
                    u++;
                }
                i++;
                numf = "";

                //taking char till it gets " " or there is a " " after another " "
                temp = lineI[i];
                if (temp == " " && i < lineI.size()) {
                    chara[w] = lineI[i + 1];
                    w++;
                    i++;
                } else {
                    while (temp != " " && i < lineI.size()) {
                        chara[w] = lineI[i];
                        w++;
                        i++;

                        temp = lineI[i];
                    }
                }
            }
        }
        //counting the size of the new array
        const int total = total1;


//***************************************************************************************************
//      u = 0;
int d=0;
        // int plus1 = 0;
        //multiplying cluster to car to get original last col of array
        string lastChar[total];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < no[i]; j++) {
                lastChar[d] = chara[i];
                d++;
            }
        }


        // // Decryption

        //creating copies of array to save override
        string lastSort[total], lastChar2[total];
        string lastSort4[total];
        for (int i = 0; i < total; i++) {
            lastSort[i] = lastChar[i];
        }
        for (int i = 0; i < total; i++) {
            lastChar2[i] = lastChar[i];
        }

        const int r = total - 1;

        //creating an pointer object
        //calling insertion and quick sort depending on the input from user
        string *ptr = &lastSort[0];
        if (cha=="insertion"||cha=="quick"){
            insertionSort(ptr,total);
        }
        else if(cha=="quick."){
            quickSort(ptr,0,r);
        }
        else{
            cout<<cha;
            cout<<" Sort not available.";
            break;
        }

        for(int i=0;i<total;i++){
            lastSort4[i]=*(ptr+i);
        }
        //***end****

//last sort has the sorted array

        int nullarray[total];
        int next[total];
        for (int i = 0; i < total; i++) {
            nullarray[i] = 0;
            next[i] = 0;
        }
//int ch, char *cha[]
        //1 i 1 p 2 s 1 M 1 p 1 i 2 s 2 i

        //finding the next charachters
        int flag = 0;
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (nullarray[j] == 0 && flag == 0) {
                    string s = lastSort4[i];
                    string c = lastChar2[j];
                    if (s == c) {
                        next[i] = j;
                        nullarray[j] = 1;
                        flag = 1;
                    }
                }
            }

            flag = 0;
        }


        string dec = "";
    //adding line to a string
        for (int i = 0; i < total; i++) {
            dec = dec + lastSort4[pos2];
            pos2 = next[pos2];
        }
        //outputting the line
        cout << dec << endl;
    }
}
int main(int ch, char *cha[]){
    string a = cha[1];
    //taking input from user and passing it to our function
    decrytion(a);
    return 0;
}