package action;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;  
import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.Calendar;  

import model.Hetong;
import model.User;
import org.apache.struts2.ServletActionContext;
import util.Pager;
import com.opensymphony.xwork2.ActionSupport;

import dao.HetongDao;
import dao.UserDao;

public class ManageAction extends ActionSupport{
	
	
	private static final long serialVersionUID = -4304509122548259589L;
	private String url = "./";
	private UserDao userDao;
	
	private HetongDao hetongDao;
	
	
	
	public HetongDao getHetongDao() {
		return hetongDao;
	}

	public void setHetongDao(HetongDao hetongDao) {
		this.hetongDao = hetongDao;
	}

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	

	//用户登陆操作
	public void login() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Integer role = Integer.parseInt(request.getParameter("role"));
		User user = userDao.selectBean(" where username='"+username+"' and password='"+password+"' and  userlock=0 and role="+role);
		if(user!=null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('登陆成功');window.location.href='index.jsp'; </script>");
		}else{
			response.setCharacterEncoding("gbk");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('用户名或者密码或者角色错误');window.location.href='login.jsp'; </script>");
		}

	}
	
	//用户退出操作
	public String loginout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.setUrl("login.jsp");
		return SUCCESS;
	}
	
	
	//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("user/password.jsp");
		return SUCCESS;
	}
	
	//修改密码操作
	public void changepwd2() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		User bean = userDao.selectBean(" where username= '"+u.getUsername()+"' and password= '"+password1+"'");
		if(bean!=null){
			bean.setPassword(password2);
			userDao.updateBean(bean);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('修改成功');</script>");
		}else{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setCharacterEncoding("utf8");response.setContentType("text/html; charset=utf8");
			response
					.getWriter()
					.print(
							"<script language=javascript>alert('用户名或者密码错误');</script>");
		}
	}
	
	
	/*********************用户********************/
	//用户信息管理
	public String userlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String truename=request.getParameter("truename");
        StringBuffer sb = new StringBuffer();
        sb.append(" where "); 
        if(username!=null&&!"".equals(username) ){
        	sb.append("username like '%"+username+"%'");
        	sb.append(" and ");
        	request.setAttribute("username", username);
        }
        if(truename!=null&&!"".equals(truename) ){
        	sb.append("truename like '%"+truename+"%'");
        	sb.append(" and ");
        	request.setAttribute("truename", truename);
        }
        sb.append("role=2 and userlock=0 order by id ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = userDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!userlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/userlist.jsp");
		return SUCCESS;
	}
	
	
	//个人信息管理
	public String userlist2(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		String where =" where userlock=0 and id="+user.getId()+" order by id desc "; 
		List<User> list = userDao.selectBeanList((currentpage - 1) * pagesize, pagesize, where);
		request.setAttribute("list", list);
		this.setUrl("user/userlist2.jsp");
		return SUCCESS;
	}
	
	//跳转到添加用户页面
	public String useradd() {
		this.setUrl("user/useradd.jsp");
		return SUCCESS;
	}
	
	
	//添加用户操作
	public void useradd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String jiguan = request.getParameter("jiguan");
		String address = request.getParameter("address");
		String xingbie = request.getParameter("xingbie");
		String age = request.getParameter("age");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User bean =userDao.selectBean(" where username='"+username+"' and userlock=0 ");
	    if(bean==null){
		bean=new User();
		bean.setTruename(truename);
		bean.setTelephone(telephone);
		bean.setJiguan(jiguan);
		bean.setAddress(address);
		bean.setAge(age);
		bean.setXingbie(xingbie);	
		bean.setRole(2);
		bean.setUsername(username);
		bean.setPassword(password);
		
		bean.setCreatetime(new Date());
		userDao.insertBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!userlist'; </script>");
		}else{
			response.setCharacterEncoding("utf8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!userlist'; </script>");
		}
	}
	
	
	
	//删除用户操作
	public void userdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setUserlock(1);
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!userlist'; </script>");
		
	}
	
	//跳转到更新用户页面
	public String userupdate(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}

	
	//更新用户操作
	public void userupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session  = request.getSession();
		User user = (User) session.getAttribute("user");
		String truename = request.getParameter("truename");
		String telephone = request.getParameter("telephone");
		String jiguan = request.getParameter("jiguan");
		String address = request.getParameter("address");
		String xingbie = request.getParameter("xingbie");
		String age = request.getParameter("age");
		
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setTruename(truename);
		bean.setTelephone(telephone);
		bean.setJiguan(jiguan);
		bean.setAddress(address);
		bean.setAge(age);
		bean.setXingbie(xingbie);	
		
		bean.setCreatetime(new Date());
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		if(user.getRole()==1){
			writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!userlist'; </script>");
		}
		if(user.getRole()==2){
			writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!userlist2'; </script>");
		}
		
	}
	
	
	
	
	/*****************操作员********/
	
	//操作员信息管理
	public String c_userlist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username=request.getParameter("username");
		String truename=request.getParameter("truename");
        StringBuffer sb = new StringBuffer();
        sb.append(" where "); 
        if(username!=null&&!"".equals(username) ){
        	sb.append("username like '%"+username+"%'");
        	sb.append(" and ");
        	request.setAttribute("username", username);
        }
        if(truename!=null&&!"".equals(truename) ){
        	sb.append("truename like '%"+truename+"%'");
        	sb.append(" and ");
        	request.setAttribute("truename", truename);
        }
        sb.append("role=3 and userlock=0 order by id ");
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		String where =sb.toString();
		long total = userDao.selectBeanCount(where.replaceAll(" order by id desc", ""));
		List<User> list = userDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!c_userlist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("user/c_userlist.jsp");
		return SUCCESS;
	}
	
	
	
	//跳转到添加操作员页面
	public String c_useradd() {
		this.setUrl("user/c_useradd.jsp");
		return SUCCESS;
	}
	
	
	//添加操作员操作
	public void c_useradd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String truename = request.getParameter("truename");

		User bean =userDao.selectBean(" where username='"+username+"' and userlock=0 ");
	    if(bean==null){
		bean=new User();
		bean.setTruename(truename);
		bean.setRole(3);
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setCreatetime(new Date());
		userDao.insertBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!c_userlist'; </script>");
		}else{
			response.setCharacterEncoding("utf8");
			PrintWriter writer = response.getWriter();
			writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!c_userlist'; </script>");
		}
	}
	
	
	
	//删除操作员操作
	public void c_userdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		User bean =userDao.selectBean(" where id= "+id);
		bean.setUserlock(1);
		userDao.updateBean(bean);
		response.setCharacterEncoding("utf8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!c_userlist'; </script>");
		
	}
	
	
	

	/*****************合同**********************/
	//合同列表
	public String hetonglist(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		String biaoti = request.getParameter("biaoti");
		String bianhao = request.getParameter("bianhao");
		String truename = request.getParameter("truename");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(biaoti !=null &&!"".equals(biaoti)){
			sb.append(" biaoti like '%"+biaoti+"%' ");
			sb.append(" and ");
			request.setAttribute("biaoti", biaoti);
		}
		if(bianhao !=null &&!"".equals(bianhao)){
			sb.append(" bianhao like '%"+bianhao+"%' ");
			sb.append(" and ");
			request.setAttribute("bianhao", bianhao);
		}
		if(truename !=null &&!"".equals(truename)){
			sb.append(" user.truename like '%"+truename+"%' ");
			sb.append(" and ");
			request.setAttribute("truename", truename);
		}
		if(user.getRole()==3){
			sb.append(" hetonglock=0  and dg is null order by id desc ");
		}
		if(user.getRole()==2){
			sb.append(" hetonglock=0 and dg is null and user="+user.getId()+" order by id desc ");
		}
		if(user.getRole()==1){
			sb.append(" hetonglock=0 and dg is null order by id desc ");
		}
		
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}	
		long total = hetongDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Hetong> list = hetongDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!hetonglist", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("hetong/hetonglist.jsp");
		return SUCCESS;
	}
	
	
	//跳转到添加合同页面
	public String hetongadd(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<User> list = userDao.selectBeanList(0, 99, " where role=2 and userlock=0");
		request.setAttribute("list", list);
		this.setUrl("hetong/hetongadd.jsp");
		return SUCCESS;
	}
	
	
	//添加合同操作
	public void hetongadd2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		String u = request.getParameter("u");
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		String riq = request.getParameter("riq");
		String endriq = request.getParameter("endriq");
		String fujian = request.getParameter("fujian");
		String fujianYuanshiming = request.getParameter("fujianYuanshiming");
		Hetong bean = new Hetong();
		bean.setUser(userDao.selectBean(" where id="+u));
		bean.setBianhao(new Date().getTime()+"");
		bean.setFujian(fujian);
		bean.setFujianYuanshiming(fujianYuanshiming);
		bean.setBiaoti(biaoti);
		bean.setContent(content);
		bean.setRiq(riq);
		bean.setEndriq(endriq);
		bean.setName(user.getTruename());
		bean.setStauts("已起草");
		bean.setCg("待签署");
		bean.setCreatetime(new Date());
		hetongDao.insertBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!hetonglist'; </script>");
		
	}
	
	
	
	//删除合同操作
	public void hetongdelete() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		bean.setHetonglock(1);
		hetongDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!hetonglist'; </script>");
		
	}
	
	
	
	//跳转到更新合同页面
	public String hetongupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("hetong/hetongupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新合同操作
	public void hetongupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String biaoti = request.getParameter("biaoti");
		String content = request.getParameter("content");
		String riq = request.getParameter("riq");
		String endriq = request.getParameter("endriq");
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		bean.setBiaoti(biaoti);
		bean.setContent(content);
		bean.setRiq(riq);
		bean.setEndriq(endriq);
		bean.setStauts("已定稿");
		hetongDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!hetonglist'; </script>");
		
	}
	
	//跳转到查看合同页面
	public String hetongupdate3(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("hetong/hetongupdate3.jsp");
		return SUCCESS;
	}
	

	/************合同签署***********/
	//跳转到合同会签页面
	public String hq_hetongupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("hetong/hq_hetongupdate.jsp");
		return SUCCESS;
	}
	
	
	//合同会签操作
	public void hq_hetongupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String cg = request.getParameter("cg");
		String yijian = request.getParameter("yijian");
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		bean.setCg(cg);
		bean.setYijian(yijian);
		hetongDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!hetonglist'; </script>");
		
	}
	
	
	/************合同审批***********/
	//跳转到合同审批页面
	public String sp_hetongupdate(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		request.setAttribute("bean", bean);
		this.setUrl("hetong/sp_hetongupdate.jsp");
		return SUCCESS;
	}
	
	
	//合同审批操作
	public void sp_hetongupdate2() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String stauts = request.getParameter("stauts");
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		bean.setStauts(stauts);
		hetongDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!hetonglist'; </script>");
		
	}
	
	
	//合同签订操作
	public void qd_hetongupdate() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String id = request.getParameter("id");
		Hetong bean =hetongDao.selectBean(" where id= "+id);
		bean.setDg("同意");
		hetongDao.updateBean(bean);
		response.setCharacterEncoding("utf-8");response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.print("<script  language='javascript'>alert('提交成功');window.location.href='method!hetonglist'; </script>");
		
	}
	
	
	/*****************合同**********************/
	//合同列表
	public String hetonglist2(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");	
		String biaoti = request.getParameter("biaoti");
		String bianhao = request.getParameter("bianhao");
		String truename = request.getParameter("truename");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		if(biaoti !=null &&!"".equals(biaoti)){
			sb.append(" biaoti like '%"+biaoti+"%' ");
			sb.append(" and ");
			request.setAttribute("biaoti", biaoti);
		}
		if(bianhao !=null &&!"".equals(bianhao)){
			sb.append(" bianhao like '%"+bianhao+"%' ");
			sb.append(" and ");
			request.setAttribute("bianhao", bianhao);
		}
		if(truename !=null &&!"".equals(truename)){
			sb.append(" user.truename like '%"+truename+"%' ");
			sb.append(" and ");
			request.setAttribute("truename", truename);
		}
		if(user.getRole()==3){
			sb.append(" hetonglock=0  and dg='同意' order by id desc ");
		}
		if(user.getRole()==2){
			sb.append(" hetonglock=0 and dg='同意' and user="+user.getId()+" order by id desc ");
		}
		if(user.getRole()==1){
			sb.append(" hetonglock=0 and dg='同意' order by id desc ");
		}
		
		String where = sb.toString();
		int currentpage = 1;
		int pagesize = 10;
		if(request.getParameter("pagenum") != null){
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}	
		long total = hetongDao.selectBeanCount(where.replaceAll("order by id desc", ""));
		List<Hetong> list = hetongDao.selectBeanList((currentpage-1)*pagesize, pagesize, where);
		request.setAttribute("list", list);
		String pagerinfo = Pager.getPagerNormal((int)total, pagesize, currentpage, "method!hetonglist2", "共有"+total+"条记录");
		request.setAttribute("pagerinfo", pagerinfo);
		this.setUrl("hetong/hetonglist2.jsp");
		return SUCCESS;
	}
	
	
}
