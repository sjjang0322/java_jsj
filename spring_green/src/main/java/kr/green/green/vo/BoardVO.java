package kr.green.green.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int bd_num;
	private String bd_title;
	private String bd_content;	
	private Date bd_reg_date;	
	private Date bd_up_date;
	private String bd_type;
	private int bd_ori_num;
	private String bd_me_id;
	private String bd_del;	
	private Date bd_del_date;
	private int bd_views;
	
	public String getBd_reg_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bd_reg_date);
	}
	public String getBd_up_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bd_up_date);
	}
	public String getBd_del_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return format.format(bd_del_date);
	}
	
	public boolean isAccessAuthority(String authority) {
		if(bd_type.equals("일반")||bd_type.equals("qna"))
			return true;
		if(bd_type.equals("공지") && (authority.equals("관리자") || authority.equals("슈퍼 관리자")))
			return true;
		return false;
	}
}
