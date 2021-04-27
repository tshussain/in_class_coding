package com.jac.in_class_coding.repository;

import com.jac.in_class_coding.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase,Integer> {
}
