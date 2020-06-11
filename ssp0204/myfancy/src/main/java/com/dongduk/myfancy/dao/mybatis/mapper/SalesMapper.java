package com.dongduk.myfancy.dao.mybatis.mapper;

import java.util.Date;

public interface SalesMapper {

	int getSalesByMonth(int store_id, Date sales_date);
	 // 월별 매출 집계
	int getSalesByWeek(int store_id, Date sales_date);
	// 주별 매출 집계
	int getSalesByDay(int store_id, Date sales_date);
	// 요일별 매출 집계
	void insertSalesAmount(int store_id, int sales_date); 
	// 판매내역을 실시간으로 매출에 추가시키기 위한 method

}
