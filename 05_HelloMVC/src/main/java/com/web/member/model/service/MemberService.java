package com.web.member.model.service;

import static com.web.common.JDBCTemplate.close;
import static com.web.common.JDBCTemplate.commit;
import static com.web.common.JDBCTemplate.rollback;
import static com.web.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.web.member.model.dao.MemberDao;
import com.web.member.model.vo.Member;
public class MemberService {
	private MemberDao dao=new MemberDao();
	
	public Member searchMember(String userId,String password) {
		Connection conn=getConnection();
		Member m=dao.searchMember(conn,userId,password);
		close(conn);
		return m;
	}
//	public List<Member> insertMember(String userId,String password,String pwcheck,
//			String userName, int age, String email, String phone, String address,
//			char gender, String[] hobby) {
//		Connection conn=getConnection();
//		List<Member> members=dao.insertMember(conn, userId, password, pwcheck,
//				userName, age, email, phone, address, gender, hobby);
//		close(conn);
//		return members;
//	}
	public int insertMember(Member m) {
		Connection conn=getConnection();
		int result=dao.insertMember(conn,m);
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
