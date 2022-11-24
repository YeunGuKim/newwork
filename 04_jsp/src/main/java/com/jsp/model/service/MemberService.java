package com.jsp.model.service;

import static com.jsp.common.JdbcTemlate.getConnection;
import static com.jsp.common.JdbcTemlate.close;

import java.sql.Connection;
import java.util.List;

import com.jsp.model.dao.MemberDao;
import com.jsp.model.vo.Member;
public class MemberService {
	
	private MemberDao dao=new MemberDao();
	
	public List<Member> searchMemberAll(){
		Connection conn=getConnection();
		List<Member> result=dao.searchMemberAll(conn);
		close(conn);
		return result;
		
	}
	public List<Member> searchMemberName(String name){
		Connection conn=getConnection();
		List<Member> result=dao.searchMemberName(conn,name);
		close(conn);
		return result;
	}
}
