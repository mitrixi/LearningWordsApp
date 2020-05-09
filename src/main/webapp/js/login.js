var loginForm;
var loginButton;
var newUserForm;
var newUserButton;

function showLoginForm(e){
    newUserForm.style.display = "none";
    loginForm.style.display = "block";
    newUserButton.classList.add("secondaryButtonChecked");
    loginButton.classList.remove("secondaryButtonChecked");
}

function showNewUserForm(e){
    loginForm.style.display = "none";
    newUserForm.style.display = "block";
    loginButton.classList.add("secondaryButtonChecked");
    newUserButton.classList.remove("secondaryButtonChecked");
}

function onLoad(e){
    loginForm = document.getElementById("loginForm");
    loginButton = document.getElementById("loginButton");
    newUserForm = document.getElementById("newUserForm");
    newUserButton = document.getElementById("newUserButton");
    let content = document.getElementById("content");
    showLoginForm();
    content.style.opacity = 1;

    loginButton.onclick = showLoginForm;
    newUserButton.onclick = showNewUserForm;
}

window.onload = onLoad;