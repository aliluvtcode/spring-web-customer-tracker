<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /><!-- the full path of the css file -->
			<!-- ${pageContext.request.contextPath} give the reall name of the app -->

</head>

<style type="text/css">
body{
		
				color:black;
				background:#a0c;
		
		}
		
		#b13{
				height:30px;
				width:300px;
				border-width: 5px 3px 5px 3px;
				border-style: solid dotted double inset;
				border-color: red yellow black green ;
				border-radius:15px;
</style>

<body>

	<div id="wrapper"><!-- its necessary for css -->
		<div id="header"><!-- its necessary for css -->
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container"><!-- its use to hold the HTML for our application -->
	
		<div id="content"><!-- its use to hold the HTML for our application -->
		
			
			<!-- put new button: Add Customer -->
		<security:authorize access="hasRole('ADMIN')"><!-- we add it here to make it shows it specific for ADMIN role -->
			<input type="button" value="Add Customer"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
			</security:authorize>
			
			<!-- Add a logout button -->
		<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" class="add-button" />
	
		</form:form>
	


			 <!--   add a search box -->
			<form:form action="search" method="POST">
				Search customer: <input type="text" name="theSearchName" id="b13" placeholder="Enter First name or Last name "/>
 
 				<input type="submit" value="Search" class="add-button" />
				 </form:form>
				 
				 
				 
				 
				 
			<!--  add our html table here -->
			<br><br>
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}"><!-- we took customers from the {theModel.addAttribute("customers",theCustomers);} in the CustomerController and tempCustomer its only name we gave it  -->
																			
				
				
				<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>			
					
				<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}" />
					</c:url>	
						
					
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						
						<td>
						<!-- Add a link to point to /leaders ... this is for the managers -->
	
							<security:authorize access="hasRole('MANAGER')"><!-- we add it here to make it shows it specific for MANAGER role -->
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
							</security:authorize>
							
						</td>
																	 
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









