package com.deneme.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deneme.Model.Television;

@Repository
public interface TelevisionRepository extends JpaRepository<Television, Integer>{
}
