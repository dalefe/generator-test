package com.dalefe.generator.util;

/**
 * java��������������������ת��������
 *
 * @author imagines
 */
public class JavaNameUtil {
	/**
	 * �����ݿ⣨���ֶΣ�ת����java������ʽ��˹����������
	 * @param unberscoreName
	 * @param isPascal       �Ƿ�����ĸת����д��true��ת��Ϊ����������false��ת��Ϊ��˹������
	 * @return ���ջ���˹�������ַ���
	 */
	public static String translate(String unberscoreName, boolean isPascal) {
		StringBuilder result = new StringBuilder();
		//�ӵ�һ����ĸ
		if (unberscoreName != null && unberscoreName.length() !=0) {
			boolean flag = false;
			char firstChar = unberscoreName.charAt(0);  //�õ�����ĸ
			if (isPascal) {
				result.append(Character.toUpperCase(firstChar));
			} else {
				result.append(firstChar);
			}
			//�ӵڶ�����ĸ�Ժ�ʼ
			for (int i = 1, length = unberscoreName.length(); i < length; i++) {
				char ch = unberscoreName.charAt(i);
				if ('_' == ch) {
					flag = true;
				} else {
					if (flag) { //�����һ�����»��ߣ���ת��Ϊ��д��
						result.append(Character.toUpperCase(ch));
						flag = false;
					} else {
						result.append(ch);
					}
				}
			}
		}
		return result.toString();
	}

	/**
	 * ����translate() ת��Ϊ��˹������
	 * @param unberscoreName ���ݿ⣨�������ֶ�����
	 * @return
	 */
	public static String toPascal(String unberscoreName) {
		return translate(unberscoreName, true);
	}

	/**
	 * ����translate() ת��Ϊ��������
	 * @param unberscoreName ���ݿ⣨�������ֶ�����
	 * @return
	 */
	public static String toCamel(String unberscoreName) {
		return translate(unberscoreName, false);
	}

	/**
	 *
	 * ����ȡ���ݿ�����ת��Ϊjava����
	 * @param dbTypeName ʵ�ʵ����ݿ�����
	 * @return
	 */
	public static String dbTypeChangeJavaType(String dbTypeName){
		String javaType=null;
		switch(dbTypeName){
			case "VARCHAR" :javaType="String";break;
			case "BIGINT" :javaType="Long";break;
			case "INT" :javaType="Integer";break;
			case "DATETIME" :javaType="Date";break;
			default:javaType="String";break;
		}
		return javaType;
	}

	public static void main(String[] args) {
		String javaname = JavaNameUtil.toPascal("imagines_age_name");
		System.out.println(javaname);
	}
}
