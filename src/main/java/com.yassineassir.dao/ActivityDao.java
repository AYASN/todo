package com.yassineassir.dao;

import java.util.List;
import com.yassineassir.model.Activity;

public interface ActivityDao {
   void insert(Activity activity);

   Activity getById(Integer id);

   List<Activity> getActivities();

   void delete(int id);

   void update(Activity activity);
}
