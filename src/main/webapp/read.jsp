<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <title>Show Activities</title>
</head>
<body>
   <c:forEach items="${activities}" var="activity">
      ${activity.name}<br>
      ${activity.description}<br>
      ${activity.type}<br>
   </c:forEach>
</body>
</html>
