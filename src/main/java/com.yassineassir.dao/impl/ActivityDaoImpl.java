package com.yassineassir.dao.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.yassineassir.dao.ActivityDao;
import com.yassineassir.model.Activity;

public class ActivityDaoImpl implements ActivityDao {
   private static Map<Integer, Activity> activities = new HashMap<Integer, Activity>();
   private static Integer activityId = 0;

   public void insert(Activity activity) {
      activity.setId(activityId);
      activities.put(activityId, activity);
      activityId++;
   }


   public Activity getById(Integer id) {
      return activities.get(id);
   }

   public List<Activity> getActivities() {
      return new ArrayList<>(activities.values());
   }

   public void delete(int id) {
      activities.remove(id);
   }

   public void update(Activity activity) {
      int id = activity.getId();
      activities.put(id, activity);
   }
}
