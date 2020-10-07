#CSE230 Assignment 4
#Class ID - 738
#Raghav Aggarwal 
#ASU ID - 1215935292
#Class No - 11217

.data
.asciiz "\nPlease Enter a Number\n"
.text
.globl main
main:
    jal getsum          # call function to print sum of input
    ori $a0, $v0, 0     # copy sum to $a0
    ori $v0, $0, 1      # set output command
    syscall
    
    end:   
        ori $v0, $0, 10     # set command to stop program,
        syscall             # end program

    #checking if the no enetered is odd or not
    isodd:
        andi	$t0, $a0, 1			# $t0 = $a0 x 1 #checking if last didgit is 1 or 0
        beq		$t0, $0, ifeven	    # if $t0 ==0  then call ifeven
        addi	$v0, $0, 1			# else #$v0 = 1
        jr		$ra					# jump to $ra
        
    # if no is even then assigning v0 value of 0
    ifeven:
        addi	$v0, $0, 0			# $v0 =$0 + 1   # if last digit is 0
        jr		$ra					# jump to $ra

    #to add the value of all numbers enetered 
    issum:
        add		$t3, $t3, $a0		# $t3 = $t3 + $a0
        j       rt				    # jump to $ra
        
    getsum:
        lui     $a0, 0x1001         # loading the base adress in a0
        addi	$v0, $0, 4			# $v0 = $0 + 4
        syscall

        addi	$v0, $0, 5			# $v0 = $0 + 5
        syscall

        add		$a0, $0, $v0		# $a0 = $v0    #saving value of v0 in a0
        
        add		$s0, $0, $ra		# $s0 = ra  #saving the new value for ra
        
        jal		isodd				# jump to isodd
        
        add		$ra, $0, $s0		# $ra = $s0 #restoring the value of ra
        
        beq		$v0, $0, issum	    # if no is even then calling issum to add them
        rt:                         #returning here from issum
        addi	$t1, $0, 0			# $t1 = 0
        slt     $t2, $a0, $t1       #a0<0, then t2 =1 otherwise t2 =0 #checking for if no is possitive or negative
        beq		$t2, $0, getsum	    # if t2>0, then we can go in the loop again
        add		$v0, $0, $t3		# putting final sum of even no back in $v0 #if a negative no is entered than ending the function
        jr		$ra					# jump to $ra
            

            			
            
            

            
            
            

        

    