package com.solvd.ITCompany.entities.staff;

import com.solvd.ITCompany.entities.BaseEntity;
import com.solvd.ITCompany.utils.constants.DateConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.ITCompany.utils.enums.Gender;
import com.solvd.ITCompany.utils.exceptions.NotNegativeNumberException;

public abstract class BaseEmployee extends BaseEntity {
    private Gender gender;
    private double salary;

    private static final Logger LOGGER = LogManager.getLogger(BaseEmployee.class);

    public BaseEmployee(String name, Gender gender, double salary) {
        super(name);
        this.setGender(gender);
        this.setSalary(salary);

        LOGGER.error("Employee [name: " + name + "; gender: " + gender + "; salary: " + salary + "] Created!");
    }

    private Gender getGender() {
        return gender;
    }

    private void setGender(Gender gender) {
        this.gender = gender;
    }

    private double getSalary() {
        return salary;
    }

    public double getSalaryPerHour() {
        return salary / DateConstant.HOURS_PER_WORK_DAY / DateConstant.WORK_DAYS_IN_MONTH;
    }

    private void setSalary(double salary) {
        if (salary < 0) {
            throw new NotNegativeNumberException();
        }
        this.salary = salary;
    }

    @Override
    public String toString() {
        return ("Employee: " + super.getName() + "; gender: " + gender + "; salary: " + this.salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        BaseEmployee guest = (BaseEmployee) obj;
        boolean b = (super.getName() == guest.getName()
                && gender == guest.gender
                && salary == guest.salary);
        return b;
    }

    @Override
    public int hashCode() {
        return super.getName().hashCode() + gender.getCode() + (int) salary;
    }
}
