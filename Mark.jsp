<%@page import="java.util.List"%>
<%@page import="sumdu.edu.ua.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student marks</title>
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
        
        <c:forEach items="${students}" var="user">
        <c:if test="${not empty students}">
        <h1>Scores of <c:out value ="${user.getId()}"/> <c:out value ="${user.getName()}"/> <c:out value ="${user.getSurname()}"/></h1>
        </c:if>
        </c:forEach>
        
        <div id="grades">
                <table class = "list">
                    <tr>
                        <th>Discipline</th>
                        <th>Mark</th>
                        <th>ECTS</th>
                    </tr>
                     <c:forEach items="${marks}" var="student">
                        <tr>
                            <td><c:out value ="${student.getTitle()}"/></td>
                            <td><c:out value ="${student.getMakr()}"/></td>
                            <td><c:out value ="${student.getMakr_let()}"/></td>
                        </tr>
                   </c:forEach>
                </table>

        </div>
    </body>
</html>
