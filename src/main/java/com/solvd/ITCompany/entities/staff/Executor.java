package com.solvd.ITCompany.entities.staff;

import com.solvd.ITCompany.entities.Project;
import com.solvd.ITCompany.utils.enums.Gender;
import com.solvd.ITCompany.utils.enums.JobType;
import com.solvd.ITCompany.utils.enums.Seniority;
import com.solvd.ITCompany.utils.exceptions.NotNullException;
import com.solvd.ITCompany.utils.interfaces.Rankable;
import com.solvd.ITCompany.utils.interfaces.Typeable;

public class Executor extends BaseEmployee implements Typeable<JobType>, Rankable<Seniority>, ProjectMember {
    private JobType type;
    private Seniority rank;
    private Project project;

    public Executor(String name, Gender gender, double salary, JobType type, Seniority rank) {
        super(name, gender, salary);
        this.setType(type);
        this.setRank(rank);
    }

    @Override
    public void setProject(Project project) {
        if (project == null) {
            throw new NotNullException();
        }
        this.project = project;
    }

    @Override
    public Project getProject() {
        return project;
    }

    @Override
    public JobType getType() {
        return type;
    }

    @Override
    public void setType(JobType type) {
        this.type = type;
    }

    @Override
    public void setRank(Seniority rank) {
        this.rank = rank;
    }

    @Override
    public Seniority getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return super.toString() + "; type: " + type + "; rank: " + rank + "; project: " + project.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Executor guest = (Executor) obj;
        boolean b = (super.equals(guest) && type == guest.type && rank == guest.rank);
        return b;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + type.getCode() + rank.getCode();
    }
}
