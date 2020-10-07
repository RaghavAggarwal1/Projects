//CSE240 Spring 2020 HW3

// Raghav Aggarwal
// State the IDE that you use: GCC

#include <stdio.h>
#include <string.h>

//#pragma warning(disable : 4996)  // compiler directive for Visual Studio only

// Read before you start:
// You are given a partially complete program. Your job is to complete the functions in order for this program to work successfully.
// All instructions are given above the required functions, please read them and follow them carefully.
// You shoud not modify the function return types or parameters.
// You can assume that all inputs are valid. Ex: If prompted for an integer, the user will input an integer.

// Global Macro Values. They are used to define the size of 2D array of characters
#define NUM_STRINGS 4
#define STRING_LENGTH 50

// Forward Declarations
void initializeStrings(char[NUM_STRINGS][STRING_LENGTH]);
void printStrings(char[NUM_STRINGS][STRING_LENGTH]);
void reverseStrings(char strings[NUM_STRINGS][STRING_LENGTH]);
void encryptStrings(char[NUM_STRINGS][STRING_LENGTH], int);
void decryptStrings(char[NUM_STRINGS][STRING_LENGTH], int);
int splitAndPrintSentences(char s[NUM_STRINGS*STRING_LENGTH]);
void inputMatrix(int matrixA[3][3]);
void determinant(int matrixA[3][3]);

// Problem 1: initializeStrings (5 points)
// Traverse the 2D array of characters variable 'strings' (input from user in main() ) and set all characters in each
// array to a null terminator so that there is a 4 row and 35 column 2D array full of null terminators.
// The null terminator is represented by the character value '\0' and is used to denote the end of a string.
// This may come in use later in the program to know the end of string.
void initializeStrings(char strings[NUM_STRINGS][STRING_LENGTH])
{
    char *p=strings[0][0];          //making a pointer p point at initial of array
    for(int i=0;i<NUM_STRINGS;i++){
        for(int j=0;j<STRING_LENGTH;j++){
            p=&strings[i][j];
            *p='\0';        // pointer to put each value to null
        }
    }

}


// Problem 2: printStrings (5 points)
// Traverse the 2D character array "strings" and print each of the contained strings.
// See the example outputs provided in the word document. Your output should match the example outputs.
void printStrings(char strings[NUM_STRINGS][STRING_LENGTH])
{
    for(int i=0;i<NUM_STRINGS;i++){
        for(int j=0;j<STRING_LENGTH;j++){
            printf("%c", strings[i][j]);    //Printing the array
        }
        printf("\n");
    }

}


// Problem 3: reverseString (5 points)
// Reverse each string of strings[][].
// Consider one string at a time and reverse the characters. For instance, "hi hello" should reverse to "olleh ih".
void reverseStrings(char strings[NUM_STRINGS][STRING_LENGTH])
{

    for(int i=0;i<NUM_STRINGS;i++){
            int s,e;    //variable s to run from start and e to run from end of the array
            s = 0;
            e = STRING_LENGTH-1;

            while (s<e){    //till s is less than e. so the loop stops at mid point
                char temp;
                //swap
                temp = strings[i][s];
                strings[i][s]=strings[i][e];
                strings[i][e]=temp;
                //changing values of s and e. Amking them move across array
                s++;
                e--;
            }
    }
}

// Problem 4: encryptStrings (5 points)
// Traverse the 2D character array 'strings' and encrypt each string in 2 steps as follows-
// 1) Reverse the string.
// Hint: Use 'reverseStrings()' for this step.
// 2) Then shift those ASCII characters forward by the integer value of 'key'.
// If the string is "hello" and key = 2, reversing will get you "olleh" and adding key to it will result in "qnnfj"
// If the value of 'key' is large, you will extend past the alphabetical characters and reach non-alphabetical characters. Thats ok.

// NOTE: DO NOT encrypt the null terminator character. Use the null terminator '\0' to find the end string.
// *** NOTE: If you were unable to code for reverseStrings(), then skip that step in this function and simply shift the characters ahead by 'key'.
//            While decrypting in the next function, you will again have to skip the reversing part. You will get partial points in that case.
void encryptStrings(char strings[NUM_STRINGS][STRING_LENGTH], int key)
{
  reverseStrings(strings);
    
    char *p=&strings[0][0]; //pointer to point at iunitial location of array
    for (int i=0;i<NUM_STRINGS;i++){
        for(int j=0;j<STRING_LENGTH;j++){
            *p=*p+key;  // pointer will increase the value by key
            p++;    //changing the pointer to another array memeber.
        }
    }
}
// Problem 5: decryptStrings (5 points)
// HINT: This should be very similiar to the encryption function defined above.
// Traverse the 2D character array 'strings' and decrypt each string in 2 steps as follows-
// 1) Shift those ASCII characters backward by the integer value of 'key'.
// 2) Then reverse the string.
// Hint: Use 'reverseStrings()' for this step.
// *** NOTE: If you were unable to code for reverseStrings(), then skip that step in this function and simply shift the characters backward by 'key'.
//            You will get partial points in that case.
void decryptStrings(char strings[NUM_STRINGS][STRING_LENGTH], int key)
{
    char *p=&strings[0][0]; //pointer to point at iunitial location of array
       for (int i=0;i<NUM_STRINGS;i++){
           for(int j=0;j<STRING_LENGTH;j++){
               *p=*p-key;   // pointer will decrease the value by key
               p++; //changing the pointer to another array memeber.
           }
       }
       reverseStrings(strings);
}

// Problem 6: splitAndPrintSentences (10 points)
// Split s[] into individual sentences and store them in str[][].
// Read s[] character by character and copy into str[][], such that sentence 1 is in str[0][], sentence 2 is in str[1][] and so on.
// Print the char array str[][], so that you will print the separated sentences. Finally return the number of sentences in 'count'
// Dont forget to initialize str[][] with nulls.
// Hint: Sentences are separated by full-stop.

int splitAndPrintSentences(char s[NUM_STRINGS*STRING_LENGTH])
{
    char str[NUM_STRINGS][STRING_LENGTH];
    int count = 0;
    int i=0,j=0;
    char x ='.';
    
    for (i=0; i<strlen(s); i++){
            if(s[i]==x){    //if loop encounters .
                count++;    //the no of lines increases
                j=0;        // j is counting the size of array horizontally.
                            //with change in line it will become 0
            }
            else{
                str[count][j] = s[i];   //till the time the line is not changing it is gettin g added to the str
                j++;
            }
        }
        //Printing the arr array
        for(i=0; i<count; i++){
            for(int e=0; e<strlen(str[i]);e++){
                printf("%c",str[i][e]);
            }
            printf("\n");
        }
return count;
}

// Problem 7: inputMatrix (10 points)
// Ask the user for each element of the 3X3  matrix and store the elements in "matrixA[][]"
// Display the matrix in the following form:
// matrixA =
// 1 2 3
// 4 5 6
// 7 8 9
// The user may input any inetgers for matrix elements, not necessarily same as example above.
void inputMatrix(int matrixA[3][3])
{
    //taking input of the array
    printf("Please enter the 3x3 Matrix\n");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            printf("Enter matrix element [%d][%d] :",i,j);
            scanf("%d",&matrixA[i][j]);
        }
    }
    //printing the output of the array.
    printf("matrixA =\n");
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            printf("%d \t",matrixA[i][j]);
        }
        printf("\n");
    }

}

// Problem 8: determinant (5 points)
// Calculate the determinant of the 3x3 matrix "matrixA[][]" and print it.
// Read about how to caclualte the determinant of 3x3 matrix. Here is a video tutorial: https://www.khanacademy.org/math/algebra-home/alg-matrices/alg-determinants-and-inverses-of-large-matrices/v/finding-the-determinant-of-a-3x3-matrix-method-2
// Since it is strictly a 3x3 matrix, you may use hardcoded indices. For eg- matrixA[0][0] to access 1st element of the matrix
void determinant(int matrixA[3][3])
{
    int  det = 0;
    // enter code below
    //using the formula to calculate the det(A)
    det = matrixA[0][0]*((matrixA[1][1]*matrixA[2][2])-(matrixA[2][1]*matrixA[1][2]))-matrixA[0][1]*((matrixA[1][0]*matrixA[2][2])-(matrixA[2][0]*matrixA[1][2]))+matrixA[0][2]*((matrixA[1][0]*matrixA[2][1])-(matrixA[2][0]*matrixA[1][1]));


    printf("\nDeterminant of matrix = %d\n", det);
}

// You should study and understand how this main() works.
// *** DO NOT modify it in any way ***
int main()
{
    char sentences[NUM_STRINGS*STRING_LENGTH];
    char strings[NUM_STRINGS][STRING_LENGTH]; // will store four strings each with a max length of 34
    int i, key, count;
    char input[STRING_LENGTH];
    int matrixA[3][3];                        // 3x3 int array for matrix
    
    printf("CSE240 HW3: 2D Character Arrays\n\n");
    initializeStrings(strings);
    
    for (i = 0; i < NUM_STRINGS; i++)
    {
        printf("Enter string for encryption: "); // prompt for string
        fgets(input, sizeof(input), stdin); // store input string
        input[strlen(input) - 1] = '\0'; // convert trailing '\n' char to '\0' (null terminator)
        strcpy(strings[i], input); // copy input to 2D strings array
    }
    
    printf("\nEnter a key value for encryption: "); // prompt for integer key
    scanf("%d", &key);
    
    encryptStrings(strings, key);
    printf("\nEncrypted Strings:\n");
    printStrings(strings);
    decryptStrings(strings, key);
    printf("\nDecrypted Strings:\n");
    printStrings(strings);
    
    i = getchar(); // remove the character '\n'
    printf("\nEnter sentences(max 4): ");
    fgets(sentences, sizeof(sentences), stdin); // store string
    input[strlen(sentences) - 1] = '\0';            // convert trailing '\n' char to '\0' (null terminator)
    count = splitAndPrintSentences(sentences);
    printf("\nNumber of sentences= %d \n", count);

    printf("\nCSE240 HW3: 2D Integer Arrays\n\n");
    inputMatrix(matrixA);
    determinant(matrixA);

    i = getchar(); // remove the character '\n'
    i = getchar(); // keep console open in VS
    return 0;
}

