#include <stdio.h>
void main()
{

    float a = 10, b = 20;

    for(int i=1; i<=5; i++){
        char ch;
        float f;
        printf("Eneter the operation: ");
        scanf("%c",&ch);
        printf("ch= %c\n",ch);

        switch (ch) {
            case '+': f = a + b;printf("f = %1.0f\n", f);
            break;
            case '-': f = a - b;printf("f = %1.0f\n", f);
            break;
            case '*': f = a * b;printf("f = %1.0f\n", f);
            break;
            case '/': f = a / b;printf("f = %1.1f\n", f);
            break;
            default: printf("invalid operator\n");
             }
              ch = getchar();
        }
}

