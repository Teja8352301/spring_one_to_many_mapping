package com.teja.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
		        name = "UUID",
		        strategy = "org.hibernate.id.UUIDGenerator"
		    )
	String orderId;
	
	int orderItemsCount;
	
	int totalPrice;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.MERGE})
	@JoinColumn(name="id")
	User userId;

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Orders() {
		super();
	}

	public Orders(int orderItemsCount, int totalPrice) {
		super();
		this.orderItemsCount = orderItemsCount;
		this.totalPrice = totalPrice;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getOrderItemsCount() {
		return orderItemsCount;
	}

	public void setOrderItemsCount(int orderItemsCount) {
		this.orderItemsCount = orderItemsCount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderItemsCount=" + orderItemsCount + ", totalPrice=" + totalPrice
				+ "]";
	}

	
}
