package com.ruanko.dao.impl;

import java.applet.Applet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ruanko.dao.ContractDao;
import com.ruanko.model.Contract;
import com.ruanko.model.User;
import com.ruanko.utils.AppException;
import com.ruanko.utils.DBUtil;

public class ContractDaoImpl extends Applet implements ContractDao{

	
	public boolean IsExistContract(String Id) throws AppException {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;

		boolean flag=false;
		try
		 {
			 conn=DBUtil.getConnection();
			 String sql="select ctitle,state from contract where cid=?";
			 psmt=conn.prepareStatement(sql);
			 psmt.setString(1, Id);
			
			 rs=psmt.executeQuery();
			 if(rs.next())
			 {
				 int state = rs.getInt("state");
				 if(state == 0)
				 {
					sql="delete from contract where cid=?"; 
					psmt=conn.prepareStatement(sql);
					psmt.setString(1, Id);
					psmt.executeUpdate();
					flag = false;
				 }
				 else 
				    flag=true;
			 }
			 
			 System.out.println(Id);
		 }
		catch(SQLException e)
		{
			e.printStackTrace();
			throw new AppException("com.ruanko.dao.model.impl.AdminDaoImpl.isExistAdmin");
		}finally
		{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}
		 return flag;
	}
	
	public boolean addContract(Contract contract,String id) throws AppException {
		
				//用来计数level为2的管理员的个数
				int count=0;
				//将传进来的id转化为String类型
				
				//声明操作标志 flag
				boolean flag=false;
				//定义数据库操作对象
				Connection conn=null;
				PreparedStatement psmt=null;
				
				Connection conn1=null;
				PreparedStatement psmt1=null;
				
				Connection conn2=null;
				PreparedStatement psmt2=null;
				ResultSet rs2=null;
				
				Connection conn3=null;
				PreparedStatement psmt3=null;
				ResultSet rs3=null;
				
				
				
				//用来存level为2的管理员id
			    String[] aidNum;
			    //用来存插入到ca表的SQL语句集
			    String Sql[];
			    //用来存插入ca操作的数据库处理集
			    Connection Conn[];
				PreparedStatement Psmt[];
				//用来存储结果集
				int Result[];
				//用来检测是否向ca插入成功
				int resultSet=-1;
		
				
				try {
					//创建数据库链接
					conn=DBUtil.getConnection();
					
					String sql="insert into contract(cid,ctitle,ccontent,cstarttime,cendtime,state)"
							+ "values(?,?,?,?,?,2)";
					
					//预处理SQL语句
					psmt=conn.prepareStatement(sql);
					
					//设置参数
					
					psmt.setString(1, contract.getCid());
					psmt.setString(2,contract.getCtitle());
					psmt.setString(3,contract.getContent());
					psmt.setString(4,contract.getCstarttime());
					psmt.setString(5,contract.getCendtime());
					
					

					//操作新增操作
					int result=-1;
					result=psmt.executeUpdate();
					//处理结果

					
					conn1=DBUtil.getConnection();
					
					String sql1="insert into cu(cid,uid)"+ "values(?,?)";
					//预处理SQL语句
					psmt1=conn1.prepareStatement(sql1);
					
					//设置参数
					
					psmt1.setString(1, contract.getCid());
					psmt1.setString(2, id);
					
					int result1=-1;
					result1=psmt1.executeUpdate();
					//先求出level为2的全部
					
					conn2=DBUtil.getConnection();
					
					String sql2="select count(aid) from admin where level=2 ";
					
					//预处理SQL语句
					psmt2=conn2.prepareStatement(sql2);
					
					//设置参数
					
					rs2=psmt2.executeQuery();
					if(rs2.next())
					{
						count=rs2.getInt("count(aid)");
						System.out.println(count);
					}
					
					aidNum=new String[count];
					
					if(count>0)
					{
						conn3=DBUtil.getConnection();
						
						String sql3="select aid from admin where level=2 ";
						
						//预处理SQL语句
						psmt3=conn3.prepareStatement(sql3);
						
						//设置参数
						int j=0;
						rs3=psmt3.executeQuery();
						System.out.println("qqqqqqq");
						
						while(rs3.next())
						{
							aidNum[j]=rs3.getString("aid");
							System.out.println(aidNum[j]);
							j++;
						}
						
						//初始化各种数组
						Sql=new String [count];
						Conn= new Connection[count];
						Psmt= new PreparedStatement[count];
						Result= new int[count];
						//执行向ca 中插入数据
					
						for(int i=0;i<count;i++)
						{
							Conn[i]=DBUtil.getConnection();
							
							Sql[i]="insert into ca(cid,aid,suggestion,detail)"+ "values(?,?,?,?)";
							//预处理SQL语句
							Psmt[i]=Conn[i].prepareStatement(Sql[i]);
							
							//设置参数
							
							Psmt[i].setString(1, contract.getCid());
							Psmt[i].setString(2, aidNum[i]);
							Psmt[i].setInt(3, -1);
							Psmt[i].setString(4,"未审批状态，无意见");
							
							Result[i]=-1;
							Result[i]=Psmt[i].executeUpdate();
						}
						
						int k=0;
						for(int i=0;i<count;i++)
						{
							if(Result[i]>0)
							{
								k++;
							}
						}
						
						if(k==count)
						{
							resultSet=1;
						}
					}
					
					
					
					else
					{
						//给管理员分配  或者是在程序一开始起草之前就检查是偶每个级别的人都有
					}
					
					
					//处理结果
					if(result1>0&&result>0&&resultSet>0)
					{
						flag=true;
					}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					//关闭链接，释放资源
					
					DBUtil.closeStatement(psmt);
					DBUtil.closeConnection(conn);
					
					DBUtil.closeStatement(psmt1);
					DBUtil.closeConnection(conn1);
					
					DBUtil.closeResultSet(rs2);
					DBUtil.closeStatement(psmt2);
					DBUtil.closeConnection(conn2);
					
					DBUtil.closeResultSet(rs3);
					DBUtil.closeStatement(psmt3);
					DBUtil.closeConnection(conn3);
					
				}
	
				//返回结果
				return flag;
	 }

	public boolean addContractBox(Contract contract,String id) throws AppException {
		//声明操作标志 flag
		boolean flag=false;
		//定义数据库操作对象
		Connection conn=null;
		PreparedStatement psmt=null;
		Connection conn1=null;
		PreparedStatement psmt1=null;
		try {
			//创建数据库链接
			conn=DBUtil.getConnection();
			String sql="insert into contract(cid,ctitle,ccontent,cstarttime,cendtime,state)"
					+ "values(?,?,?,?,?,0)";
			
			//预处理SQL语句
			psmt=conn.prepareStatement(sql);
			//设置参数
			psmt.setString(1, contract.getCid());
			psmt.setString(2,contract.getCtitle());
			psmt.setString(3,contract.getContent());
			psmt.setString(4,contract.getCstarttime());
			psmt.setString(5,contract.getCendtime());
			//操作新增操作
			int result=psmt.executeUpdate();
			
			conn1=DBUtil.getConnection();
			String sql1="insert into cu(cid,uid)"+ "values(?,?)";
			//预处理SQL语句
			psmt1=conn1.prepareStatement(sql1);
			//设置参数
			psmt1.setString(1, contract.getCid());
			psmt1.setString(2, id);
			int result1=psmt1.executeUpdate();	
			
			if(result>0 && result1>0)
				flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//关闭链接，释放资源
			
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
			
			DBUtil.closeStatement(psmt1);
			DBUtil.closeConnection(conn1);
			
		}
		//返回结果
		return flag;
}
	
	//待会签合同的数量
	public int NumHQList() throws AppException {
		
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		Connection conn1=null;
		PreparedStatement psmt1=null;
		ResultSet rs1=null;
		
		String Tolist[] = null;
		int count=0;
		
		try{
		conn=DBUtil.getConnection();
		String sql="select count(cid) from contract where state=2";
		psmt=conn.prepareStatement(sql);
		
		 rs=psmt.executeQuery();
		 if(rs.next())
		 {
			count=rs.getInt("count(cid)");
			//System.out.println("wahaha");
			//System.out.println(count);
		 
		 }
		 
		}
		 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			//关闭链接，释放资源
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
			
			DBUtil.closeResultSet(rs1);
			DBUtil.closeStatement(psmt1);
			DBUtil.closeConnection(conn1);
		}
		return count;
	}

    //将待会签合同的信息返回
	public Contract[] ToHQList() throws AppException {
		Contract contract[];
		int i=0;
		int count=NumHQList();
		
		System.out.println("wahaha");
		System.out.println(count);
		
		contract=new Contract[count];
		
		for(int j=0;j<count;j++)
		{
			contract[j]=new Contract();
		}

		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		Connection conn1=null;
		PreparedStatement psmt1=null;
		ResultSet rs1=null;
		
		Connection conn2=null;
		PreparedStatement psmt2=null;
		ResultSet rs2=null;
		
		Connection conn3=null;
		PreparedStatement psmt3=null;
		ResultSet rs3=null;
		
		Connection conn4=null;
		PreparedStatement psmt4=null;
		ResultSet rs4=null;
			
		
		
		
		try {
			conn=DBUtil.getConnection();
			String sql="select cid from contract where state=2";
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			
			while(rs.next())
			{
				String s=rs.getString("cid");
				System.out.println("呦呦切克闹");
				contract[i].setCid(s);
		
				i++;
			}
			
			i=0;
			
			conn1=DBUtil.getConnection();
			String sql1="select ctitle from contract where state=2";
			psmt1=conn1.prepareStatement(sql1);
			rs1=psmt1.executeQuery();
			
			while(rs1.next())
			{
				contract[i].setCtitle(rs1.getString("ctitle"));
				i++;
			}
				
			i=0;
			
			conn2=DBUtil.getConnection();
			String sql2="select ccontent from contract where state=2";
			psmt2=conn2.prepareStatement(sql2);
			rs2=psmt2.executeQuery();
			
			while(rs2.next())
			{
				contract[i].setContent(rs2.getString("ccontent"));
				i++;
			
			}
			
			i=0;
			
			
			conn3=DBUtil.getConnection();
			String sql3="select cstarttime from contract where state=2";
			psmt3=conn3.prepareStatement(sql3);	
			rs3=psmt3.executeQuery();	
			
			while(rs3.next())
			{
				contract[i].setCstarttime(rs3.getString("cstarttime"));
				i++;
			}
			i=0;
			
			conn4=DBUtil.getConnection();
			String sql4="select cendtime from contract where state=2";
			psmt4=conn4.prepareStatement(sql4);	
			rs4=psmt4.executeQuery();	
			
			while(rs4.next())
			{
				contract[i].setCendtime(rs4.getString("cendtime"));
				i++;
			}
			i=0;
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.closeResultSet(rs);
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
			
			DBUtil.closeResultSet(rs1);
			DBUtil.closeStatement(psmt1);
			DBUtil.closeConnection(conn1);
			
			
			DBUtil.closeResultSet(rs2);
			DBUtil.closeStatement(psmt2);
			DBUtil.closeConnection(conn2);
			
			DBUtil.closeResultSet(rs3);
			DBUtil.closeStatement(psmt3);
			DBUtil.closeConnection(conn3);
			
			DBUtil.closeResultSet(rs4);
			DBUtil.closeStatement(psmt4);
			DBUtil.closeConnection(conn4);
		}
		return contract;
	}

    //正式会签合同 
	public boolean CounterSign(String Cid,String Aid, int suggesstion, String Detail)
			throws AppException {
		
		boolean flag=false;
		int count=NumHQList();
		// int Cid=Integer.parseInt(Cid);
		// count（aid）from ca suggestion=-1 
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		int aidNum=0;
		
		try {
			conn=DBUtil.getConnection();
			String sql="select count(aid) from ca where suggestion = -1 and cid=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, Cid);
			rs=psmt.executeQuery();
			if(rs.next())
			{
				aidNum=rs.getInt("count(aid)");
			}
			System.out.println("你妹！");
			System.out.println(aidNum);
			
			Connection conn5=null;
			PreparedStatement psmt5=null;
			ResultSet rs5=null;
			
			conn5=DBUtil.getConnection();
			String sql5="select count(aid) from admin where level=2";
			psmt5=conn5.prepareStatement(sql5);
			rs5=psmt5.executeQuery();
			int num=0;
			if(rs5.next())
			{
				num=rs5.getInt("count(aid)");
			}
			
			
	      if(num>1)
	      {
			// if aidNum=1 then and suggestion=0 then set state=1;并插入detail，suggesstion	
			if(aidNum==1&&suggesstion==0)
			{
				//将admin的suggestion以及detail改变
				Connection conn1=null;
				PreparedStatement psmt1=null;
				int result1=-1;
				
				Connection conn2=null;
				PreparedStatement psmt2=null;
				int result2=-1;
				
				Connection conn3=null;
				PreparedStatement psmt3=null;
				int result3=-1;
				
				
				conn1=DBUtil.getConnection();
				String sql1="update ca set suggestion=? where cid=? and aid=?";
				psmt1=conn1.prepareStatement(sql1);
				psmt1.setInt(1, suggesstion);
				psmt1.setString(2, Cid);
				psmt1.setString(3, Aid);
				result1=psmt1.executeUpdate();
				
				DBUtil.closeStatement(psmt1);
				DBUtil.closeConnection(conn1);
				
				conn2=DBUtil.getConnection();
				String sql2="update ca set detail=? where cid=? and aid=?";
				psmt2=conn2.prepareStatement(sql2);
				psmt2.setString(1, Detail);
				psmt2.setString(2, Cid);
				psmt2.setString(3, Aid);
				result2=psmt2.executeUpdate();
				
				DBUtil.closeStatement(psmt2);
				DBUtil.closeConnection(conn2);
				
				conn3=DBUtil.getConnection();
				String sql3="update contract set state=1 where cid=?";
				psmt3=conn3.prepareStatement(sql3);
				psmt3.setString(1, Cid);
				result3=psmt3.executeUpdate();
				
				DBUtil.closeStatement(psmt3);
				DBUtil.closeConnection(conn3);
				
				if(result2>0 && result1>0 && result3>0)
				{
					flag=true;
					System.out.println("输出我就对了");
				}
			
				
			}
			
		//  if count=1  and suggestion =1 then  Aidnum=count(aid) where suggestion=1
			// if Aidnum= select from admin level=2 then state=3;
			//if  Aidnum<select from admin level=2 then state=1;
			else if(aidNum==1&&suggesstion==1)
			{
				Connection conn4=null;
				PreparedStatement psmt4=null;
				ResultSet rs4=null;
				
				//update ca suggestion!!!!!!
				Connection conn9=null;
				PreparedStatement psmt9=null;
				int result9=-1;
				
				conn9=DBUtil.getConnection();
				String sql9="update ca set suggestion=? where cid=? and aid=?";
				psmt9=conn9.prepareStatement(sql9);
				psmt9.setInt(1, suggesstion);
				psmt9.setString(2, Cid);
				psmt9.setString(3, Aid);
				result9=psmt9.executeUpdate();
				
				Connection conn8=null;
				PreparedStatement psmt8=null;
				int result8=-1;
				conn8=DBUtil.getConnection();
				String sql8="update ca set detail=? where cid=? and aid=?";
				psmt8=conn8.prepareStatement(sql8);
				psmt8.setString(1, Detail);
				psmt8.setString(2, Cid);
				psmt8.setString(3, Aid);
				result8=psmt8.executeUpdate();
				
				conn4=DBUtil.getConnection();
				String sql4="select count(aid) from ca where suggestion = 1 and cid=?";
				psmt4=conn4.prepareStatement(sql4);
				psmt4.setString(1, Cid);
				rs4=psmt4.executeQuery();
				int Aidnum=0;
				if(rs4.next())
				{
					Aidnum=rs4.getInt("count(aid)");
				}
				
				if(Aidnum==num)
				{
					//state=3;
					Connection conn6=null;
					PreparedStatement psmt6=null;
					int result6=-1;
					
					conn6=DBUtil.getConnection();
					String sql6="update contract set state=3 where cid=? ";
					psmt6=conn6.prepareStatement(sql6);
					psmt6.setString(1, Cid);
					result6=psmt6.executeUpdate();
					
					if(result6>0)
					{
						
					}
					
				}
				else
				{
					//state=1;
					
					Connection conn7=null;
					PreparedStatement psmt7=null;
					int result7=-1;
					
					conn7=DBUtil.getConnection();
					String sql7="update contract set state=1 where cid=? ";
					psmt7=conn7.prepareStatement(sql7);
					psmt7.setString(1, Cid);
					result7=psmt7.executeUpdate();
					
					if(result7>0)
					{
						
					}
				}	
			}
			//if aidNum>1 then update
			else if(aidNum>1)
			{
				
				
				Connection conn10=null;
				PreparedStatement psmt10=null;
				int result10=-1;
				
				conn10=DBUtil.getConnection();
				String sql10="update ca set suggestion=? where cid=? and aid=?";
				psmt10=conn10.prepareStatement(sql10);
				psmt10.setInt(1, suggesstion);
				psmt10.setString(2, Cid);
				psmt10.setString(3, Aid);
				result10=psmt10.executeUpdate();
				
				
				Connection conn11=null;
				PreparedStatement psmt11=null;
				int result11=-1;
				conn11=DBUtil.getConnection();
				String sql11="update ca set detail=? where cid=? and aid=?";
				psmt11=conn11.prepareStatement(sql11);
				psmt11.setString(1, Detail);
				psmt11.setString(2, Cid);
				psmt11.setString(3, Aid);
				result11=psmt11.executeUpdate();

			}
			
}
			//num==1
			else if(num==1)
			{
				//直接更新Contract表和ca表
				if(suggesstion==1)
				{
					Connection conn12=null;
					PreparedStatement psmt12=null;
					int result12=-1;
					
					conn12=DBUtil.getConnection();
					String sql12="update ca set suggestion=? where cid=? and aid=?";
					psmt12=conn12.prepareStatement(sql12);
					psmt12.setInt(1, suggesstion);
					psmt12.setString(2, Cid);
					psmt12.setString(3, Aid);
					result12=psmt12.executeUpdate();
					
					Connection conn13=null;
					PreparedStatement psmt13=null;
					int result13=-1;
					conn13=DBUtil.getConnection();
					String sql13="update ca set detail=? where cid=? and aid=?";
					psmt13=conn13.prepareStatement(sql13);
					psmt13.setString(1, Detail);
					psmt13.setString(2, Cid);
					psmt13.setString(3, Aid);
					result13=psmt13.executeUpdate();
					
					Connection conn14=null;
					PreparedStatement psmt14=null;
					int result14=-1;
					
					conn14=DBUtil.getConnection();
					String sql14="update contract set state=3 where cid=? ";
					psmt14=conn14.prepareStatement(sql14);
					psmt14.setString(1, Cid);
					result14=psmt14.executeUpdate();
					System.out.println("应该输出我");
					if(result14>0)
					{
						
					}
				}
				
				else
				{
					Connection conn15=null;
					PreparedStatement psmt15=null;
					int result15=-1;
					
					conn15=DBUtil.getConnection();
					String sql15="update ca set suggestion=? where cid=? and aid=?";
					psmt15=conn15.prepareStatement(sql15);
					psmt15.setInt(1, suggesstion);
					psmt15.setString(2, Cid);
					psmt15.setString(3, Aid);
					result15=psmt15.executeUpdate();
					
					Connection conn16=null;
					PreparedStatement psmt16=null;
					int result16=-1;
					conn16=DBUtil.getConnection();
					String sql16="update ca set detail=? where cid=? and aid=?";
					psmt16=conn16.prepareStatement(sql16);
					psmt16.setString(1, Detail);
					psmt16.setString(2, Cid);
					psmt16.setString(3, Aid);
					result16=psmt16.executeUpdate();
					
					Connection conn17=null;
					PreparedStatement psmt17=null;
					int result17=-1;
					
					conn17=DBUtil.getConnection();
					String sql17="update contract set state=1 where cid=? ";
					psmt17=conn17.prepareStatement(sql17);
					psmt17.setString(1, Cid);
					result17=psmt17.executeUpdate();
					System.out.println("不应该输出我");
					if(result17>0)
					{
						
					}
				}
			}
			//num==0
			else
			{
				//系统管理员分配权限
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		   return flag;
		
	}

	public boolean modifyReject(String content, String Cid) {
		
		
		boolean flag=false;
		
		Connection conn=null;
		PreparedStatement psmt=null;
		int result=-1;
	
		
		Connection conn1=null;
		PreparedStatement psmt1=null;
		int result1=-1;
		
		Connection conn2=null;
		PreparedStatement psmt2=null;
		ResultSet rs2=null;
		
		try {
			//按照修改意见进行修改
			conn=DBUtil.getConnection();
			String sql="update contract set ccontent=? where cid=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setString(2, Cid);
			result=psmt.executeUpdate();
			
			//将合同状态改为2
			conn1=DBUtil.getConnection();
			String sql1="update contract set state=2 where cid=?";
			psmt1=conn1.prepareStatement(sql1);
			psmt1.setString(1, Cid);
			result1=psmt1.executeUpdate();
			
			
			int aidNo=0;
			//将各位level为2的admin的意见改为-1
			
			//先得到level为2的管理员的个数
			conn2=DBUtil.getConnection();
			String sql2="select count(aid) from admin where level=2";
			psmt2=conn2.prepareStatement(sql2);
			rs2=psmt2.executeQuery();
			if(rs2.next())
			{
				 aidNo=rs2.getInt("count(aid)");
			}
			
			
			
			//将所有level为2 的admin的aid存起来
			String aidNum[];
			 
			 aidNum=new String[aidNo];
			 Connection conn3=null;
			 PreparedStatement psmt3=null;
			 ResultSet rs3=null;
			 
			 
				
			if(aidNo>0)
			{
				conn3=DBUtil.getConnection();
					
				String sql3="select aid from admin where level=2 ";
					
				//预处理SQL语句
				psmt3=conn3.prepareStatement(sql3);
					
				//设置参数
				int j=0;
				rs3=psmt3.executeQuery();
					
				while(rs3.next())
				{
					aidNum[j]=rs3.getString("aid");
					j++;
				}
			}			
					
			 //用来存插入到ca表的SQL语句集
			 String Sql[];
			 //用来存插入ca操作的数据库处理集
			 Connection Conn[];
			 PreparedStatement Psmt[];
			//用来存储结果集
			 int Result[];
			 
			Sql=new String [aidNo];
			Conn= new Connection[aidNo];
			Psmt= new PreparedStatement[aidNo];
			Result= new int[aidNo];
			
			
			
			for(int k=0;k<aidNo;k++)
			{
				Conn[k]=DBUtil.getConnection();
				Sql[k]="update ca set suggestion=-1,detail=? where cid=? and aid=?";
				Psmt[k]=Conn[k].prepareStatement(Sql[k]);
				Psmt[k].setString(1, "未审核，无意见");
				Psmt[k].setString(2, Cid);
				Psmt[k].setString(3, aidNum[k]);
				Result[k]=Psmt[k].executeUpdate();
				
				
				
				Result[k]=Psmt[k].executeUpdate();
				
				
			}
			
			int allResult=-1;
			int result3=-1;
			int m=0;
			for(int i=0;i<aidNo;i++)
			{
				if(Result[i]>0)
				{
 				}
			}
			
			if(m==aidNo)
			{
				result3=1;
			}
			
			if(result>0&&result1>0&&rs2.next()&&rs3.next()&&result3>0)
			{
				flag=true;
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return flag;
	}
	
	/*通过合同编号获取合同详细内容*/
	public ResultSet getContractDetail(String belongTo) throws AppException
	{
		if(belongTo == null || belongTo.equals(""))
		{
			return null;
		}	
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state,uid from contract,cu where contract.cid = ? and contract.cid = cu.cid";
	
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			smt.setString(1, belongTo);
			res = smt.executeQuery();
			return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}

	/*获取状态为保存草稿的合同*/
	public ResultSet getContractLevel0(String uid) throws AppException
	{
		
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,cu where state = 0 and contract.cid = cu.cid and uid = '"+uid+"'";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			
		    return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	/*获取状态为被驳回的合同*/
	public ResultSet getContractLevel1(String uid) throws AppException
	{
		
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,cu where state = 1 and contract.cid = cu.cid and uid = '"+uid+"'";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			
		    return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	/*获取全部状态为被驳回的合同*/
	public ResultSet getContractLevel1ToAdmin() throws AppException
	{
		
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,cu where state = 1 and contract.cid = cu.cid";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			
		    return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	/*获取状态为初审的合同*/
	public ResultSet getContractLevel2() throws AppException
	{
		String query = "select cid,ctitle,ccontent,cstarttime,cendtime,state from contract where state = 2";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	/*获取状态为初审的合同*/
	public ResultSet getContractLevel2ToUser(String uid) throws AppException
	{
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,cu where state = 2 and contract.cid = cu.cid and uid = '"+uid+"'";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}

	/*获取状态为boss审的合同*/
	public ResultSet getContractLevel3(String uid) throws AppException
	{
		//String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,ca where state = 3 and contract.cid = ca.cid and uid = '"+uid+"'";
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract where state = 3";
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
		    return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	/*获取全部状态为boss审的合同*/
	public ResultSet getContractLevel3ToAdmin() throws AppException
	{
		//String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,ca where state = 3 and contract.cid = ca.cid and uid = '"+uid+"'";
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract where state = 3";
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
		    return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	public ResultSet getContractLevel4(String uid) throws AppException
	{
		
		String query = "select contract.cid,ctitle,ccontent,cstarttime,cendtime,state from contract,cu where state = 4 and contract.cid = cu.cid and uid = '"+uid+"'";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
		    return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	/*获取已经签订完成的合同*/
	public ResultSet getContractLevel5() throws AppException
	{
		String query = "select cid,ctitle,ccontent,cstarttime,cendtime,state from contract where state = 5";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
	public ResultSet getContractDenied() throws AppException
	{
		String query = "select cid,ctitle,ccontent,cstarttime,cendtime,state from contract where state = -1";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			res = smt.executeQuery();
			return res;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
	}
	
    /*签订合同*/
	public boolean signContract(String cid,String aid,String message) throws AppException
	{
		//ca表中是否存在该合同的审批记录
		boolean isExist = isExistInCa(cid);

		User user = new User();
		
		String update = "update contract set state = 5 where cid = '"+ cid+"'";
		String delete = "delete from ca where cid = '"+cid+"'";
		String insert = "insert into ca values('"+cid + "','"+aid+"',1,'"+message+"')";

		Connection conn = DBUtil.getConnection();
		Statement psmt = null;
		
		try {
			psmt = conn.createStatement();
		    psmt.addBatch(update);
		    if(isExist)      //如果之前合同有驳回过，那ca表中会有记录，先删除旧记录，再插入新纪录
		    	psmt.addBatch(delete);
		    psmt.addBatch(insert);
		    psmt.executeBatch();
		    return true;
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*boss拒签合同且将合同作废*/
	public boolean deniedContract(String cid,String aid,String message) throws AppException
	{
		//ca表中是否存在该合同的审批记录
		boolean isExist = isExistInCa(cid);

		
		String update = "update contract set state = -1 where cid = '"+ cid+"'";
		String delete = "delete from ca where cid = '"+cid+"'";
		String insert = "insert into ca values('"+cid + "','"+aid+"',0,'"+message+"')";

		Connection conn = DBUtil.getConnection();
		Statement psmt = null;
				
		try {
			psmt = conn.createStatement();
		    psmt.addBatch(update);
		    if(isExist)      //如果之前合同有驳回过，那ca表中会有记录，先删除旧记录，再插入新纪录
				psmt.addBatch(delete);
			    psmt.addBatch(insert);
			    psmt.executeBatch();
			    return true;
					
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
				
		return false;
	}
	
	/*boss驳回合同让用户重新修改*/
	public boolean alterContract(String cid,String aid,String message) throws AppException
	{
		//ca表中是否存在该合同的审批记录
		boolean isExist = isExistInCa(cid);

				
		String update = "update contract set state = 1 where cid = '"+ cid +"'";
		String delete = "delete from ca where cid = '"+cid+"'";
		String insert = "insert into ca values('"+cid + "','"+aid+"',0,'"+message+",";

		Connection conn = DBUtil.getConnection();
		Statement psmt = null;
				
		try {
			psmt = conn.createStatement();
		    psmt.addBatch(update);
		    if(isExist)      //如果之前合同有驳回过，那ca表中会有记录，先删除旧记录，再插入新纪录
			   psmt.addBatch(delete);
			   psmt.addBatch(insert);
			   psmt.executeBatch();
			   return true;
					
		} catch (SQLException e) {
					// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
				
		return false;
	}
	
	/*查询ca表中是否存在boss之前对合同的审查记录*/
	public boolean isExistInCa(String cid) throws AppException{
		String query = "select * from ca where cid = ?";
		
		ResultSet res = null;
		Connection conn = DBUtil.getConnection();
		PreparedStatement smt = null;
		
		try{
			smt = conn.prepareStatement(query);
			smt.setString(1, cid);
			res = smt.executeQuery();
			if(res.next())
				return true;
		}catch(SQLException e){
			e.printStackTrace();
			throw new AppException("com.ruanko.Dao.impl.UserDaoImpl.getContractDetail");
		}
		
		return false;
	}
	
	public ResultSet detail(String Cid) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.getConnection();
			String sql = "select aid,suggestion,detail from ca where cid=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, Cid);
			rs = psmt.executeQuery();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			return rs;
	}
    
	/*
	 *将正在起草的合同加入草稿箱 
	 */
	public boolean addBox(Contract contract){
		Connection conn = null;
		PreparedStatement psmt=null;
		
		try{
			conn = DBUtil.getConnection();
			String sql="insert into contract values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, contract.getCid());
			psmt.setString(2,contract.getCtitle());
			psmt.setString(3, contract.getContent());
			psmt.setString(4, contract.getCstarttime());
			psmt.setString(5,contract.getCendtime());
			psmt.setInt(6, contract.getState());
			
			int result = psmt.executeUpdate();
			
			if(result > 0)
			{
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		return false;
	}

    /*
     * 删除草稿
     */
	public boolean deleteBox(String cid){
		Connection conn = null;
		PreparedStatement psmt=null;
		
		try{
			conn = DBUtil.getConnection();
			String sql="delete from contract where cid = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, cid);
			int result = psmt.executeUpdate();
			if(result > 0)
			{
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * 搜索（非 Javadoc）
	 * @see com.ruanko.dao.ContractDao#Search(java.lang.String)
	 */
	public ResultSet Search(String detail) {
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;

			boolean flag=false;
			String search=null;
			search="%"+detail+"%";
			
				 try {
					 conn=DBUtil.getConnection();
					 String sql="select * from contract where ctitle like ?";
					 psmt=conn.prepareStatement(sql);
					 psmt.setString(1, search);
					 rs=psmt.executeQuery();
		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return rs;
		}
		


}
	
