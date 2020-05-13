<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Вход">
    <jsp:body>
        <content class="loginFormContaner">
            <div class="loginForm">
                <div class="titleLable">
                    <div class="flexContanerHorizontally">
                        <a class="secondaryButton" href="/newUser">У меня нет аккаунта</a>
                        <a class="secondaryButton" href="/newUser">Восстановить пароль</a>
                    </div>
                </div>
                <br/><br/>
                <form  method="post" action="/login">
                    <div>
                        <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                            <img class="loginFormImg" src="img/userImg.svg" />
                            <input type="text" name="username" placeholder="Логин/email" role="textbox"/>
                        </div>
                        <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                            <img class="loginFormImg" src="img/keyImg.svg" />
                            <input type="password" name="userpassword" pattern="[A-Za-zА-Яа-яЁё0-9]+" placeholder="Пароль" role="textbox"/>
                        </div>
                        <input class="horizontalListItem border prymoryButton" type="submit" value="Войти" />
                    </div><br><br>
                    <label><input type="checkbox"/>Запомнить меня</label>
                    <label>${error}</label>
                </form>
            </div>
        </content>
    </jsp:body>
</t:wrapper>
