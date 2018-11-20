package cn.easybuy.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.Easybuy_user_Dao;
import cn.easybuy.entity.User;

public class Easybuy_user_Dao_Impl extends BaseDao implements Easybuy_user_Dao {
	
	Connection conn = getConnection();
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public User Login(String loginName, String password) {
		User es = null;
		try {
			String sql = "SELECT * FROM easybuy_user WHERE loginName = ? AND `password` = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				es = new User();
				es.setId(rs.getInt("id"));
				es.setLoginName(rs.getString("loginName"));
				es.setUserName(rs.getString("userName"));
				es.setType(rs.getInt("type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return es;
	}

	@Override
	public int Register(User id) {
		int result = 0;
		try {
			String sql = "insert into easybuy_user (loginName,password,userName,sex,identityCode,email,mobile) values (?, ?, ?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id.getLoginName());
			pstmt.setString(2, id.getPassword());
			pstmt.setString(3, id.getUserName());
			pstmt.setInt(4, id.getSex());
			pstmt.setString(5, id.getIdentityCode());
			pstmt.setString(6, id.getEmail());
			pstmt.setString(7, id.getMobile());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}

	@Override
	public int Verification(String yan) {
		int result = 0;
		try {
			String sql = "SELECT count(*) FROM easybuy_user WHERE loginName = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, yan);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
