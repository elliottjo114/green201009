package model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;

public class CenterDTO {

	Integer id, gid,seq,lev, cnt;
	
	String title, pname, content, upfile,pw;
	
	Date regdate;
	
	public boolean getImgChk() {
		
		ArrayList<String> img = new ArrayList<String>();
		img.add("jpg");
		img.add("jpeg");
		img.add("bmp");
		img.add("gif");
		img.add("png");
		
		return img.contains(upfile.toLowerCase().substring(upfile.lastIndexOf(".")+1));
		//확장자가 들어있으면 리턴
			
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getLev() {
		return lev;
	}

	public void setLev(Integer lev) {
		this.lev = lev;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getContent() {
		return content;
	}
	
	public String getContentBr() {
		return content.replace("\r\n", "<br>");
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUpfile() {
		if(upfile ==null || upfile.equals("") ||  upfile.toLowerCase().equals("null") )
			return null;
		return upfile;
	}
	
	public String getUpfileEn() {//한글 파일명 인코딩
		String res = upfile;
		try {
			res = URLEncoder.encode(upfile,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	public void setUpfile(String upfile) {
		this.upfile = upfile;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
}
