<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
<content class="shadow horizontalListItem" id="content">
    <div class="horizontalListItem titleLable">
        <H3>Войти</H3>
        <a href="/newUser">У меня нет аккаунта</a>
    <div>
    <div class="loginForm">
        <div id="loginForm" >
            <form method="post" action="/login">
                <div>
                    <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                        <img class="loginFormImg" src="img/userImg.svg" />
                        <input type="text" name="username" pattern="[A-Za-zА-Яа-яЁё\s]+" placeholder="Имя пользователя" role="textbox"/>
                    </div>
                    <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                        <img class="loginFormImg" src="img/keyImg.svg" />
                        <input type="password" name="userpassword" pattern="[A-Za-zА-Яа-яЁё0-9]+" placeholder="Пароль" role="textbox"/>
                    </div>
                    <input class="horizontalListItem border prymoryButton" type="submit" value="Войти" />
                </div><br><br>
                <label><input type="checkbox"/>Запомнить меня</label>
            </form><br>

            <input class="secondaryButton" type="button" value="Восстановить пароль" />
        </div>
    </div>
</content>
</t:wrapper>