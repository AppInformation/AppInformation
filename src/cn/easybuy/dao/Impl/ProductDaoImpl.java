package cn.easybuy.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.dao.ProductDao;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;

public class ProductDaoImpl extends BaseDao implements ProductDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	/**
	 * 查询总行数
	 */
	@Override
	public int SelectProduct() {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "SELECT COUNT(*) FROM easybuy_product";
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
	/**
	 * 分页
	 */
	@Override
	public List<Product> PageProduct(int index, int sum) {
		List<Product> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM easybuy_product LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, (index-1)*sum);
			pstmt.setInt(2, sum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setFileName(rs.getString("fileName"));
				product.setStock(rs.getInt("stock"));
				product.setPrice(rs.getFloat("price"));
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}
	/**
	 * 删除商品
	 */
	@Override
	public int DeleteProduct(int id) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "DELETE FROM easybuy_product WHERE id = ?";
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
	/**
	 * 修改商品
	 */
	@Override
	public int UpdateProduct(Product product) {
		int result = 0;
		try {
			conn = getConnection();
			String sql = "UPDATE easybuy_product SET categoryLevel1Id=?,categoryLevel2Id=?,categoryLevel3Id=?,name=?,fileName=?,price=?,stock=?,description=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product.getCategoryLevel1Id());
			pstmt.setInt(1, product.getCategoryLevel2Id());
			pstmt.setInt(3, product.getCategoryLevel3Id());
			pstmt.setString(4, product.getName());
			pstmt.setString(5, product.getFileName());
			pstmt.setFloat(6, product.getPrice());
			pstmt.setInt(7, product.getStock());
			pstmt.setString(8, product.getDescription());
			pstmt.setInt(9, product.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}
	/**
	 * 按id查询商品
	 */
	@Override
	public Product SelectId(int dd) {
		Product ps = new Product();
		try {
			conn = getConnection();
			String sql = "SELECT * FROM easybuy_product where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ps.setCategoryLevel1Id(rs.getInt("categoryLevel1Id"));
				ps.setCategoryLevel2Id(rs.getInt("categoryLevel2Id"));
				ps.setCategoryLevel3Id(rs.getInt("categoryLevel3Id"));
				ps.setName(rs.getString("name"));
				ps.setFileName(rs.getString("fileName"));
				ps.setPrice(rs.getFloat("price"));
				ps.setStock(rs.getInt("stock"));
				ps.setDescription(rs.getString("description"));
				ps.setId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return ps;
	}
	/**
	 * 按分级查询
	 * @param type
	 * @return
	 */
	@Override
	public List<ProductCategory> SelectType(int type) {
		List<ProductCategory> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "select * from easybuy_product_category where type=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductCategory dd = new ProductCategory();
				dd.setId(rs.getInt("id"));
				dd.setName(rs.getString("name"));
				list.add(dd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
}
