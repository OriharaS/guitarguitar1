package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.dao.DAO;
import DB.DBUtil;
import DB.DataConn;
import guitar.Guitar;

public abstract class daoImple implements DAO {
	
	/**
	 * ����һ���µ�Guitar
	 * @param serialNumber ���к�
	 * @param builder ������
	 * @param model ģ��
	 * @param type ����
	 * @param backWood ����ľ��
	 * @param topWood ����ľ��
	 * @param price �۸�
	 */
	@Override
	public void addGuitar(String serialNumber, String builder, String model, String type, String backWood,
			String topWood, String price) {
		Connection Conn = DBUtil.open(Conn);
		String sql = "insert into Guitar(serialNumber,builder,model,type,backWood,topWood,price) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setString(2, builder);
			pstmt.setString(3, model);
			pstmt.setString(4, type);
			pstmt.setString(5, backWood);
			pstmt.setString(6, topWood);
			pstmt.setString(7, price);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
	}
	

	@Override
	public void delGuitar(String serialNumber) {
		Connection Conn = DBUtil.open();
		String sql = "delete from Guitar where serialNumber = ?";
		try {
			PreparedStatement pstmt = Conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(Conn);
		}
	}

	@Override
	public void updateGuitar(String serialNumber, String builder, String model, String type, String backWood,
			String topWood, String price) {
		
	}
	
	/**
	 * ��ѯGuitar��Ϣ
	 * @return һ��List�б����������ݿ��е�����Guitar
	 */
	@Override
	public  List<Guitar> searchGuitar( Guitar guitar) throws Exception {
		// TODO Auto-generated method stub
		List<Guitar> result = new ArrayList<Guitar>();
		String sql = "select * from guitar where 1=1 ";
		if(guitar.getType()!=null&guitar.getType()!=""){
			sql+=" and type='"+guitar.getType()+"'";
		}
		if(guitar.getBuilder()!=null&guitar.getBuilder()!=""){
			sql+=" and builder='"+guitar.getBuilder()+"'";
		}
		if(guitar.getBackWood()!=null&guitar.getBackWood()!=""){
			sql+=" and backwood='"+guitar.getBackWood()+"'";
		}
		if(guitar.getTopWood()!=null&guitar.getTopWood()!=""){
			sql+=" and topwood='"+guitar.getTopWood()+"'";
		}
		if(guitar.getSerialNumber()!=null&guitar.getSerialNumber()!=""){
			sql+=" and serialNumber='"+guitar.getSerialNumber()+"'";
		}
		Connection conn=DataConn.getConnection();
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ResultSet rs = ptmt.executeQuery();
		Guitar guitarnew=null;
		while (rs.next()) {
				guitarnew= new Guitar();
				guitarnew.setType(rs.getString("type"));
				guitarnew.setBackwood(rs.getString("backwood"));
				guitarnew.setTopwood(rs.getString("topwood"));
				guitarnew.setSerialNumber(rs.getString("serialNumber"));
				guitarnew.setBuilder(rs.getString("builder"));
				result.add(guitarnew);
		}
	ptmt.close();
		return result;
	}

}
