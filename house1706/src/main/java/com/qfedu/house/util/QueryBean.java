package com.qfedu.house.util;

import java.util.List;

/**
 * ��ѯ����ӿ� (�Ѳ�ѯ��������������װ��һ��������)
 * @author ���
 *
 */
public interface QueryBean {
	
	/**
	 * �������ؼ���
	 * @param flag �Ƿ���Ҫʹ�ô�����ؼ���
	 * @param keyword �ؼ���
	 * @param asc �����ǽ���
	 * @return QueryBean����
	 */
	QueryBean addOrderBy(boolean flag, String keyword, boolean asc);
	
	default QueryBean addOrderBy(String keyword, boolean asc) {
		return addOrderBy(true, keyword, asc);
	}
	
	default QueryBean addOrderBy(String keyword) {
		return addOrderBy(true, keyword, true);
	}
	
	/**
	 * ��Ӳ�ѯ����
	 * @param flag �Ƿ���Ӹ�����
	 * @param condition ����
	 * @param value ������Ӧ�Ĳ���ֵ
	 * @return QueryBean����
	 */
	QueryBean addCondition(boolean flag, String condition, Object value);
	
	default QueryBean addCondition(String condition, Object value) {
		return addCondition(true, condition, value);
	}

	/**
	 * ��ò�ѯ���
	 */
	String getQueryString();
	
	/**
	 * ��ò�ѯ��¼�������
	 */
	String getCountString();
	
	/**
	 * ��ѯ��������Ӧ�Ĳ���
	 * @return ����������б�����
	 */
	List<Object> getParameters();
}
