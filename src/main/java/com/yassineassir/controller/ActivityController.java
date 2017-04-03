package com.yassineassir.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yassineassir.controller.action.Action;
import com.yassineassir.controller.action.impl.CreateAction;
import com.yassineassir.controller.action.impl.DeleteAction;
import com.yassineassir.controller.action.impl.ReadAction;
import com.yassineassir.controller.action.impl.UpdateAction;

public class ActivityController extends HttpServlet {

   private HashMap<String, Action> actions;

   @Override
   public void init() throws ServletException {
      // TODO Enumeration ? Constants ?
      actions = new HashMap<>();
      actions.put("create.do", new CreateAction());
      actions.put("update.do", new UpdateAction());
      actions.put("read.do", new ReadAction());
      actions.put("delete.do", new DeleteAction());
   }

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String action = getActionFromPath(req.getServletPath());
      // TODO Validate if equals one of the predefined actions
      if (action != null) {
         actions.get(action)
               .execute(req, resp);
      } else {
         resp.getWriter().write("euuh euuh ! excuse me? check your action!");
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }

   static String getActionFromPath(String servletPath) {
      String[] splittedPath = servletPath.split("/");
      String action = splittedPath[2];
      return action;
   }
}