package com.ty.hospitalapp.controller;


import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.service.BranchService;

public class TestSavebranch {
public static void main(String[] args) {
	Branch branch= new Branch();
	BranchService branchService= new BranchService();
	branch.setName("MG Road");
	branch.setEmail("emc@gmail.com");
	branch.setPhno(9876543210l);
	
	branchService.saveBranch(3, branch);
	
}
}
