package com.test.model.service;

import java.sql.Connection;

import com.test.member.vo.Member;
import com.test.model.dao.MemberDao;
import static com.test.common.JDBCTemplate.*;

public class MemberService {
	private MemberDao dao=new MemberDao();
	
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn, m);
		if(result>0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
}
