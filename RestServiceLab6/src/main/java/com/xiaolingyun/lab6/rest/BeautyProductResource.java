package com.xiaolingyun.lab6.rest;

import com.xiaolingyun.lab6.exception.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/beautyProducts")
@Produces({ MediaType.APPLICATION_JSON })
public class BeautyProductResource {

	@GET
	public List<BeautyProduct> getBeautyProducts(@QueryParam("id") String id, @QueryParam("name") String name,
			@QueryParam("producingCountry") String producingCountry, @QueryParam("vendorCode") String vendorCode,
			@QueryParam("category") String category, @QueryParam("price") String price) {
		if ((id == null || id.isEmpty()) && isBodyFieldsEmpty(name, producingCountry, vendorCode, category, price)) {
			List<BeautyProduct> beautyProducts = new PostgreSQLDAO().getBeautyProducts();
			return beautyProducts;
		}

		id = (id == null) ? new String() : id;
		name = (name == null) ? new String() : name;
		producingCountry = (producingCountry == null) ? new String() : producingCountry;
		vendorCode = (vendorCode == null) ? new String() : vendorCode;
		price = (price == null) ? new String() : price;

		List<BeautyProduct> beautyProducts = new PostgreSQLDAO().findBeautyProduct(id, name, producingCountry,
				vendorCode, category, price);
		return beautyProducts;
	}

	@POST
	public String insertBeautyProduct(@QueryParam("name") String name,
			@QueryParam("producingCountry") String producingCountry, @QueryParam("vendorCode") String vendorCode,
			@QueryParam("category") String category, @QueryParam("price") String price)
			throws NonKeySpecifiedException {
		if (isBodyFieldsEmpty(name, producingCountry, vendorCode, category, price)) {
			throw new com.xiaolingyun.lab6.exception.NonKeySpecifiedException(
					"No one key is specified! Name, country, vendor code, category or price should be set.");
		}
		PostgreSQLDAO dao = new PostgreSQLDAO();
		Integer beautyProductId = dao.insertBeautyProduct(name, producingCountry, vendorCode, category, price);
		return beautyProductId.toString();
	}

	@PUT
	public String updateBeautyProduct(@QueryParam("id") String id, @QueryParam("name") String name,
			@QueryParam("producingCountry") String producingCountry, @QueryParam("vendorCode") String vendorCode,
			@QueryParam("category") String category, @QueryParam("price") String price)
			throws EmptyIdentifierException, NonKeySpecifiedException {
		if (id == null || id.isEmpty()) {
			throw EmptyIdentifierException.DEFAULT_INSTANCE;
		}
		if (isBodyFieldsEmpty(name, producingCountry, vendorCode, category, price)) {
			throw new com.xiaolingyun.lab6.exception.NonKeySpecifiedException(
					"No one key is specified! Name, country, vendor code, category or price should be set.");
		}

		PostgreSQLDAO dao = new PostgreSQLDAO();
		String status = dao.updateBeautyProduct(id, name, producingCountry, vendorCode, category, price);
		return status;
	}

	@DELETE
	public String deleteBeautyProduct(@QueryParam("id") String id) throws EmptyIdentifierException {
		if (id == null || id.isEmpty()) {
			throw EmptyIdentifierException.DEFAULT_INSTANCE;
		}
		PostgreSQLDAO dao = new PostgreSQLDAO();
		String status = dao.deleteBeautyProduct(id);
		return status;
	}

	private Boolean isBodyFieldsEmpty(String name, String producingCountry, String vendorCode, String category,
			String price) {
		return (name == null || name.isEmpty()) && (producingCountry == null || producingCountry.isEmpty())
				&& (vendorCode == null || vendorCode.isEmpty()) && (category == null || category.isEmpty())
				&& (price == null || price.isEmpty());
	}
}
