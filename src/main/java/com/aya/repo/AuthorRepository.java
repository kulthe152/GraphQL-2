package com.aya.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aya.Model.Authors;

public interface AuthorRepository extends JpaRepository<Authors, Integer> {

	Authors findById(int id);
}
