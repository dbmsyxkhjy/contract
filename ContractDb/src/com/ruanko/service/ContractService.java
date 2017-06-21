package com.ruanko.service;

import java.sql.ResultSet;

import com.ruanko.dao.AdminDao;
import com.ruanko.dao.ContractDao;
import com.ruanko.dao.impl.AdminDaoImpl;
import com.ruanko.dao.impl.ContractDaoImpl;
import com.ruanko.model.Admin;
import com.ruanko.model.Contract;
import com.ruanko.utils.AppException;

public class ContractService {

private ContractDao contractDao=null;
	
	public ContractService()
	{
		contractDao=new ContractDaoImpl();
	}
	
	
	public boolean addDraft(Contract contract,String id) throws AppException
	{
		boolean flag=false;
		//处理注册业务逻辑

		//验证不存在同Id 
		if(!contractDao.IsExistContract(contract.getCid()))
		{
		   flag=contractDao.addContract(contract,id);	
		}
		//返回flag
		return flag;
	}
	
	public boolean addDraftBox(Contract contract,String id) throws AppException
	{
		boolean flag=false;
		//处理注册业务逻辑
		//验证不存在同Id 
		if(!contractDao.IsExistContract(contract.getCid()))
		{
		   flag=contractDao.addContractBox(contract,id);	
		}
		//返回flag
		return flag;
	}
	
	
	public int  NumCounterS()
	{
		int count=0;
		
		try {
			count=contractDao.NumHQList();
			System.out.println("contractService");
			System.out.println(count);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
		
		
	}
	
	public Contract[] ToHQList()
	{
		Contract contract1[];
		int count=0;
		count=NumCounterS();
		contract1=new Contract[count];
		try {
			contract1=contractDao.ToHQList();
	
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return contract1;
	}
	
	
	public boolean ConterSign(String Cid,String Aid, int suggesstion, String detail)
	{
		boolean flag=false;
		try {
			flag=contractDao.CounterSign(Cid, Aid, suggesstion, detail);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean signContract(String cid,String aid,String message) throws AppException
	{
		boolean yes = false;
		
		try{ 
			yes = contractDao.signContract(cid,aid, message);
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("啊哦，sorry，签订系统出错！");
		}
		
		return yes;
	}
	
	public boolean alterContract(String cid,String aid,String message) throws AppException
	{
		boolean yes = false;
		
		try{
			yes = contractDao.alterContract(cid, aid,message);
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("啊哦，sorry，系统出错！");
		}
		
		return yes;
	}
	
	public boolean deniedContract(String cid,String aid,String message) throws AppException
	{
		boolean yes = false;
		
		try{
			yes = contractDao.deniedContract(cid,aid,message);
		}catch(AppException e){
			e.printStackTrace();
			throw new AppException("啊哦，sorry，系统出错！");
		}
		
		return yes;
	}


	public boolean ModifyReject(String content,String cid)
	{
		boolean flag=false;
		flag=contractDao.modifyReject(content, cid);
		return flag;
	}
	
    
	public boolean addBox(Contract contract) throws AppException
	{
		return contractDao.addBox(contract);
	}
	
	public ResultSet search(String detail)
	{
		ResultSet rs=null;
		rs=contractDao.Search(detail);
		
		return rs;
	}

	
}
