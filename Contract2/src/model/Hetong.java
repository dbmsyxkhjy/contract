package model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//合同
@Entity
@Table(name="t_Hetong")
public class Hetong {
	

	@Id
	@GeneratedValue
	private int id;//主键
	
	 private String bianhao;//合同编号
	 
    private String biaoti;//合同名称
	
	private String content;//内容
	
	private String fujian;//文件

	private String fujianYuanshiming;//文件名
	
	private String riq;//开始时间
	
	private String endriq;//结束时间
	
	private String stauts;//状态属性(已起草,已定稿,审批【通过，不通过】)
	
	private String cg;//会签状态(待签署，同意,拒绝)
	
	private String dg;//签订状态(待签署，同意,拒绝)
	
	private String yijian;//客户初稿意见
	
	@ManyToOne
	@JoinColumn(name="userid")
	private User user;//关联客户
	
	private String name;//操作员姓名
	
	private Date createtime;//添加时间

	private int hetonglock;//删除状态  0表示未删除 1表示已删除
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getBiaoti() {
		return biaoti;
	}

	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getRiq() {
		return riq;
	}

	public void setRiq(String riq) {
		this.riq = riq;
	}

	public String getEndriq() {
		return endriq;
	}

	public void setEndriq(String endriq) {
		this.endriq = endriq;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getStauts() {
		return stauts;
	}

	public void setStauts(String stauts) {
		this.stauts = stauts;
	}

	public int getHetonglock() {
		return hetonglock;
	}

	public void setHetonglock(int hetonglock) {
		this.hetonglock = hetonglock;
	}

	public String getYijian() {
		return yijian;
	}

	public void setYijian(String yijian) {
		this.yijian = yijian;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFujian() {
		return fujian;
	}

	public void setFujian(String fujian) {
		this.fujian = fujian;
	}

	public String getFujianYuanshiming() {
		return fujianYuanshiming;
	}

	public void setFujianYuanshiming(String fujianYuanshiming) {
		this.fujianYuanshiming = fujianYuanshiming;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public String getDg() {
		return dg;
	}

	public void setDg(String dg) {
		this.dg = dg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
