<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper title="Создание нового пользователя">
    <content class="loginFormContaner">
        <div class="loginForm" >
            <div class="titleLable">
                <div class="flexContanerHorizontally">
                    <a class="secondaryButton" href="/login">У меня уже есть аккаунт</a>
                </div>
            </div>
            <br/><br/>
            <form method="post" action="/newUser">
                <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                    <img class="loginFormImg" src="img/emailImg.svg" />
                    <input type="email" name="email" placeholder="Электронная почта" role="textbox"/>
                </div>
                <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                    <img class="loginFormImg" src="img/userImg.svg" />
                    <input type="text" name="userlogin" pattern="[A-Za-zА-Яа-яЁё\s]+" placeholder="Логин" role="textbox"/>
                </div>
                <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                    <img class="loginFormImg" src="img/userImg.svg" />
                    <input type="text" name="username" pattern="[A-Za-zА-Яа-яЁё\s]+" placeholder="Как к вам обращаться" role="textbox"/>
                </div>
                <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                    <img class="loginFormImg" src="img/keyImg.svg" />
                    <input type="password" name="userpassword" pattern="[A-Za-zА-Яа-яЁё0-9]+" placeholder="Пароль" role="textbox"/>
                </div>
                <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                    <img class="loginFormImg" src="img/keyImg.svg" />
                    <input type="password" name="confirmationpassword" pattern="[A-Za-zА-Яа-яЁё0-9]+" placeholder="Подтверждение пароля" role="textbox"/>
                </div>
                <input class="horizontalListItem border prymoryButton" type="submit" value="Создать" />
            </form>
        </div>
    </content>
</t:wrapper>