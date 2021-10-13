<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Manager Account</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/manager.css" rel="stylesheet" type="text/css"/>
        <style>
            img{
                width: 200px;
                height: 120px;
            }
        </style>
</head>
<body>
  <div class="container">
            <div class="table-wrapper">
            <form action="delLstAcc" method="get">
                <div class="table-title">
                    <div class="row">
                        <div class="col-sm-6">
                            <h2>Manage <b>Account</b></h2>
                        </div>
             
                        <div class="col-sm-6">
                        <input class="btn btn-danger" type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete');">
                        </div>
                    </div>
                </div>
                
                 <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>
                               <span class="custom-checkbox">
                                    <input type="checkbox" id="selectAll">
                                    <label for="selectAll"></label>
                                </span>
                            </th>
                            <th>user name</th>
                            <th>Full namw</th>
                            <th>gender</th>
                            <th>Phone</th>
                            <th>Mail</th>
                            <th>Address</th>
                            <th>Is admin</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${dsa }" var="o">
                            <tr>
                                <td>
                                    <span class="custom-checkbox">
                                        <input type="checkbox" id="checkbox1" name="options" value="${o.tenTK }">
                                        <label for="checkbox1"></label>
                                    </span>
                                </td>
                                <td>${o.tenTK }</td>
                                <td>${o.ten }</td>
                                <td>
                                	<select>
                                	<c:if test="${o.phai ==0}">
                                		<option value="0" selected="selected">nam</option>
                                		<option value="1">nu</option>
                                	</c:if>
                                	<c:if test="${o.phai ==1}">
                                		<option value="0" >nam</option>
                                		<option value="1" selected="selected">nu</option>
                                	</c:if>
                                	</select>
                                </td>
                                <td>${o.sdt }</td>
                                <td>${o.mail }</td>
                                <td>${o.dc }</td>
                                
                                <td>
                                	<c:if test="${o.isAdmin==0 }">
                                		<label>unadmin</label>
                                	</c:if>
                                	<c:if test="${o.isAdmin==1 }">
                                		<label>is admin</label>
                                	</c:if>
                                </td>
                                <td>
                                    <a href="editAccount?ida=${o.tenTK }"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
									<a href="DelAcc.html?ida=${o.tenTK }" onclick="return confirm('Are you sure you want to delete this account?');" class="delete" data-toggle="modal">
										<i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i>
									</a>                                
								</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                </form>
 				<div class="clearfix">
                    <div class="hint-text">Showing <b>5</b> out of <b>${tongsp}</b> entries</div>
                    <ul class="pagination">
                        <c:forEach begin="1" end="${tongSoTrang }" var="trang">
                    		<li class="page-item">
								<a class="page-link" href="account?trang=${trang }">${trang}</a>
							</li>
                    	</c:forEach>
                    </ul>
                </div>
            </div>
            <a href="index.html" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Back to home</a>
        </div>
           <script src="js/manager.js" type="text/javascript"></script>
       <script type="text/javascript">
       $("#selectAll").click(function(){
    	    $('input:checkbox').not(this).prop('checked', this.checked);
    	});
       </script>
</body>
</html>