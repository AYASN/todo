package com.yassineassir.controller.action.impl;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassineassir.controller.action.Action;
import com.yassineassir.model.Activity;
import com.yassineassir.service.ActivityService;
import com.yassineassir.service.impl.ActivityServiceImpl;

public class ReadAction implements Action {
   private final ActivityService activityService;

   public ReadAction() {
      activityService = new ActivityServiceImpl();
   }

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
      activityService.create(new Activity());
      response.getWriter().write("I read Stuff");
   }
}
