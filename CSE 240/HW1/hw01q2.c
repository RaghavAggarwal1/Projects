#include <stdio.h>
void main()
{
char ch = '+';
float a = 10.0, b = 20.0;
float f;
printf("ch = %c\n",ch);
switch (ch) {
case '+': f = a + b;printf("f = %f\n", f);
break;
case '-': f = a - b;printf("f = %f\n", f);
break;
case '*': f = a * b;printf("f = %f\n", f);
break;
case '/': f = a / b;printf("f = %f\n", f);
break;
default: printf("invalid operator\n");
}
ch = '-';
printf("ch = %c\n", ch);
switch (ch) {
case '+': f = a + b;printf("f = %f\n", f);
break;
case '-': f = a - b;printf("f = %f\n", f);
break;
case '*': f = a * b;printf("f = %f\n", f);
break;
case '/': f = a / b;printf("f = %f\n", f);
break;
default: printf("invalid operator\n");
}
ch = '*';
printf("ch = %c\n", ch);
switch (ch) {
case '+': f = a + b;printf("f = %f\n", f);
break;
case '-': f = a - b;printf("f = %f\n", f);
break;
case '*': f = a * b;printf("f = %f\n", f);
break;
case '/': f = a / b;printf("f = %f\n", f);
break;
default: printf("invalid operator\n");
}
ch ='/';
printf("ch = %c\n", ch);
switch (ch) {
case '+': f = a + b;printf("f = %f\n", f);
break;
case '-': f = a - b;printf("f = %f\n", f);
break;
case '*': f = a * b;printf("f = %f\n", f);
break;
case '/': f = a / b;printf("f = %f\n", f);
break;
default: printf("invalid operator\n");
}
ch ='%';
printf("ch = %c \n", ch);
switch (ch) {
case '+': f = a + b;printf("f = %f\n", f);
break;
case '-': f = a - b;printf("f = %f\n", f);
break;
case '*': f = a * b;printf("f = %f\n", f);
break;
case '/': f = a / b;printf("f = %f\n", f);
break;
default: printf("invalid operator\n");
}

}


