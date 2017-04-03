package com.yassineassir.controller.action.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassineassir.controller.action.Action;
import com.yassineassir.model.Activity;
import com.yassineassir.service.ActivityService;
import com.yassineassir.service.impl.ActivityServiceImpl;

public class UpdateAction implements Action {
   private final ActivityService activityService;

   public UpdateAction() {
      activityService = new ActivityServiceImpl();
   }

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      String method = request.getMethod();
      if (method.equalsIgnoreCase("get")) {
         updateWhenGet(request, response);
      } else {
         updateWhenPost(request, response);
      }
   }

   private void updateWhenPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

      Activity activity = buildActivity(request);
      activityService.update(activity);
      List<Activity> activities = activityService.populateActivities();
      request.setAttribute("activities", activities);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/show.jsp");
      requestDispatcher.forward(request, response);
   }

   private Activity buildActivity(HttpServletRequest request) {
      Activity activity = new Activity();
      String name = request.getParameter("name");
      String description = request.getParameter("description");
      String type = request.getParameter("type");
      activity.setName(name);
      activity.setDescription(description);
      activity.setType(type);
      return activity;
   }

   private void updateWhenGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id = Integer.parseInt(request.getParameter("id"));
      Activity activity = activityService.getById(id);

      request.setAttribute("activity", activity);
      RequestDispatcher requestDispatcher =
            request.getRequestDispatcher("/update.jsp");
      requestDispatcher.forward(request, response);
   }
}
