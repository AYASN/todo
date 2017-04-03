package com.yassineassir.service.impl;

import java.util.List;
import com.yassineassir.dao.ActivityDao;
import com.yassineassir.dao.impl.ActivityDaoImpl;
import com.yassineassir.model.Activity;
import com.yassineassir.service.ActivityService;

public class ActivityServiceImpl implements ActivityService {

   private static ActivityDao activityDao = new ActivityDaoImpl();

   public void create(Activity activity) {
      activityDao.insert(activity);
   }

   public void delete(int id) { activityDao.delete(id); }

   public void update(Activity activity) { activityDao.update(activity); }

   public Activity getById(int id) {
      return activityDao.getById(id);
   }

   public List<Activity> populateActivities() {
      return activityDao.getActivities();
   }
}
