<%@ tag body-content="scriptless" %>
<%@ tag description="Main layer page" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true"  rtexprvalue="false" type="java.lang.String" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="ru">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!--link rel="stylesheet" type="text/css" href="css/style.css"-->
        <!--script src="script.js"></script-->

        <link rel="stylesheet/less" type="text/css" href="/css/style.less" />
        <script src="/js/less/dist/less.js"  type="text/javascript"></script>
        <title>Изучение слов - ${title} </title>
    </head>
    <body>
        <div class="mainContent shadow">
            <t:navbar authorized="false"/>
            <jsp:doBody/>
            <t:footer authorized="false"/>
        </div>

    </body>
</html>