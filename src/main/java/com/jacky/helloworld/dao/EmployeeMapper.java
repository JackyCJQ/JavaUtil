package com.jacky.helloworld.dao;

import com.jacky.helloworld.bean.Employee;

public interface EmployeeMapper {

    Employee getEmpById(Integer id);
}
