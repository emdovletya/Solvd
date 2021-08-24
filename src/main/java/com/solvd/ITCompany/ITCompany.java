package com.solvd.ITCompany;

import com.solvd.ITCompany.entities.Project;
import com.solvd.ITCompany.entities.Task;
import com.solvd.ITCompany.entities.staff.Executor;
import com.solvd.ITCompany.entities.staff.Manager;
import com.solvd.ITCompany.utils.constants.ProjectConstants;
import com.solvd.ITCompany.utils.enums.Gender;
import com.solvd.ITCompany.utils.enums.JobType;

public class ITCompany {
    public ITCompany() {
    }

    public void initProject(String name) {
        Project project = new Project(name);
        Manager manager = new Manager("Manager", Gender.MALE, 5000, project);
        for (int i = 0; i < ProjectConstants.TASK_COUNT; i++) {
            manager.addTask();
        }
        manager.formTeam();

        this.calc(project);
    }

    private double calc(Project project) {
        double totalProjectTime = 0;
        double getTotalSalary = 0;

        for (Task task : project.getTasks()) {
            totalProjectTime += task.getDuration() / ProjectConstants.TASK_COUNT / JobType.values().length;
        }

        for (Executor e : project.getExecutors()) {
            getTotalSalary += e.getSalaryPerHour();
        }

        return totalProjectTime * getTotalSalary;
    }
}
