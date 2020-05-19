<%@ tag body-content="scriptless" %>
<%@ tag description="Main layer page" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String login = (String) session.getAttribute("userlogin");
    boolean authorized = login != null && !login.equals("");
%>

<header>
<nav class="navbar">
    <a class="secondaryButton" href="/home">Изучение слов</a>
    <ul class="flexContanerHorizontally">
        <li><a class="secondaryButton" href="/randomWord">Случайное слово</a></li>
        <li><a class="secondaryButton" href="/dictionary">Словарь</a></li>
        <c:if test="<%=authorized %>">
           <li><a class="secondaryButton" href="/exit">Выйти</a></li>
        </c:if>
        <c:if test="<%=authorized == false %>">
            <li><a class="secondaryButton" href="/login">Войти</a></li>
        </c:if>
    </ul>
</nav>
<c:if test="<%=authorized %>">
   <div class="flexContanerHorizontally">Добрый день <%=login%>!</div>
</c:if>
<br/>
<hr/>
</header>
