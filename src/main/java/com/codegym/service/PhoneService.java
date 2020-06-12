package com.codegym.service;

import com.codegym.model.Phones;
import com.codegym.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional
public class PhoneService implements IPhoneService {
    @Autowired
    ISmartPhoneRepository smartPhoneRepository;
    @PersistenceContext
    EntityManager en;

    @Override
    public Iterable<Phones> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Phones getPhoneById(Long id) {
        return smartPhoneRepository.findOne(id);
    }

    @Override
    public Phones save(Phones model) {
        if (model.getId() != null) {
            en.merge(model);
        } else {
            en.persist(model);
        }
        return model;
    }

    @Override
    public Phones delete(Long id) {
        Phones phones = smartPhoneRepository.findOne(id);
        if (phones != null) {
            smartPhoneRepository.delete(id);
        }
        return phones;
    }
}
