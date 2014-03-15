<%-- 
    Document   : hello
    Created on : Mar 10, 2014, 9:46:07 PM
    Author     : Mandeep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.css"/>                
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.css"/>                                
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootswatch.css"/>     
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styles.css"/>   
        <title>Letters</title>
    </head> 
    <body class="preview" id="top" data-spy="scroll" data-target=".subnav" data-offset="80">
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="./">Letters</a>
                        <button data-target="#navbar-main" data-toggle="collapse" type="button" class="navbar-toggle">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div id="navbar-main" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a id="themes" href="#" data-toggle="dropdown" class="dropdown-toggle">Menu<span class="caret"></span></a>
                                <ul aria-labelledby="themes" class="dropdown-menu">
                                    <li><a href="../default/">About App</a></li>
                                    <li class="divider"></li>                                    
                                    <li><a href="./">List</a></li>
                                    <li><a href="./add">Add</a></li>
                                </ul>
                            </li>                                                      
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="page-header">
                <h1>Letters > List</h1>
            </div>
            <div class="row">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>To</th>
                            <th>From</th>
                            <th>Subject</th>
                            <th>Body</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${letters}" var="letters">
                            <tr>
                                <td><c:out value="${letters.to}"/></td>
                                <td><c:out value="${letters.from}"/></td>
                                <td><c:out value="${letters.subject}"/></td>
                                <td><c:out value="${letters.body}"/></td>
                                <td>
                                    <a href="./delete?id=${letters.id}" class="letter-delete-btn"><button class="btn btn-danger btn-xs " type="button" >Delete</button></a>
                                    <a href="./edit?id=${letters.id}"><button class="btn btn-info btn-xs" type="button" >Update</button></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>        
    </body>    
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>   
    <script src="<%=request.getContextPath()%>/resources/js/bootbox.js"></script>   

    <script>
        $(document).ready(function() {
            $(".letter-delete-btn").click(function(e) {
                e.preventDefault();
                var url = $(this).attr('href');
                bootbox.confirm("Are you sure?", function(confirmed) {
                    if (confirmed) {
                        window.open(url);
                    }
                });
            });
        });

    </script>
</html>
