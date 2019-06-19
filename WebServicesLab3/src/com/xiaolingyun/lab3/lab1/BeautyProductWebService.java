package com.xiaolingyun.lab3.lab1;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiaolingyun.lab3.exception.EmptyIdentifierException;
import com.xiaolingyun.lab3.exception.EmptyIdentifierExceptionBean;
import com.xiaolingyun.lab3.exception.NonKeySpecifiedException;
import com.xiaolingyun.lab3.exception.NonKeySpecifiedExceptionBean;

@WebService(serviceName = "BeautyProductService")
public class BeautyProductWebService {

    @WebMethod(operationName = "getBeautyProducts")
    public List<BeautyProduct> getBeautyProducts() {
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<BeautyProduct> beautyProducts = dao.getBeautyProducts();
        return beautyProducts;
    }

    @WebMethod(operationName = "insertBeautyProduct")
    public Integer insertBeautyProduct(String name, String producingСountry, String vendorСode, String category, String price) throws NonKeySpecifiedException {
        if ((name == null || name.isEmpty()) &&
            (producingСountry == null || producingСountry.isEmpty()) &&
            (vendorСode == null || vendorСode.isEmpty()) &&
            (category == null || category.isEmpty())&&
            (price == null || price.isEmpty()))
        {
            NonKeySpecifiedExceptionBean fault = new NonKeySpecifiedExceptionBean();
            throw new NonKeySpecifiedException("No one key is specified.", fault);
        }
        PostgreSQLDAO dao = new PostgreSQLDAO();
        Integer beautyProductId = dao.insertBeautyProduct(name, producingСountry, vendorСode, category, price);
        return beautyProductId;
    }

    @WebMethod(operationName = "updateBeautyProduct")
    public String updateBeautyProduct(String id, String name, String producingСountry, String vendorСode, String category, String price) throws EmptyIdentifierException, NonKeySpecifiedException {
        if (id == null || id.isEmpty())
        {
            EmptyIdentifierExceptionBean fault = new EmptyIdentifierExceptionBean();
            throw new EmptyIdentifierException("Product identifier is not specified.", fault);
        }
        if ((name == null || name.isEmpty()) &&
                (producingСountry == null || producingСountry.isEmpty()) &&
                (vendorСode == null || vendorСode.isEmpty()) &&
                (category == null || category.isEmpty())&&
                (price == null || price.isEmpty()))
        {
            NonKeySpecifiedExceptionBean fault = new NonKeySpecifiedExceptionBean();
            throw new NonKeySpecifiedException("No one key is specified.", fault);
        }
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String status = dao.updateBeautyProduct(id, name, producingСountry, vendorСode, category, price) ;
        return status;
    }

    @WebMethod(operationName = "deleteBeautyProduct")
    public String deleteBeautyProduct(String id) throws EmptyIdentifierException {
        if (id == null || id.isEmpty())
        {
            EmptyIdentifierExceptionBean fault = new EmptyIdentifierExceptionBean();
            throw new EmptyIdentifierException("Product identifier is not specified.", fault);
        }
        PostgreSQLDAO dao = new PostgreSQLDAO();
        String status = dao.deleteBeautyProduct(id) ;
        return status;
    }

    @WebMethod(operationName = "findBeautyProduct")
    public List<BeautyProduct> findBeautyProduct(String id, String name, String producingСountry, String vendorСode, String category, String price) throws NonKeySpecifiedException {
        if ((name == null || name.isEmpty()) &&
                (producingСountry == null || producingСountry.isEmpty()) &&
                (vendorСode == null || vendorСode.isEmpty()) &&
                (category == null || category.isEmpty())&&
                (price == null || price.isEmpty()))
        {
            NonKeySpecifiedExceptionBean fault = new NonKeySpecifiedExceptionBean();
            throw new NonKeySpecifiedException("No one key is specified.", fault);
        }
        PostgreSQLDAO dao = new PostgreSQLDAO();
        List<BeautyProduct> beautyProducts = dao.findBeautyProduct(id, name, producingСountry, vendorСode, category, price) ;
        return beautyProducts;
    }

}
