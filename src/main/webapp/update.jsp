<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Edit Activity</title>
</head>
<body>
   <h2>Update Activity Form :</h2>
   <form action="${pageContext.request.contextPath}/activity/update.do" method="post">
      <div><input type="hidden" name="id" value="${activity.id}" /></div>
      <div>Name: <input type="text" name="name" value="${activity.name}"></div>
      <div>Description: <input type="text" name="description" value="${activity.description}"></div>
      <div>Type: <input type="text" name="type" value="${activity.type}"></div>
      <div><input type="submit" value="ok"></div>
   </form>
</body>
</html>