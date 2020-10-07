#CSE230 Assignment 3
#Class ID - 738
#Class No - 11217
#Raghav Aggarwal 
#ASU ID - 1215935292

.data 
.word 0 
.word 0 
.word 0
.word 0
.globl main 
.text 
main:

lui     $s0,0x1001

addi	$v0, $0, 5		# $t0 = $t1 + 0 #READ
syscall

add 	$t0, $v0, $0			# $t0 = $t1 + 0
sw		$t0, 0($s0)		# 

addi	$v0, $0, 5		# $t0 = $t1 + 0 #READ
syscall

add	    $t1, $0, $v0			# $t0 = $0 +$v00
sw		$t1, 4($s0)		# 

slt $t2, $t1, $t0
beq $t2, $0, edc

add $t3, $zero, $t1         #s1 small
add $t4, $zero, $t0         #s0 big

j exit				# jump to exit

edc:

add $t3, $zero, $t0         #s0 small
add $t4, $zero, $t1         #s1 big

j exit				# jump to exit

exit:

sw $t3, 12($s0)
sw $t4, 8($s0)

addi	$v0, $0, 10			# $v0 = 0 + 10
syscall