package com.codegym.repository;

import com.codegym.model.Phones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartPhoneRepository extends CrudRepository<Phones, Long> {
}
