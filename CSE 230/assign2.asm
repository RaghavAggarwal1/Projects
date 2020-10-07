#CSE240 Assignment 2 
#Class ID - 738
#Class No - 11217
#Raghav Aggarwal 
#ASU ID - 1215935292

.data
.globl main
.text 
main:

#Initialize $s0 to 15
addi	$s0, $s0, 15		#s0 = $s0 + 15

#Initialize $s1 to -4 
addi	$t6, $zero, 4		# $t6 = 0 + 4
sub		$s1, $zero, $t6		# $s1 = 0 - 4

#Read (input) an integer and place the answer into $s2
addi	$v0, $zero, 5		# $v0 = 0 + 5
syscall                     #system Call
addi	$s2, $v0, 0			# $s2 = $v0 + 0

#Set $s3 to $s1 - $s0 + $s2
sub		$t0, $s1, $s0		# $t0 = $s1 - $s0
add		$s3, $t0, $s2		# $s3 = $t0 + $s2

#Set $s4 to $s3 + $s2 - 7
add		$t1, $s3, $s2		# $t1 = $s3 + $s2
sub		$s4, $t1, 7		    # $s4 = $t1 - 7

#Set $s5 to 20 + $s1 -$s2
sub		$t2, $s1, $s2		# $t2 = $s1 - $s2
addi	$s5, $t2, 20		# $s5 = $t2 + 20

#Exchange or swap the values in $s0 and $s1
add		$t3, $t3, $s0		# $t3 = $t3 + $s0
add		$s0, $0, $s1		# $s0 = 0 + $s1
add		$s1, $0, $t3		# $s1 = $0 + $t3

#Set $s2 to  -$s2
sub		$s2, $0, $s2		# $s2 = 0 - $s2

#Print the values for $s0, $s1, $s2, $s3, $s4 and $s5 (they will appear on the same line of output) 
addi	$a0, $s0, 0			# $a0 = $s0 + 0
addi	$v0, $0, 1			# $v0 = 0 + 1
syscall                     #system Call

addi	$a0, $s1, 0			# $a0 = $s1 + 0
addi	$v0, $0, 1			# $v0 = 0 + 1
syscall                     #system Call

addi	$a0, $s2, 0			# $a0 = $s2 + 0
addi	$v0, $0, 1			# $v0 = 0 + 1
syscall                     #system Call

addi	$a0, $s3, 0			# $a0 = $s3 + 0
addi	$v0, $0, 1			# $v0 = 0 + 1
syscall                     #system Call

addi	$a0, $s4, 0			# $a0 = $s4 + 0
addi	$v0, $0, 1			# $v0 = 0 + 1
syscall                     #system Call

addi	$a0, $s5, 0			# $a0 = $s5 + 0
addi	$v0, $0, 1			# $v0 = 0 + 1
syscall                     #system Call

#stoping program cleanly
addi	$v0, $0, 10			# $v0 = 0 + 10
syscall                     #system Call
