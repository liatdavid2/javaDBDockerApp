package com.team.stock.dbservice.dao;

import java.util.Collection;

import com.team.stock.dbservice.classes.ProductJdbc;

public interface productDao {
public Collection<ProductJdbc>findAll();
}
