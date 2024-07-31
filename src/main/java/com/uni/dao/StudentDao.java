package com.uni.dao;

import java.util.List;

import com.uni.entity.Student;

public interface StudentDao {
public void insert();
public void update();
public void delete();
public List<Student> read();
}
