package com.solvd.ITCompany.utils.filters;

import com.solvd.ITCompany.utils.enums.JobType;
import com.solvd.ITCompany.utils.interfaces.Typeable;

import java.util.ArrayList;
import java.util.List;

public class JobTypeFilter implements Filter<Typeable> {
    private JobType type;

    public JobTypeFilter(JobType type) {
        this.type = type;
    }

    @Override
    public List<Typeable> apply(List<Typeable> e) {
        List<Typeable> filtered = new ArrayList<Typeable>();
        if (e != null) {
            for (Typeable entity : e) {
                if (this.type.equals(entity.getType())) {
                    filtered.add(entity);
                }
            }
        }
        return filtered;
    }
}
