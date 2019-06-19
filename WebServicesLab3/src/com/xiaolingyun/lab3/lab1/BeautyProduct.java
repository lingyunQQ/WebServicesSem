package com.xiaolingyun.lab3.lab1;

/**
 * Created by xiaolingyun on 18.06.19.
 */
public class BeautyProduct {
	private Integer id;
	private String name;
	private String producingСountry;
	private Integer vendorСode;
	private String category;
	private Double price;

	public BeautyProduct() {
	}

	public BeautyProduct(Integer id, String name, String producingСountry, Integer vendorСode, String category,
			Double price) {
		this.id = id;
		this.name = name;
		this.producingСountry = producingСountry;
		this.vendorСode = vendorСode;
		this.category = category;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getProducingСountry() {
		return producingСountry;
	}

	public Integer getVendorСode() {
		return vendorСode;
	}

	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducingСountry(String producingСountry) {
		this.producingСountry = producingСountry;
	}

	public void setVendorСode(Integer vendorСode) {
		this.vendorСode = vendorСode;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
