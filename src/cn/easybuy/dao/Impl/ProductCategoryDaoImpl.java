package cn.easybuy.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProductCategoryDao;
import cn.easybuy.entity.ProductCategory;

public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public int SelectProductCategory() {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "SELECT COUNT(*) FROM easybuy_product_category";
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
	public List<ProductCategory> PageProductCategory(int index, int sum) {
		List<ProductCategory> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "SELECT epc1.*,epc2.name  AS parentName FROM easybuy_product_category epc1 LEFT JOIN easybuy_product_category epc2 ON epc1.parentId=epc2.id LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (index-1)*sum);
			pstmt.setInt(2, sum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductCategory product = new ProductCategory();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setParentId(rs.getInt("parentId"));
				product.setType(rs.getInt("type"));
				product.setParentName(rs.getString("parentName"));
				product.setIconClass(rs.getString("iconClass"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int DeleteProductCategory(int id) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM easybuy_product_category WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}
	
}
