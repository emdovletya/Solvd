package com.solvd.ITCompany.utils.filters;

import java.util.List;

public interface Filter<E> {
    List<E> apply(List<E> e);
}
