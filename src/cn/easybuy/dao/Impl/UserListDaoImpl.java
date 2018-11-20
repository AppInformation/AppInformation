package cn.easybuy.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.UserListDao;
import cn.easybuy.entity.User;

public class UserListDaoImpl extends BaseDao implements UserListDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	@Override
	public int SelectUser() {
		int num = 0;
		try {
			conn = getConnection();
			String sql = "SELECT count(*) FROM easybuy_user";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return num;
	}

	@Override
	public List<User> PageUser(int index, int sum) {
		List<User> list = new ArrayList<User>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM easybuy_user LIMIT ?,?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, (index-1)*sum);
			pstmt.setInt(2, sum);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setSex(rs.getInt("sex"));
				user.setType(rs.getInt("type"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int delete(int id) {
		int delete = 0;
		try {
			conn = getConnection();
			String sql = "DELETE from easybuy_user where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			delete = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return delete;
	}

	@Override
	public int update(User user) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE easybuy_user SET loginName=?,userName=?,identityCode=?,email=?,mobile=?,type=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getLoginName());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getIdentityCode());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getMobile());
			pstmt.setInt(6, user.getType());
			pstmt.setInt(7, user.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}

	@Override
	public User SelectId(int dd) {
		User user = new User();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM easybuy_user where id=?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, dd);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user.setLoginName(rs.getString("loginName"));
				user.setUserName(rs.getString("userName"));
				user.setIdentityCode(rs.getString("identityCode"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile"));
				user.setType(rs.getInt("type"));
				user.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return user;
	}
	
}
