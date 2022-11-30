package com.web.admin.model.service;

import static com.web.common.JDBCTemplate.close;
import static com.web.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.web.admin.model.dao.AdminDao;
import com.web.member.model.vo.Member;

public class AdminService {
	
	private AdminDao dao=new AdminDao();
	
	public List<Member> searchMemberList() {
		Connection conn=getConnection();
		List<Member> result=dao.searchMemberList(conn);
		close(conn);
		return result;
	}
}
