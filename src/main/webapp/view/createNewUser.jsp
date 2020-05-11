<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
 <content class="shadow horizontalListItem" id="content">
 <div class="horizontalListItem titleLable">
    <H3>Новый пользователь</H3>
    <a href="/login">У меня уже есть аккаунт</a>
 </div>
 <div class="loginForm">
     <form method="post" action="/newUser">
         <div>
             <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                 <img class="loginFormImg" src="img/emailImg.svg" />
                 <input type="email" name="email" placeholder="Электронная почта" role="textbox"/>
             </div>
             <div class="horizontalListItem border flexContanerHorizontally loginFormTextField">
                 <img class="loginFormImg" src="img/userImg.svg" />
                 <input type="text" name="username" pattern="[A-Za-zА-Яа-яЁё\s]+" placeholder="Имя пользователя" role="textbox"/>
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
         </div>
     </form>
 </div>
 </content>

</t:wrapper>