package cn.easybuy.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.NewsDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public int SelectNews() {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "SELECT COUNT(*) FROM easybuy_news";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return result;
	}

	@Override
	public List<News> PageNews(int index, int sum) {
		List<News> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM easybuy_news LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (index-1)*sum);
			pstmt.setInt(2, sum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setCreateTime(rs.getDate("createTime"));
				list.add(news);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public News SelectId(int id) {
		News news = new News();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM easybuy_news WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return news;
	}

}
