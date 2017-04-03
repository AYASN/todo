<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Delete Activity</title>
</head>
<body>
   <h1>Are you sure to delete <i>${param.name}</i> activity ?</h1>
   <form action="activity/delete.do" method="post">
      <input type="hidden" name="id" value="${param.id}">
      <div><input type="submit" name="yes" value="Yes"></div>
      <div><input type="submit" name="no" value="No"></div>
   </form>
</body>
</html>