package com.dongduk.myfancy.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.io.Serializable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@SuppressWarnings("serial")
public class Cart implements Serializable {
	private Map<Product, Integer> cartList;
	private int quantity;	//사용자가 타이핑하는 수량 사용하기 위한 필드
	private int cartTotalQuantity;	//카트 내 물품들 총 수량
	
	public Cart() {
		super();
		cartList = new HashMap<Product, Integer>();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCartList(Map<Product, Integer> cartList) {
		this.cartList = cartList;
	}

	public Map<Product, Integer> getCartList() {
		return cartList;
	}

	public void setCartTotalQuantity(int cartTotalQuantity) {
		this.cartTotalQuantity = cartTotalQuantity;
	}

	//카트에 담긴 물품들 총 수량 가져옴
	public int getCartTotalQuantity() {
		cartTotalQuantity = 0;
		cartList = getCartList(); // cart에 담긴 물품들
		for(Map.Entry<Product, Integer> elem : cartList.entrySet()) { // cart에 담긴 물품들
		         cartTotalQuantity += elem.getValue();	//카트 내 수량들 모두 더해줌
		}
		return cartTotalQuantity;	//카트 내 물품들 총 수량 returns
	}

	//카트(오른쪽 분활화면)에 소비자가 선택한 상품들 추가
	public void addProductForSale(Product product) {
		System.out.println(product.getProduct_id());
		cartList.put(product, 1);	//처음 수량은 1로 고정
	}
	
	public void addProductForOrder(Product product, int quantity) { // cart에 담기
		cartList.put(product, quantity);
	}
	
	//카트에서 소비자가 타이핑한 값으로 수량 설정
	public void setQuantityByProduct(Product product) {
//		product.setQuantity(quantity);	//소비자가 타이핑한 값으로 설정
		cartList.put(product, quantity);
	}
	
	public void checkInStock(Map<Product, Integer> cartList) {
		Set<Entry<Product,Integer>> set = cartList.entrySet();
		Iterator<Entry<Product,Integer>> itr = set.iterator();
		while(itr.hasNext()) {
			Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
			Product product = e.getKey();
			quantity = e.getValue();
			if (product.getQuantity() < quantity) {
				
			}
		}
	}

	 public int getSubOrderTotal() { // 카트에 담긴 총 금액
		 int subTotal = 0;
			cartList = getCartList();
			Set<Entry<Product, Integer>> set = cartList.entrySet();
			Iterator<Entry<Product,Integer>> itr = set.iterator();
			while (itr.hasNext()) {
				Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
				subTotal += e.getKey().getOrder_price() * e.getValue();
			}
			return subTotal;
	   }

	public int getSubSaleTotal() {
		int subTotal = 0;
		cartList = getCartList();
		Set<Entry<Product, Integer>> set = cartList.entrySet();
		Iterator<Entry<Product,Integer>> itr = set.iterator();
		while (itr.hasNext()) {
			Map.Entry<Product, Integer> e = (Map.Entry<Product, Integer>)itr.next();
			subTotal += e.getKey().getList_price() * e.getValue();
		}
		return subTotal;
	}

	//cart내 물품들 삭제
	public void removeSale() {
		cartList = getCartList();
		cartList.clear();
		boolean isEmpty = cartList.isEmpty();
		System.out.println("cart내 물품삭제 : " + isEmpty);	
	}

}
