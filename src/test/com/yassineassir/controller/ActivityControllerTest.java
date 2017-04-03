package com.yassineassir.controller;

import org.junit.Assert;
import org.junit.Test;

public class ActivityControllerTest {
   @Test
   public void should_return_action_from_servlet_path() {
      String servletPath = "/activity/create.do";
      String actionFromPath = ActivityController.getActionFromPath(servletPath);
      Assert.assertEquals("create.do", actionFromPath);
   }
}
