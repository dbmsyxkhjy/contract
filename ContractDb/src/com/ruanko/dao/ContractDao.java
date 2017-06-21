package com.ruanko.dao;

import java.sql.ResultSet;

import com.ruanko.model.Contract;
import com.ruanko.utils.AppException;

public interface ContractDao {
	
	public boolean IsExistContract(String Id) throws AppException;
	
	public boolean addContract(Contract contract,String id) throws AppException;
	
	public boolean addContractBox(Contract contract,String id) throws AppException;
	
	public int NumHQList() throws AppException;
	
	public Contract[] ToHQList() throws AppException;
	
	public boolean CounterSign(String cid,String aid,int suggesstion,String detail) throws AppException;

	public boolean modifyReject(String content,String cid);
	
    public ResultSet getContractDetail(String cid) throws AppException;
	
	public boolean signContract(String cid,String aid,String message) throws AppException;
	
	public boolean alterContract(String cid,String aid,String message) throws AppException;
	
	public boolean deniedContract(String cid,String aid,String message) throws AppException;

	public ResultSet detail(String cid);
	
	public boolean addBox(Contract contract);
	
	public ResultSet Search(String detail);

}
