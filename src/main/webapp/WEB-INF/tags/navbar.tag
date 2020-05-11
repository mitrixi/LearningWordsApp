<%@ tag body-content="scriptless" %>
<%@ tag description="Main layer page" pageEncoding="UTF-8" %>
<%@ attribute name="authorized" required="true"  rtexprvalue="false" type="java.lang.Boolean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
<nav class="navbar">
    <a class="secondaryButton" href="/home">Изучение слов</a>
    <ul class="flexContanerHorizontally">
        <li><a class="secondaryButton" href="/randomWord">Случайное слово</a></li>
        <li><a class="secondaryButton" href="/dictionary">Словарь</a></li>
        <c:if test="${authorized == true}">
           <li><a class="secondaryButton" href="/exit">Выйти</a></li>
        </c:if>
        <c:if test="${authorized == false}">
            <li><a class="secondaryButton" href="/login">Войти</a></li>
        </c:if>
    </ul>
</nav>
<hr/>
</header>
