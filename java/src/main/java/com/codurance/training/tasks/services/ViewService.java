package com.codurance.training.tasks.services;

import java.util.Date;

public interface ViewService {
     void show();
     void viewToday();
     void viewByDeadline(Date deadline);

     void viewByDate(Date date);
}
