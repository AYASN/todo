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

public class DeleteAction implements Action {
   private final ActivityService activityService;

   public DeleteAction() {
      activityService = new ActivityServiceImpl();
   }

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      String choice = request.getParameter("yes");
      int id = Integer.parseInt(request.getParameter("id"));

      if (isValid(choice)) {
            activityService.delete(id);
      }

      List<Activity> activities = activityService.populateActivities();
      request.setAttribute("activities", activities);
      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/show.jsp");
      requestDispatcher.forward(request, response);
   }

   private boolean isValid(String choice) {
      return choice != null && choice.equals("Yes");
   }
}