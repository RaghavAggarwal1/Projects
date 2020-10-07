.data

    name:    .asciiz  "Raghav Aggarwal"   # for name;

    lbl:    .asciiz  "Please enter a number: " # label for sum

    endl:    .asciiz  "\n"   # for next line

    read:   .space 4

    .text

main:
   
   la $a0,name
   li $v0,4
   syscall
    
    li $t1,1
    li $t5,3

    ori $s1, $0, 0 # $s1 = a1
    ori $s2, $0, 0 # $s2 = a2
    ori $s3, $0, 0 # $s3 = a3
    ori $s4, $0, 0 # $s4 = a4
    ori $s5, $0, 0 # $s5 = a5

    ori $s6, $0, 0 # $s6 = sum
    ori $s7, $0, 0 # $s7 = avg
    ori $t4, $0, 5 # $s8 = 5

wLoop:
    bgt		$t1, $t5, target	# if $t1 > $t5 then target
    la		$a0, endl
    li      $v0,4
   syscall
    la		$a0, lbl            #print Label
    li      $v0,4
   syscall

    
    li $v0, 5
    syscall
    addi	$s1, $v0, 0			# $s1 = $v0 + 0

    la		$a0, endl           #Printing a break statemment
    li      $v0,4
   syscall
    la		$a0, lbl            #Print "Please enter a number: "
    li      $v0,4
   syscall

    li      $v0, 5              #output
    syscall
    addi	$s2, $v0, 0			# $s1 = $v0 + 0

    la		$a0, endl           #Printing a break statemment
    li      $v0,4
   syscall
    la		$a0, lbl            #Print "Please enter a number: "
    li      $v0,4
   syscall

    li      $v0, 5              #output
    syscall
    addi	$s3, $v0, 0			# $s1 = $v0 + 0

    la		$a0, endl           #Printing a break statemment
    li      $v0,4
   syscall
    la		$a0, lbl            #Print "Please enter a number: "
    li      $v0,4
   syscall

    li      $v0, 5              #output
    syscall
    addi	$s4, $v0, 0			# $s1 = $v0 + 0

    la		$a0, endl           #Printing a break statemment
    li      $v0,4
   syscall
    la		$a0, lbl            #Print "Please enter a number: "
    li      $v0,4
   syscall

    li      $v0, 5              #output
    syscall
    addi	$s5, $v0, 0			# $s1 = $v0 + 0

    add		$s6, $s1, $s2		# $s6 = s11 +s2t2
    add		$s6, $s6, $s3		# $s6 = s1 + $t2
    add		$s6, $s6, $s4		# $s6 = s1 + $t2
    add		$s6, $s6, $s5		# $s6 = s1 + $t2

    div		$s6, $t4			# $s6 / $t4
    mflo	$t2					# $t2 = floor($s6 / $t4) 
    mfhi	$t3					# $t3 = $s6 mod $t4 
    
    addi $a0, $s6, 0   
   li $v0, 1       
    syscall
    la		$a0, endl           #Printing a break statemment
    li      $v0,4
   syscall
    
    
    addi $a0, $t2, 0   
   li $v0, 1       
    syscall
    la		$a0, endl           #Printing a break statemment
    li      $v0,4
   syscall

    #################

    mtc1 $s6, $f6	# move to coprocessor
	cvt.s.w $f6, $f6 # create sum as float

	ori $t0, $0, 5	# divisor
	mtc1 $t0, $f5	# move to coprocessor
	cvt.s.w $f4, $f5 # create 3.0
	
	div.s $f12, $f6, $f4 # calculate average
	
	ori $v0, $0, 4
	addiu $a0, $a0, 12 # get start of string
	syscall		# print the prompt

	ori $v0, $0, 2	# command to print float
	syscall		# output value in $v12

    addi	$t1, $t1, 1			# $t1 = $t1 + 1

    j		wLoop				# jump to wLoop
    
target:

    ori $v0,$0,10
    syscall
        

    		 
    
    