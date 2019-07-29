<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">EMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item ">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <% if(session.getAttribute("username")!=null) { %>
        <li class="nav-item">
        <a class="nav-link" href="#">Profile</a>
      </li>
        <li class="nav-item">
        <a class="nav-link" href="./employees">Employees</a>
      </li>
      <%} %>
     
    </ul>
    <%if(session.getAttribute("username")!=null) { %>
    <% System.out.println(session.getAttribute("username")); %>
    <ul class="navbar-nav my-2 my-lg-0">
      <li class="nav-item ">
        <a class="nav-link" href="./logout">Logout</a>
      </li>
    </ul>
		<%} else{ %>
    <ul class="navbar-nav my-2 my-lg-0">
      <li class="nav-item ">
        <a class="nav-link" href="./login">Login</a>
      </li>
    </ul>
    <% } %>
  </div>
</nav>