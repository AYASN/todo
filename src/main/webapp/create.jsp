<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>Create Activity</title>
</head>
<body>
   <h2>New Activity Form :</h2>
   <form action="activity/create.do" method="post">
      <div>Name: <input type="text" name="name"></div>
      <div>Description: <input type="text" name="description"></div>
      <div>Type: <input type="text" name="type"></div>
      <div><input type="submit" value="ok"></div>
   </form>
</body>
</html>