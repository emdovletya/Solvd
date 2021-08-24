package com.solvd.ITCompany.entities;

import com.solvd.ITCompany.utils.Helper;
import com.solvd.ITCompany.utils.exceptions.EmptyStringException;

public abstract class BaseEntity {
    private String name;

    public BaseEntity(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Helper.isEmptyString(name)) {
            throw new EmptyStringException();
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return ("Entity: " + name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        BaseEntity guest = (BaseEntity) obj;
        return name == guest.name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
