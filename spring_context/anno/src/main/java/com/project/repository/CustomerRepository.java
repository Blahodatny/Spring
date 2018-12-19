package com.project.repository;

import java.util.List;

public interface CustomerRepository {
    List<com.project.model.Customer> findAll();
}