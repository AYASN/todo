package com.yassineassir.dao.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

import java.util.List;
import org.junit.Test;
import com.yassineassir.dao.ActivityDao;
import com.yassineassir.model.Activity;

public class ActivityDaoImplTest {

   @Test
   public void should_insert_activity() {
      Activity activity = activityDummy("Calisthenics", "Sport", "Follow the beginner workout program");
      ActivityDao activityDao = new ActivityDaoImpl();

      activityDao.insert(activity);

      Activity result = activityDao.getById(0);

      assertEquals("Sport", result.getType());
   }

   @Test
   public void should_populate_activities() {
      ActivityDaoImpl activityDao = new ActivityDaoImpl();
      for (int i = 0; i < 10; i++) {
         Activity activity = activityDummy("Exercise " + i , "Homework " + i , "Answering questions " + i );
         activityDao.insert(activity);
      }

      List<Activity> activities = activityDao.getActivities();

      assertThat(activities.size(), is(10));
//      assertThat(activities, not(IsMapContaining.hasValue(activityDummy("a","b","c"))));
   }

   private Activity activityDummy(String name, String type, String description) {
      Activity activity = new Activity();
      activity.setName(name);
      activity.setType(type);
      activity.setDescription(description);
      return activity;
   }
}
