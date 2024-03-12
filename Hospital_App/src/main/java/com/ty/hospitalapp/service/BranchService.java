
package com.ty.hospitalapp.service;

import java.util.List;

import com.ty.hospitalapp.dao.imp.AddressDaoImp;
import com.ty.hospitalapp.dao.imp.BranchDaoImp;
import com.ty.hospitalapp.dao.imp.HospitalDaoImp;
import com.ty.hospitalapp.dto.Address;
import com.ty.hospitalapp.dto.Branch;
import com.ty.hospitalapp.dto.Hospital;

public class BranchService {
	public void saveBranch(int hid, Branch branch) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch1=branchDaoImp.saveBranch(hid, branch);
		if(branch1!=null)
		{
			System.out.println("Data saved");
	}
	else
	{
		System.out.println("Sorry data not saved");
		
	}
		
	}
	
public Branch getBranchById(int bid) {
		BranchDaoImp branchDaoImp=new BranchDaoImp();
		Branch branch1=branchDaoImp.getBranchById(bid);
		if(branch1!=null)
		{
		return branch1;
	}
		else
		{
			return null;
		}
		
	}
	
public void deleteBranchById(int bid) {
	BranchDaoImp branchDaoImp=new BranchDaoImp();
	boolean flag=branchDaoImp.deleteBranchById(bid);
	if(flag)
	{
		System.out.println("Data deleted");
	}
	else
	{
		System.out.println("data not deleted");
	}
	
}

public Branch updateBranchById(int bid) {
	BranchDaoImp branchDaoImp=new BranchDaoImp();
	Branch branch1=branchDaoImp.getBranchById(bid);
	if(branch1!=null)
	{
		return branch1;
	}
	else
	{
		return null;
	}
 }

public List<Branch> getAllBranch() {
	BranchDaoImp branchDaoImp=new BranchDaoImp();
	List<Branch> branches=branchDaoImp.getAllBranch();
	if(branches!=null)
	{
	return branches;
}
	else
	{
		return null;
	}
}
}
	