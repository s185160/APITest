<%@page import="ModelsPackage.AppointmentModel"%>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java"
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"
%>
<!DOCTYPE html>
<html lang="en"><!DOCTYPE html>
<html lang="en">
<head>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">
    <title>Appointments</title>
</head>
<body>
<div id="header">
    <div id="name-text">Mit Sundhed.dk</div>
</div>
<div id="container">
    <div id="welcome-message">Welcome, Alia!</div>

    <%
        ArrayList<AppointmentModel> posts=(ArrayList<AppointmentModel>) request.getAttribute("allAppointments");
        for (AppointmentModel post: posts) {
    %>


<br>
    <div id="appointments">
        <div id="single-appointment">
            <form action="#" id="appointment-form">
                <!--<input type="submit" value="Aflyse tid" id="cancel-btn">-->
                <div id="first">
                    Tid: <%out.print(post.getId());%>
                    <!--<input type="text" id="time-input" name="time">-->
                </div>
                <div id="second">
                    Dato: <% out.print(post.getDato());%>
                    <!--<input type="text" id="date-input" name="date">-->
                </div>
                    <div id="third">
                        Cpr: <% out.print(post.getSygehusID());%>
                    <!--<textarea rows="7" cols="70" id="address-input" name="address"></textarea>-->

                </div>
                    <br>
                <!--<div id="third">
                    Addresse:
                    <textarea rows="7" cols="70" id="address-input" name="address"></textarea>
                </div>-->
            </form>
        </div>
    </div>
    <%}%>

    <!--<div id="confirm-message">
        <form action="#">
            <div id="question">Din tid er blevet aflyst. Ønsker du at bestille en nye tid? </div>
           <div id="buttons">
               <input type="submit" class="answer-btn" value="Ja">
               <input type="submit" class="answer-btn" value="Nej">
           </div>
        </form>
    </div>-->

</div>
</body>
</html>