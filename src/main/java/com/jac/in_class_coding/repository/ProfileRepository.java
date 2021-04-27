package com.jac.in_class_coding.repository;

import com.jac.in_class_coding.entity.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,Integer> {
}
