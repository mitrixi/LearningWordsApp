<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Случаное слово">
    <content>
         <div>
             <div class="flexContanerWarpColumn">
                 <c:forEach var="word" items="${words}">
                     <div class="flexContanerHorizontally"><span>${word.translation} - ${word.word}</span></div>
                 </c:forEach>
             </div>
             <br/>
             <div class="flexContanerWarpRow">
                 <c:forEach var="index" items="${pageCount}">
                     <a class="secondaryButton pageLinc" href="/dictionary?page=${index}" >${index}</a>
                 </c:forEach>
             </div>
         </div>
    </content>
</t:wrapper>