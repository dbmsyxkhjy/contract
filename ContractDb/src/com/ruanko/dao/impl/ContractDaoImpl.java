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
		
				//��������levelΪ2�Ĺ���Ա�ĸ���
				int count=0;
				//����������idת��ΪString����
				
				//����������־ flag
				boolean flag=false;
				//�������ݿ��������
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
				
				
				
				//������levelΪ2�Ĺ���Աid
			    String[] aidNum;
			    //��������뵽ca���SQL��伯
			    String Sql[];
			    //���������ca���������ݿ⴦��
			    Connection Conn[];
				PreparedStatement Psmt[];
				//�����洢�����
				int Result[];
				//��������Ƿ���ca����ɹ�
				int resultSet=-1;
		
				
				try {
					//�������ݿ�����
					conn=DBUtil.getConnection();
					
					String sql="insert into contract(cid,ctitle,ccontent,cstarttime,cendtime,state)"
							+ "values(?,?,?,?,?,2)";
					
					//Ԥ����SQL���
					psmt=conn.prepareStatement(sql);
					
					//���ò���
					
					psmt.setString(1, contract.getCid());
					psmt.setString(2,contract.getCtitle());
					psmt.setString(3,contract.getContent());
					psmt.setString(4,contract.getCstarttime());
					psmt.setString(5,contract.getCendtime());
					
					

					//������������
					int result=-1;
					result=psmt.executeUpdate();
					//������

					
					conn1=DBUtil.getConnection();
					
					String sql1="insert into cu(cid,uid)"+ "values(?,?)";
					//Ԥ����SQL���
					psmt1=conn1.prepareStatement(sql1);
					
					//���ò���
					
					psmt1.setString(1, contract.getCid());
					psmt1.setString(2, id);
					
					int result1=-1;
					result1=psmt1.executeUpdate();
					//�����levelΪ2��ȫ��
					
					conn2=DBUtil.getConnection();
					
					String sql2="select count(aid) from admin where level=2 ";
					
					//Ԥ����SQL���
					psmt2=conn2.prepareStatement(sql2);
					
					//���ò���
					
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
						
						//Ԥ����SQL���
						psmt3=conn3.prepareStatement(sql3);
						
						//���ò���
						int j=0;
						rs3=psmt3.executeQuery();
						System.out.println("qqqqqqq");
						
						while(rs3.next())
						{
							aidNum[j]=rs3.getString("aid");
							System.out.println(aidNum[j]);
							j++;
						}
						
						//��ʼ����������
						Sql=new String [count];
						Conn= new Connection[count];
						Psmt= new PreparedStatement[count];
						Result= new int[count];
						//ִ����ca �в�������
					
						for(int i=0;i<count;i++)
						{
							Conn[i]=DBUtil.getConnection();
							
							Sql[i]="insert into ca(cid,aid,suggestion,detail)"+ "values(?,?,?,?)";
							//Ԥ����SQL���
							Psmt[i]=Conn[i].prepareStatement(Sql[i]);
							
							//���ò���
							
							Psmt[i].setString(1, contract.getCid());
							Psmt[i].setString(2, aidNum[i]);
							Psmt[i].setInt(3, -1);
							Psmt[i].setString(4,"δ����״̬�������");
							
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
						//������Ա����  �������ڳ���һ��ʼ���֮ǰ�ͼ����żÿ��������˶���
					}
					
					
					//������
					if(result1>0&&result>0&&resultSet>0)
					{
						flag=true;
					}
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					//�ر����ӣ��ͷ���Դ
					
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
	
				//���ؽ��
				return flag;
	 }

	public boolean addContractBox(Contract contract,String id) throws AppException {
		//����������־ flag
		boolean flag=false;
		//�������ݿ��������
		Connection conn=null;
		PreparedStatement psmt=null;
		Connection conn1=null;
		PreparedStatement psmt1=null;
		try {
			//�������ݿ�����
			conn=DBUtil.getConnection();
			String sql="insert into contract(cid,ctitle,ccontent,cstarttime,cendtime,state)"
					+ "values(?,?,?,?,?,0)";
			
			//Ԥ����SQL���
			psmt=conn.prepareStatement(sql);
			//���ò���
			psmt.setString(1, contract.getCid());
			psmt.setString(2,contract.getCtitle());
			psmt.setString(3,contract.getContent());
			psmt.setString(4,contract.getCstarttime());
			psmt.setString(5,contract.getCendtime());
			//������������
			int result=psmt.executeUpdate();
			
			conn1=DBUtil.getConnection();
			String sql1="insert into cu(cid,uid)"+ "values(?,?)";
			//Ԥ����SQL���
			psmt1=conn1.prepareStatement(sql1);
			//���ò���
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
			//�ر����ӣ��ͷ���Դ
			
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
			
			DBUtil.closeStatement(psmt1);
			DBUtil.closeConnection(conn1);
			
		}
		//���ؽ��
		return flag;
}
	
	//����ǩ��ͬ������
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
			//�ر����ӣ��ͷ���Դ
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
			
			DBUtil.closeResultSet(rs1);
			DBUtil.closeStatement(psmt1);
			DBUtil.closeConnection(conn1);
		}
		return count;
	}

    //������ǩ��ͬ����Ϣ����
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
				System.out.println("�����п���");
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

    //��ʽ��ǩ��ͬ 
	public boolean CounterSign(String Cid,String Aid, int suggesstion, String Detail)
			throws AppException {
		
		boolean flag=false;
		int count=NumHQList();
		// int Cid=Integer.parseInt(Cid);
		// count��aid��from ca suggestion=-1 
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
			System.out.println("���ã�");
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
			// if aidNum=1 then and suggestion=0 then set state=1;������detail��suggesstion	
			if(aidNum==1&&suggesstion==0)
			{
				//��admin��suggestion�Լ�detail�ı�
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
					System.out.println("����ҾͶ���");
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
				//ֱ�Ӹ���Contract���ca��
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
					System.out.println("Ӧ�������");
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
					System.out.println("��Ӧ�������");
					if(result17>0)
					{
						
					}
				}
			}
			//num==0
			else
			{
				//ϵͳ����Ա����Ȩ��
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
			//�����޸���������޸�
			conn=DBUtil.getConnection();
			String sql="update contract set ccontent=? where cid=?";
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, content);
			psmt.setString(2, Cid);
			result=psmt.executeUpdate();
			
			//����ͬ״̬��Ϊ2
			conn1=DBUtil.getConnection();
			String sql1="update contract set state=2 where cid=?";
			psmt1=conn1.prepareStatement(sql1);
			psmt1.setString(1, Cid);
			result1=psmt1.executeUpdate();
			
			
			int aidNo=0;
			//����λlevelΪ2��admin�������Ϊ-1
			
			//�ȵõ�levelΪ2�Ĺ���Ա�ĸ���
			conn2=DBUtil.getConnection();
			String sql2="select count(aid) from admin where level=2";
			psmt2=conn2.prepareStatement(sql2);
			rs2=psmt2.executeQuery();
			if(rs2.next())
			{
				 aidNo=rs2.getInt("count(aid)");
			}
			
			
			
			//������levelΪ2 ��admin��aid������
			String aidNum[];
			 
			 aidNum=new String[aidNo];
			 Connection conn3=null;
			 PreparedStatement psmt3=null;
			 ResultSet rs3=null;
			 
			 
				
			if(aidNo>0)
			{
				conn3=DBUtil.getConnection();
					
				String sql3="select aid from admin where level=2 ";
					
				//Ԥ����SQL���
				psmt3=conn3.prepareStatement(sql3);
					
				//���ò���
				int j=0;
				rs3=psmt3.executeQuery();
					
				while(rs3.next())
				{
					aidNum[j]=rs3.getString("aid");
					j++;
				}
			}			
					
			 //��������뵽ca���SQL��伯
			 String Sql[];
			 //���������ca���������ݿ⴦��
			 Connection Conn[];
			 PreparedStatement Psmt[];
			//�����洢�����
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
				Psmt[k].setString(1, "δ��ˣ������");
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
	
	/*ͨ����ͬ��Ż�ȡ��ͬ��ϸ����*/
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

	/*��ȡ״̬Ϊ����ݸ�ĺ�ͬ*/
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
	
	/*��ȡ״̬Ϊ�����صĺ�ͬ*/
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
	
	/*��ȡȫ��״̬Ϊ�����صĺ�ͬ*/
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
	
	/*��ȡ״̬Ϊ����ĺ�ͬ*/
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
	
	/*��ȡ״̬Ϊ����ĺ�ͬ*/
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

	/*��ȡ״̬Ϊboss��ĺ�ͬ*/
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
	
	/*��ȡȫ��״̬Ϊboss��ĺ�ͬ*/
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
	
	/*��ȡ�Ѿ�ǩ����ɵĺ�ͬ*/
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
	
    /*ǩ����ͬ*/
	public boolean signContract(String cid,String aid,String message) throws AppException
	{
		//ca�����Ƿ���ڸú�ͬ��������¼
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
		    if(isExist)      //���֮ǰ��ͬ�в��ع�����ca���л��м�¼����ɾ���ɼ�¼���ٲ����¼�¼
		    	psmt.addBatch(delete);
		    psmt.addBatch(insert);
		    psmt.executeBatch();
		    return true;
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*boss��ǩ��ͬ�ҽ���ͬ����*/
	public boolean deniedContract(String cid,String aid,String message) throws AppException
	{
		//ca�����Ƿ���ڸú�ͬ��������¼
		boolean isExist = isExistInCa(cid);

		
		String update = "update contract set state = -1 where cid = '"+ cid+"'";
		String delete = "delete from ca where cid = '"+cid+"'";
		String insert = "insert into ca values('"+cid + "','"+aid+"',0,'"+message+"')";

		Connection conn = DBUtil.getConnection();
		Statement psmt = null;
				
		try {
			psmt = conn.createStatement();
		    psmt.addBatch(update);
		    if(isExist)      //���֮ǰ��ͬ�в��ع�����ca���л��м�¼����ɾ���ɼ�¼���ٲ����¼�¼
				psmt.addBatch(delete);
			    psmt.addBatch(insert);
			    psmt.executeBatch();
			    return true;
					
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
				
		return false;
	}
	
	/*boss���غ�ͬ���û������޸�*/
	public boolean alterContract(String cid,String aid,String message) throws AppException
	{
		//ca�����Ƿ���ڸú�ͬ��������¼
		boolean isExist = isExistInCa(cid);

				
		String update = "update contract set state = 1 where cid = '"+ cid +"'";
		String delete = "delete from ca where cid = '"+cid+"'";
		String insert = "insert into ca values('"+cid + "','"+aid+"',0,'"+message+",";

		Connection conn = DBUtil.getConnection();
		Statement psmt = null;
				
		try {
			psmt = conn.createStatement();
		    psmt.addBatch(update);
		    if(isExist)      //���֮ǰ��ͬ�в��ع�����ca���л��м�¼����ɾ���ɼ�¼���ٲ����¼�¼
			   psmt.addBatch(delete);
			   psmt.addBatch(insert);
			   psmt.executeBatch();
			   return true;
					
		} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
				
		return false;
	}
	
	/*��ѯca�����Ƿ����boss֮ǰ�Ժ�ͬ������¼*/
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
	 *��������ݵĺ�ͬ����ݸ��� 
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
     * ɾ���ݸ�
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
	 * �������� Javadoc��
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
	
