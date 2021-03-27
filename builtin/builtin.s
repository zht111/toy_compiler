	.text
	.file	"builtin.c"
	.globl	builtin_print           # -- Begin function builtin_print
	.p2align	2
	.type	builtin_print,@function
builtin_print:                          # @builtin_print
	.cfi_startproc
# %bb.0:
	lui	a1, %hi(.L.str)
	addi	a1, a1, %lo(.L.str)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	tail	printf
.Lfunc_end0:
	.size	builtin_print, .Lfunc_end0-builtin_print
	.cfi_endproc
                                        # -- End function
	.globl	builtin_println         # -- Begin function builtin_println
	.p2align	2
	.type	builtin_println,@function
builtin_println:                        # @builtin_println
	.cfi_startproc
# %bb.0:
	tail	puts
.Lfunc_end1:
	.size	builtin_println, .Lfunc_end1-builtin_println
	.cfi_endproc
                                        # -- End function
	.globl	builtin_printInt        # -- Begin function builtin_printInt
	.p2align	2
	.type	builtin_printInt,@function
builtin_printInt:                       # @builtin_printInt
	.cfi_startproc
# %bb.0:
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	tail	printf
.Lfunc_end2:
	.size	builtin_printInt, .Lfunc_end2-builtin_printInt
	.cfi_endproc
                                        # -- End function
	.globl	builtin_printlnInt      # -- Begin function builtin_printlnInt
	.p2align	2
	.type	builtin_printlnInt,@function
builtin_printlnInt:                     # @builtin_printlnInt
	.cfi_startproc
# %bb.0:
	lui	a1, %hi(.L.str.3)
	addi	a1, a1, %lo(.L.str.3)
	mv	a2, a0
	mv	a0, a1
	mv	a1, a2
	tail	printf
.Lfunc_end3:
	.size	builtin_printlnInt, .Lfunc_end3-builtin_printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	builtin_getString       # -- Begin function builtin_getString
	.p2align	2
	.type	builtin_getString,@function
builtin_getString:                      # @builtin_getString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	addi	a0, zero, 1000
	mv	a1, zero
	call	malloc
	mv	s0, a0
	lui	a0, %hi(.L.str)
	addi	a0, a0, %lo(.L.str)
	mv	a1, s0
	call	__isoc99_scanf
	mv	a0, s0
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end4:
	.size	builtin_getString, .Lfunc_end4-builtin_getString
	.cfi_endproc
                                        # -- End function
	.globl	builtin_getInt          # -- Begin function builtin_getInt
	.p2align	2
	.type	builtin_getInt,@function
builtin_getInt:                         # @builtin_getInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	lui	a0, %hi(.L.str.2)
	addi	a0, a0, %lo(.L.str.2)
	addi	a1, sp, 8
	call	__isoc99_scanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end5:
	.size	builtin_getInt, .Lfunc_end5-builtin_getInt
	.cfi_endproc
                                        # -- End function
	.globl	builtin_toString        # -- Begin function builtin_toString
	.p2align	2
	.type	builtin_toString,@function
builtin_toString:                       # @builtin_toString
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -96
	.cfi_def_cfa_offset 96
	sw	ra, 92(sp)
	sw	s0, 88(sp)
	sw	s1, 84(sp)
	sw	s2, 80(sp)
	sw	s3, 76(sp)
	sw	s4, 72(sp)
	sw	s5, 68(sp)
	sw	s6, 64(sp)
	sw	s7, 60(sp)
	sw	s8, 56(sp)
	sw	s9, 52(sp)
	sw	s10, 48(sp)
	sw	s11, 44(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	.cfi_offset s3, -20
	.cfi_offset s4, -24
	.cfi_offset s5, -28
	.cfi_offset s6, -32
	.cfi_offset s7, -36
	.cfi_offset s8, -40
	.cfi_offset s9, -44
	.cfi_offset s10, -48
	.cfi_offset s11, -52
	beqz	a0, .LBB6_4
# %bb.1:
	mv	s5, a0
	srai	a0, a0, 31
	add	a1, s5, a0
	xor	a0, a1, a0
	srli	s3, s5, 31
	beqz	a0, .LBB6_5
# %bb.2:                                # %.preheader1
	mv	a5, zero
	addi	a6, sp, 16
	lui	a2, 838861
	addi	a2, a2, -819
	addi	a3, zero, 10
	addi	a4, zero, 9
.LBB6_3:                                # =>This Inner Loop Header: Depth=1
	mv	s0, a0
	addi	s1, a5, 1
	slli	a0, a5, 16
	srai	a0, a0, 16
	slli	a0, a0, 1
	add	a5, a6, a0
	mulhu	a0, s0, a2
	srli	a0, a0, 3
	mul	a1, a0, a3
	sub	a1, s0, a1
	sh	a1, 0(a5)
	mv	a5, s1
	bltu	a4, s0, .LBB6_3
	j	.LBB6_6
.LBB6_4:
	addi	a0, zero, 2
	mv	a1, zero
	call	malloc
	addi	a1, zero, 48
	sb	a1, 0(a0)
	sb	zero, 1(a0)
	j	.LBB6_24
.LBB6_5:
	mv	s1, zero
.LBB6_6:
	slli	a0, s1, 16
	srai	s4, a0, 16
	add	s2, s3, s4
	addi	a0, s2, 1
	srai	a1, a0, 31
	call	malloc
	addi	a1, zero, -1
	blt	a1, s5, .LBB6_8
# %bb.7:
	addi	a1, zero, 45
	sb	a1, 0(a0)
.LBB6_8:
	addi	a1, zero, 1
	blt	s4, a1, .LBB6_23
# %bb.9:
	lui	a1, 16
	addi	a1, a1, -1
	and	a1, s1, a1
	addi	a2, zero, 16
	bgeu	a1, a2, .LBB6_11
# %bb.10:
	mv	a7, zero
	mv	a1, zero
	not	a5, a7
	andi	a2, s1, 1
	not	s0, a1
	beqz	a2, .LBB6_17
	j	.LBB6_19
.LBB6_11:
	sub	a3, s4, a1
	mv	a7, zero
	bge	a3, s4, .LBB6_18
# %bb.12:
	addi	a3, a1, -1
	sltu	a1, a3, a1
	addi	a3, a1, -1
	mv	a1, a7
	bnez	a3, .LBB6_16
# %bb.13:
	sw	s2, 12(sp)
	mv	a1, zero
	lui	a2, 16
	addi	a2, a2, -16
	and	a7, s1, a2
	addi	a6, sp, 16
	mv	a5, zero
	mv	a4, zero
.LBB6_14:                               # =>This Inner Loop Header: Depth=1
	not	s0, a5
	add	s0, s0, s4
	slli	s0, s0, 1
	add	s0, a6, s0
	lh	t0, -14(s0)
	lh	t1, -12(s0)
	lh	t2, -10(s0)
	lh	t3, -8(s0)
	lh	t4, -6(s0)
	lh	t5, -4(s0)
	lh	a3, -2(s0)
	lh	a2, 0(s0)
	lh	t6, -30(s0)
	lh	s5, -28(s0)
	lh	s6, -26(s0)
	lh	s7, -24(s0)
	lh	s8, -22(s0)
	lh	s9, -20(s0)
	lh	s10, -18(s0)
	lh	s0, -16(s0)
	addi	s11, a2, 48
	addi	ra, a3, 48
	addi	t5, t5, 48
	addi	t4, t4, 48
	addi	t3, t3, 48
	addi	t2, t2, 48
	addi	s2, t1, 48
	addi	a3, t0, 48
	addi	t0, s0, 48
	addi	t1, s10, 48
	addi	s9, s9, 48
	addi	s8, s8, 48
	addi	s7, s7, 48
	addi	s6, s6, 48
	addi	s5, s5, 48
	addi	s0, t6, 48
	or	a2, a5, s3
	add	a2, a0, a2
	sb	a3, 7(a2)
	sb	s2, 6(a2)
	sb	t2, 5(a2)
	sb	t3, 4(a2)
	sb	t4, 3(a2)
	sb	t5, 2(a2)
	sb	ra, 1(a2)
	sb	s11, 0(a2)
	sb	s0, 15(a2)
	sb	s5, 14(a2)
	sb	s6, 13(a2)
	sb	s7, 12(a2)
	sb	s8, 11(a2)
	sb	s9, 10(a2)
	sb	t1, 9(a2)
	addi	a3, a5, 16
	sltu	a5, a3, a5
	add	a4, a4, a5
	xor	a5, a3, a7
	or	s0, a5, a4
	sb	t0, 8(a2)
	mv	a5, a3
	bnez	s0, .LBB6_14
# %bb.15:
	lui	a2, 16
	addi	a2, a2, -1
	and	a2, s1, a2
	xor	a2, a7, a2
	lw	s2, 12(sp)
	beqz	a2, .LBB6_23
.LBB6_16:
	not	a5, a7
	andi	a2, s1, 1
	not	s0, a1
	bnez	a2, .LBB6_19
.LBB6_17:
	mv	a3, a7
	j	.LBB6_20
.LBB6_18:
	mv	a1, a7
	not	a5, a7
	andi	a2, s1, 1
	not	s0, a1
	beqz	a2, .LBB6_17
.LBB6_19:
	not	a2, a7
	add	a2, a2, s4
	slli	a2, a2, 1
	addi	a3, sp, 16
	add	a2, a3, a2
	lb	a2, 0(a2)
	addi	a2, a2, 48
	or	a3, a7, s3
	add	a3, a0, a3
	sb	a2, 0(a3)
	ori	a3, a7, 1
	addi	a7, a7, 1
.LBB6_20:
	lui	a2, 16
	addi	a2, a2, -1
	and	a4, s1, a2
	snez	a2, a4
	neg	a2, a2
	neg	s1, a4
	xor	a5, a5, s1
	xor	a2, s0, a2
	or	a2, a5, a2
	beqz	a2, .LBB6_23
# %bb.21:                               # %.preheader
	sub	a2, s4, a7
	addi	a2, a2, -2
	addi	a6, sp, 16
.LBB6_22:                               # =>This Inner Loop Header: Depth=1
	slli	s1, a2, 1
	add	s1, a6, s1
	lb	s0, 2(s1)
	addi	s0, s0, 48
	lb	s1, 0(s1)
	add	a5, a3, s3
	add	a5, a0, a5
	sb	s0, 0(a5)
	addi	s1, s1, 48
	sb	s1, 1(a5)
	addi	a5, a3, 2
	sltu	a3, a5, a3
	add	a1, a1, a3
	xor	a3, a5, a4
	or	s1, a3, a1
	addi	a2, a2, -2
	mv	a3, a5
	bnez	s1, .LBB6_22
.LBB6_23:
	add	a1, a0, s2
	sb	zero, 0(a1)
.LBB6_24:
	lw	s11, 44(sp)
	lw	s10, 48(sp)
	lw	s9, 52(sp)
	lw	s8, 56(sp)
	lw	s7, 60(sp)
	lw	s6, 64(sp)
	lw	s5, 68(sp)
	lw	s4, 72(sp)
	lw	s3, 76(sp)
	lw	s2, 80(sp)
	lw	s1, 84(sp)
	lw	s0, 88(sp)
	lw	ra, 92(sp)
	addi	sp, sp, 96
	ret
.Lfunc_end6:
	.size	builtin_toString, .Lfunc_end6-builtin_toString
	.cfi_endproc
                                        # -- End function
	.globl	l_string_length         # -- Begin function l_string_length
	.p2align	2
	.type	l_string_length,@function
l_string_length:                        # @l_string_length
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strlen
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end7:
	.size	l_string_length, .Lfunc_end7-l_string_length
	.cfi_endproc
                                        # -- End function
	.globl	l_string_substring      # -- Begin function l_string_substring
	.p2align	2
	.type	l_string_substring,@function
l_string_substring:                     # @l_string_substring
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	s2, 0(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	mv	s2, a2
	mv	s1, a1
	mv	s0, a0
	addi	a0, zero, 1000
	mv	a1, zero
	call	malloc
	add	a1, s0, s1
	sub	a2, s2, s1
	lw	s2, 0(sp)
	lw	s1, 4(sp)
	lw	s0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	tail	memcpy
.Lfunc_end8:
	.size	l_string_substring, .Lfunc_end8-l_string_substring
	.cfi_endproc
                                        # -- End function
	.globl	l_string_parseInt       # -- Begin function l_string_parseInt
	.p2align	2
	.type	l_string_parseInt,@function
l_string_parseInt:                      # @l_string_parseInt
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	lui	a1, %hi(.L.str.2)
	addi	a1, a1, %lo(.L.str.2)
	addi	a2, sp, 8
	call	__isoc99_sscanf
	lw	a0, 8(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end9:
	.size	l_string_parseInt, .Lfunc_end9-l_string_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	l_string_ord            # -- Begin function l_string_ord
	.p2align	2
	.type	l_string_ord,@function
l_string_ord:                           # @l_string_ord
	.cfi_startproc
# %bb.0:
	add	a0, a0, a1
	lb	a0, 0(a0)
	ret
.Lfunc_end10:
	.size	l_string_ord, .Lfunc_end10-l_string_ord
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringAdd       # -- Begin function builtin_stringAdd
	.p2align	2
	.type	builtin_stringAdd,@function
builtin_stringAdd:                      # @builtin_stringAdd
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -32
	.cfi_def_cfa_offset 32
	sw	ra, 28(sp)
	sw	s0, 24(sp)
	sw	s1, 20(sp)
	sw	s2, 16(sp)
	sw	s3, 12(sp)
	.cfi_offset ra, -4
	.cfi_offset s0, -8
	.cfi_offset s1, -12
	.cfi_offset s2, -16
	.cfi_offset s3, -20
	mv	s2, a1
	mv	s3, a0
	addi	a0, zero, 1000
	mv	a1, zero
	call	malloc
	mv	s0, a0
	mv	a0, s3
	call	strlen
	mv	s1, a0
	mv	a0, s0
	mv	a1, s3
	mv	a2, s1
	call	memcpy
	add	a0, s0, s1
	sb	zero, 0(a0)
	mv	a0, s0
	mv	a1, s2
	lw	s3, 12(sp)
	lw	s2, 16(sp)
	lw	s1, 20(sp)
	lw	s0, 24(sp)
	lw	ra, 28(sp)
	addi	sp, sp, 32
	tail	strcat
.Lfunc_end11:
	.size	builtin_stringAdd, .Lfunc_end11-builtin_stringAdd
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringLT        # -- Begin function builtin_stringLT
	.p2align	2
	.type	builtin_stringLT,@function
builtin_stringLT:                       # @builtin_stringLT
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strcmp
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end12:
	.size	builtin_stringLT, .Lfunc_end12-builtin_stringLT
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringGT        # -- Begin function builtin_stringGT
	.p2align	2
	.type	builtin_stringGT,@function
builtin_stringGT:                       # @builtin_stringGT
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strcmp
	sgtz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end13:
	.size	builtin_stringGT, .Lfunc_end13-builtin_stringGT
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringLE        # -- Begin function builtin_stringLE
	.p2align	2
	.type	builtin_stringLE,@function
builtin_stringLE:                       # @builtin_stringLE
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strcmp
	slti	a0, a0, 1
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end14:
	.size	builtin_stringLE, .Lfunc_end14-builtin_stringLE
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringGE        # -- Begin function builtin_stringGE
	.p2align	2
	.type	builtin_stringGE,@function
builtin_stringGE:                       # @builtin_stringGE
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strcmp
	not	a0, a0
	srli	a0, a0, 31
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end15:
	.size	builtin_stringGE, .Lfunc_end15-builtin_stringGE
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringEQ        # -- Begin function builtin_stringEQ
	.p2align	2
	.type	builtin_stringEQ,@function
builtin_stringEQ:                       # @builtin_stringEQ
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strcmp
	seqz	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end16:
	.size	builtin_stringEQ, .Lfunc_end16-builtin_stringEQ
	.cfi_endproc
                                        # -- End function
	.globl	builtin_stringNE        # -- Begin function builtin_stringNE
	.p2align	2
	.type	builtin_stringNE,@function
builtin_stringNE:                       # @builtin_stringNE
	.cfi_startproc
# %bb.0:
	addi	sp, sp, -16
	.cfi_def_cfa_offset 16
	sw	ra, 12(sp)
	.cfi_offset ra, -4
	call	strcmp
	snez	a0, a0
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
.Lfunc_end17:
	.size	builtin_stringNE, .Lfunc_end17-builtin_stringNE
	.cfi_endproc
                                        # -- End function
	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
