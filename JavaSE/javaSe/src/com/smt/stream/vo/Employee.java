package com.smt.stream.vo;

import java.util.Objects;
import java.util.function.Predicate;

/**
 * 所属项目：JavaSE
 * 所属包：com.smt.stream.vo
 *
 * @author Smart-T
 * @since 2020/9/27
 */
public class Employee {

    Integer id;

    Character gender;

    String empName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Employee() {
    }

    public Employee(Integer id, Character gender, String empName) {
        this.id = id;
        this.gender = gender;
        this.empName = empName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(gender, employee.gender) &&
                Objects.equals(empName, employee.empName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gender, empName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", gender=" + gender +
                ", empName='" + empName + '\'' +
                '}';
    }

    public static Predicate<Employee> idGreaterThan04 = emp -> emp.getId() > 4 ;

    public static Predicate<Employee> genderF = emp -> emp.getGender().toString().equals("F") ;

}
