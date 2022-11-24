package com.web.member.model.dao;

import static com.web.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.web.member.model.vo.Member;

public class MemberDao {
	private Properties sql=new Properties();
	
	public MemberDao() {
		try {
			String path=MemberDao.class
					.getResource("/sql/member/member_sql_properties")
					.getPath();
			sql.load(new FileReader(path));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Member searchMember(Connection conn,String userId,String password) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member m=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("searchIdPassword"));
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				m=getMember(rs);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return m;
	}
	private Member getMember(ResultSet rs) throws SQLException {
		return Member.builder()
				.userId(rs.getString("userId"))
				.password(rs.getString("password"))
				.userName(rs.getString("userName"))
				.gender(rs.getString("gender").charAt(0))
				.age(rs.getInt("age"))
				.email(rs.getString("email"))
				.phone(rs.getString("phone"))
				.address(rs.getString("address"))
				.hobby(rs.getString("hobby").split(","))
				.enrollDate(rs.getDate("enrolldate"))
				.build();
	}
}
