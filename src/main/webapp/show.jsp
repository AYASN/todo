<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
   <link rel="stylesheet" href="styles/css/bootstrap.min.css">
   <link rel="stylesheet" href="styles/css/bootstrap-theme.min.css">
</head>
<body>
   <h1>Welcome Page</h1>
   <c:set var="context" value="${pageContext.request.contextPath}" />
   <a href="${context}/create.jsp">New activity</a>

   <c:if test="${fn:length(activities) gt 0}">
      <h2> Recent Activities :</h2>
      <table class="table table-bordered">
         <thead>
            <tr>
               <th>Name</th>
               <th>Description</th>
               <th>Type</th>
               <th>Actions</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach items="${activities}" var="activity">
               <tr>
                  <td>${activity.name}</td>
                  <td>${activity.description}</td>
                  <td>${activity.type}</td>
                  <td>
                     <a href='${context}/delete.jsp?name=${activity.name}&id=${activity.id}'>Delete</a>
                     <a href='${context}/activity/update.do?id=${activity.id}'>Update</a>
                  </td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
   </c:if>
</body>
</html>
