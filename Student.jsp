<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student</title>
  <style>
      body {
          font-family: Arial, sans-serif;
          background-color: #f4f4f4;
          margin: 0;
          padding: 0;
          display: flex;
          flex-direction: column;
          align-items: center;
          justify-content: center;
          height: 100vh;
      }

      .dashboard {
          max-width: 820px; /* 600px + 2*35px (padding on both sides) */
          padding: 20px;
          background-color: #fff;
          border-radius: 5px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
          text-align: center;
          margin: 0 auto; /* Center the container */
      }

      .date-time {
          font-size: 16px;
      }

      .welcome {
          font-size: 20px;
          margin-top: 20px;
      }

      .logout {
          color: #3498db;
          cursor: pointer;
          margin-top: 10px;
          text-decoration: underline;
      }

      .registration {
          margin-top: 20px;
          font-size: 18px;
      }

      .registration a {
          color: #3498db;
          text-decoration: underline;
          cursor: pointer;
      }

      form {
          margin-top: 10px;
          display: grid;
          grid-template-columns: 1fr 1fr;
          grid-gap: 10px;
      }

      input, button {
          width: 100%;
          padding: 10px;
          box-sizing: border-box;
      }

      table {
          width: 100%;
          margin-top: 20px;
          border-collapse: collapse;
      }

      th, td {
          border: 1px solid #ddd;
          padding: 8px;
          text-align: left;
      }

      th {
          background-color: #f2f2f2;
      }

      .scores-link {
          color: #3498db;
          text-decoration: underline;
          cursor: pointer;
      }
  </style>
</head>
<body>
     <h1>
         
         <%= (new java.util.Date()).toLocaleString()%>
     </h1>
     <p><a href="http://localhost:3311/logout">Log out</a></p>
     <sec:authorize access="hasAuthority('ADMIN')">
    <h3><a href="http://localhost:3311/registration">Registration of a new user</a></h3>
        <form  action="StudentAdd">
            <table>
                <tbody>
                    <tr>
                        <td><label for="name">Name</label></td>
                        <td><input id="name" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><label for="surname">Surname</label></td>
                        <td><input id="surname" type="text" name="surname"></td>
                    </tr>
                     <tr>
                        <td><label for="email">Age</td>
                        <td><input id="age" type="text" name="age"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input id="email" type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td><label for="group">Group</label></td>
                        <td><input id="group" type="text" name="group"></td>
                    </tr>
                    <tr>
                        <td><label for="faculty">Faculty</label></td>
                        <td><input id="faculty" type="text" name="faculty"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="send" value="Відправити">
        </form>
    </sec:authorize>

<sec:authorize access="isAuthenticated()">
  <sec:authentication property="principal.username" var="username" />
  <p>Welcome, <c:out value="${username}" />!</p>
    <div id="content">
            <table class="list">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Age</th>
                    <th>Email</th>
                    <th>Group</th>
                    <th>Faculty</th>
                </tr>
                <c:forEach var="student" items="${students}">
                    <c:if test="${student.getEmail() eq username || username eq 'admin'}"
                    <tr>    
                        <td><c:out value="${student.getId()}"/></td>
                        <td><c:out value="${student.getName()}"/></td>
                        <td><c:out value="${student.getSurname()}"/></td>
                        <td><c:out value="${student.getAge()}" /></td>
                        <td><c:out value="${student.getEmail()}"/></td>
                        <td><c:out value="${student.getGroup()}"/></td>
                        <td><c:out value="${student.getFaculty()}"/></td>
                        <td><a href="/UserContent?id2=${student.getId()}">View Grades</a></td>
                    </tr>
                    </c:if>
                   
                </c:forEach>
            </table>
    </div>
    </sec:authorize>
</body>
</html>
