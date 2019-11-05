package com.dalefe.generator.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * �����ȡ���Ԫ��Ϣ
 * �е�Ԫ��Ϣ
 */

public class MetadataUtil {
	private static Connection conn ;
	private static DatabaseMetaData meta;
//	static {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		}catch (ClassNotFoundException e){
//			e.printStackTrace();
//			System.out.println("���ݿ�����ʧ�ܣ�");
//		}
//	}
//	public static void openConnection(){
//		try {
//			if (conn==null||conn.isClosed()){
//				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?verifyServerCertificate=false&useSSL=false&serverTimezone=UTC",
//						"root","root");
//				meta=conn.getMetaData();
//			}
//		}catch (SQLException e){
//			e.printStackTrace();
//		}
//
//	}
public static void initConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = ConfigUtil.getConfiguration().getDb().getUrl();
		String username = ConfigUtil.getConfiguration().getDb().getUsername();
		String password = ConfigUtil.getConfiguration().getDb().getPassword();
		conn = DriverManager.getConnection(url, username, password);
		meta=conn.getMetaData();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
	//��ȡע��
	public static  String getCommentByTableName(String tableName) throws Exception{
		initConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SHOW CREATE TABLE "+tableName);
		String comment=null;
		if (rs!=null&&rs.next()){
			comment=rs.getString(2);
		}
		rs.close();
		stmt.close();
		conn.close();
		return comment;
	}

	//��ȡ���б�����
	public static List<String> getTableNames(){
		initConnection();
		ResultSet rs=null;
		List<String> nameList=new ArrayList<>();
		try {
			rs=meta.getTables(null,"test",null,new String[]{"TABLE"});
			while (rs.next()){
				String tName=rs.getString("TABLE_NAME");
				nameList.add(tName);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return  nameList;
	}

	/**
	 * ����Ϣ����ļ��ϡ�List��ÿ��Ԫ����һ�����飬����һ���е���Ϣ��
	 * ÿ�������Ԫ��1��������Ԫ��2��ע�ͣ�Ԫ��3������
	 * @return
	 */
	public static List<String[]> getTableColumnsInfo(String tableName) throws  Exception{
		initConnection();
		ResultSet rs=meta.getColumns(null,"%",tableName,"%");
		List<String[]> columnInfoList=new ArrayList<>();
		while (rs.next()){
			String[] colInfo=new  String[3];
			colInfo[0] =rs.getString("COLUMN_NAME");
			colInfo[1] =rs.getString("REMARKS");
			colInfo[2] =rs.getString("TYPE_NAME");
			columnInfoList.add(colInfo);
		}
		return columnInfoList;
	}


	public static DatabaseMetaData getMeta() {
		return meta;
	}

	public static void setMeta(DatabaseMetaData meta) {
		MetadataUtil.meta = meta;
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		MetadataUtil.conn = conn;
	}
}
