<%-- 
    Document   : hello
    Created on : Mar 10, 2014, 9:46:07 PM
    Author     : Mandeep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <body class="preview" id="top" data-spy="scroll" data-target=".subnav" data-offset="80" >       
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
                                <a id="themes" href="javascript:void(0);" data-toggle="dropdown" class="dropdown-toggle">Menu<span class="caret"></span></a>
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
                <h1>Letter > Edit</h1>
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <div class="well bs-component">                    
                        <form:form method="POST" commandName="letter" cssClass="form-horizontal">
                            <form:hidden path="id"/>
                            <%--<form:errors path="*" cssClass="errorblock" element="div"/>--%>
                            <fieldset>
                                <legend>Edit Letter</legend>
                                <div class="form-group">
                                    <form:label path="to" cssClass="col-lg-2 control-label">To</form:label>
                                        <div class="col-lg-10">                                    
                                        <form:input path="to" cssClass="form-control" />
                                        <form:errors path="to" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="form-group">                                
                                    <form:label path="from" cssClass="col-lg-2 control-label">From</form:label>
                                        <div class="col-lg-10">                                    
                                        <form:input path="from" cssClass="form-control" />
                                        <form:errors path="from" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="form-group">                                
                                    <form:label path="subject" cssClass="col-lg-2 control-label">Subject</form:label>
                                        <div class="col-lg-10">                                    
                                        <form:input path="subject" cssClass="form-control" />
                                        <form:errors path="subject" cssClass="text-danger" />
                                    </div>
                                </div>
                                <div class="form-group">                                
                                    <form:label path="body" cssClass="col-lg-2 control-label">Body</form:label>
                                        <div class="col-lg-10">                                    
                                        <form:textarea path="body" cssClass="form-control" rows="5" cols="30" />
                                        <form:errors path="body" cssClass="text-danger" />                                        
                                    </div>
                                </div>

                                <input type="submit" class="btn btn-primary" value="Update"/>
                                <a href="./"><button class="btn btn-default" type="button">Cancel</button></a>

                            </fieldset>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>     
</html>
