package com.yassineassir.controller.action.impl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassineassir.controller.action.Action;
import com.yassineassir.model.Activity;
import com.yassineassir.service.ActivityService;
import com.yassineassir.service.impl.ActivityServiceImpl;

public class CreateAction implements Action {

   private final ActivityService activityService;

   public CreateAction() {
      activityService = new ActivityServiceImpl();
   }

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      Activity activity = buildActivity(request);
      activityService.create(activity);
      request.setAttribute("activities", activityService.populateActivities());
      request.setAttribute("contextPath", request.getContextPath());
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
}
