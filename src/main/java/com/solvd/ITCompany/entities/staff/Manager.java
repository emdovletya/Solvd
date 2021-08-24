package com.solvd.ITCompany.entities.staff;

import com.solvd.ITCompany.entities.Project;
import com.solvd.ITCompany.entities.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.ITCompany.utils.Helper;
import com.solvd.ITCompany.utils.enums.Complexity;
import com.solvd.ITCompany.utils.enums.Gender;
import com.solvd.ITCompany.utils.enums.JobType;
import com.solvd.ITCompany.utils.enums.Seniority;
import com.solvd.ITCompany.utils.exceptions.NotNullException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Manager extends BaseEmployee implements IManager, ProjectMember {
    private Project project;

    private static final Logger LOGGER = LogManager.getLogger(Manager.class);

    public Manager(String name, Gender gender, double salary, Project project) {
        super(name, gender, salary);
        this.setProject(project);
    }

    public Task generateTask() {
        int totalTaskCount = this.project.getTasks().size();
        String taskName = "Task " + (int) (totalTaskCount + 1);
        JobType type = Helper.randomEnum(JobType.class);
        Complexity complexity = Helper.randomEnum(Complexity.class);
        double duration = Math.pow(totalTaskCount, 0.5) + complexity.getCode() * 5;

        return new Task(taskName, type, complexity, duration);
    }

    private void hire(JobType type, Seniority seniority) {
        Random rand = new Random();
        String name = "Name " + rand;
        Gender gender = Helper.randomEnum(Gender.class);
        double salary = type.getCode() * 100 + seniority.getCode() * 1000;
        Executor e = new Executor(name, gender, salary, type, seniority);
        e.setProject(this.project);
        this.project.addExecutor(e);
    }

    private void hireDepartmentByCounts(JobType type, int seniorsCount, int middleCount, int juniorsCount) {
        for (int i = 0; i < seniorsCount; i++) {
            hire(type, Seniority.SENIOR);
        }
        for (int i = 0; i < middleCount; i++) {
            hire(type, Seniority.MIDDLE);
        }
        for (int i = 0; i < juniorsCount; i++) {
            hire(type, Seniority.JUNIOR);
        }
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
    public void addTask() {
        if (project == null) {
            throw new NotNullException();
        }
        Task task = this.generateTask();

        project.addTask(task);
    }

    @Override
    public void formTeam() {
        Map<JobType, Integer> tasksTypesMap = new HashMap<JobType, Integer>();
        for (Task t : project.getTasks()) {
            int count = tasksTypesMap.containsKey(t.getType()) ? tasksTypesMap.get(t.getType()) : 0;
            int increment = t.getRank().getCode();
            tasksTypesMap.put(t.getType(), count + increment);
        }

        for (Map.Entry<JobType, Integer> entry : tasksTypesMap.entrySet()) {
            int seniorLevelCount = (int) Math.floor(entry.getValue() * 0.1);
            int middleLevelCount = (int) Math.floor(entry.getValue() * 0.4);
            int juniorLevelCount = (int) Math.floor(entry.getValue() * 0.5);

            LOGGER.error("[" + entry.getKey() + "] Seniors: " + seniorLevelCount + "; Middles: " + middleLevelCount
                    + "; Juniors:" + juniorLevelCount);

            hireDepartmentByCounts(entry.getKey(), seniorLevelCount, middleLevelCount, juniorLevelCount);
        }
    }
}
