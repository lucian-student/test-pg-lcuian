<html>
<body>
<%
int num_of_ovecek=Integer.parseInt(request.getParameter("num_of_ovecek"));
String result = "";
boolean first = num_of_ovecek<1;
boolean second = num_of_ovecek==1;
boolean third = num_of_ovecek<5;
if(first){
    result="wrong input";
}else if(second){
    result=num_of_ovecek+" ovecka";
}else if(third){
    result=num_of_ovecek+" ovecky";
}else{
    result=num_of_ovecek+" ovecek";
}
%>
<p>
<%=result%>
</p>
</body>
</html>
