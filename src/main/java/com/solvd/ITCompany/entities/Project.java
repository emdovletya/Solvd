package com.solvd.ITCompany.entities;

import com.solvd.ITCompany.entities.staff.Executor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.ITCompany.utils.exceptions.NotNullException;

import java.util.ArrayList;

public class Project extends BaseEntity {
    private ArrayList<Executor> executors;
    private ArrayList<Task> tasks;

    private static final Logger LOGGER = LogManager.getLogger(Project.class);

    public Project(String name) {
        super(name);
        this.tasks = new ArrayList<Task>();
        this.executors = new ArrayList<Executor>();

        LOGGER.error("Project [name: " + name + "] Created!");
    }

    public void addExecutor(Executor executor) {
        if (executor == null) {
            throw new NotNullException();
        }
        this.executors.add(executor);
    }

    public ArrayList<Executor> getExecutors() {
        return this.executors;
    }

    public void addTask(Task task) {
        if (task == null) {
            throw new NotNullException();
        }
        this.tasks.add(task);
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    @Override
    public String toString() {
        return super.toString() + "; tasks count: "
                + tasks.size() + "; executors count: " + executors.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Project guest = (Project) obj;
        boolean b = (super.equals(guest) && tasks.size() == guest.tasks.size()
                && executors.size() == guest.executors.size());
        return b;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + executors.size() + tasks.size();
    }
}
