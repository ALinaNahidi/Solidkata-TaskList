package com.codurance.training.tasks.services;

import com.codurance.training.tasks.Task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface TaskListService {
      Map<String, List<Task>> tasks = new LinkedHashMap<>();

}
