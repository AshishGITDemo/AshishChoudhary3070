<%@ page isELIgnored="false" import="java.util.*,com.nt.beans.*" %>

<%
  //read the request attribute value
  List<Employee> list = (List<Employee>)request.getAttribute("empInfo");
  //read the request param value
  String desg = request.getParameter("desg");
  if(list.size()!=0 && list!=null){
%>
    <!-- Display the details in the form of html table -->
    <table border="1" bgcolor="cyan" align="center">
      <tr>
        <th>empno</th><th>ename</th><th>job</th><th>salary</th><th>gross slary</th><th>net salary</th>
      </tr>
 <% 
     for(Employee emp:list){%>
      <tr>
        <td><%=emp.getEmpNo()%></td>
        <td><%=emp.getEmpName()%></td>
        <td><%=emp.getDesg()%></td>
        <td><%=emp.getSalary()%></td>
        <td><%=emp.getGrossSalary()%></td>
        <td><%=emp.getNetSalary()%></td>
      </tr>
<%   } 
%>
 
    </table>
<% }//if
   else{ %>
     <h1 style="color:red;text-align:center">No Employees are found</h1>
 <%} %>    
 <br><br>
 
   <script language="JavaScript">
     function showPrint(){
    	 frames.focus();  //frames in javascript is built-in object
    	 frames.print();
     }
   </script>
   
   <h1 style="color:red;text-align:center"><a href="JavaScRipt:showPrint()">print</a></h1>
