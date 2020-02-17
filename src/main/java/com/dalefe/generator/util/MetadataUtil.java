package com.dalefe.generator.util;

import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @author dalefe
 * @version  2019/11/07
 */
@Data
public class MetadataUtil {
	private static Connection conn ;
	private static DatabaseMetaData meta;
public static void initConnection() {
	try {
		Class.forName(ConfigUtil.getConfiguration().getDb().getDriver());
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
				if(rs.getString("TABLE_NAME").equals("sys_config")){
					continue;
				}
				String tName=rs.getString("TABLE_NAME");
				nameList.add(tName);
			}
			rs.close();
			conn.close();
		}catch (Exception e) {
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
			String[] colInfo=new  String[4];
			colInfo[0] =rs.getString("COLUMN_NAME");
			colInfo[1] =rs.getString("REMARKS");
			colInfo[2] =rs.getString("TYPE_NAME");
			colInfo[3] = tableName;
			columnInfoList.add(colInfo);
		}
		rs.close();
		conn.close();
		return columnInfoList;
	}
	public static List<Object> gettableInfoByTableName(String tableName){
		initConnection();
		try {
			ResultSet rs=meta.getColumns(null,"%",tableName,"%");
			List<Object> tableInfo = new ArrayList<>();
			while(rs.next()){
				HashMap<String,String> tableColumns = new HashMap<>();
				tableColumns.put("label",rs.getString("COLUMN_NAME"));
				tableColumns.put("key",JavaNameUtil.toCamel(rs.getString("COLUMN_NAME")));
				tableInfo.add(tableColumns);
			}
			rs.close();
			conn.close();
			return tableInfo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
