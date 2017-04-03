package com.yassineassir.service;

import java.util.List;
import com.yassineassir.model.Activity;

public interface ActivityService {
   void create(Activity activity);

   List<Activity> populateActivities();

   void delete(int id);

   void update(Activity activity);

   Activity getById(int id);
}
