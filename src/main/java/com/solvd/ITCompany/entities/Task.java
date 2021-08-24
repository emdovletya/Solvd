package com.solvd.ITCompany.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.ITCompany.utils.enums.Complexity;
import com.solvd.ITCompany.utils.enums.JobType;
import com.solvd.ITCompany.utils.interfaces.Rankable;
import com.solvd.ITCompany.utils.interfaces.Typeable;

public class Task extends BaseEntity implements Typeable<JobType>, Rankable<Complexity> {
    private JobType type;
    private Complexity rank;
    private double duration = 0;

    private static final Logger LOGGER = LogManager.getLogger(Task.class);

    public Task(String name, JobType type, Complexity rank, double duration) {
        super(name);
        this.setType(type);
        this.setRank(rank);
        this.setDuration(duration);

        LOGGER.error("Task [name: " + name + "; type: " + type + "; rank: "
                + rank + "; duration: " + duration + "] Created!");
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDuration() {
        return duration;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    @Override
    public JobType getType() {
        return this.type;
    }

    @Override
    public void setRank(Complexity rank) {
        this.rank = rank;
    }

    @Override
    public Complexity getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return super.toString() + "; type: " + type + "; rank: "
                + rank + "; duration: " + duration;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Task guest = (Task) obj;
        boolean b = (super.equals(guest) && type == guest.type
                && rank == guest.rank && duration == guest.duration);
        return b;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + (int) duration + rank.getCode() + type.getCode();
    }
}
