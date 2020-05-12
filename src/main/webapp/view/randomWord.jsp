<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapper title="Случаное слово">

<content>
    <div class="loginFormContaner">
        <div class="flexContanerVertical">
            <h2><span id="translation"></span> - <span id="word"></span></h2>
            <span class="comment">[<span id="transcription"></span>]</span>
        </div>
        <br/><br/>
        <button class="horizontalListItem border prymoryButton" onclick="RandomWordReqest()">Случаное слово</button>
        <br/><br/>
        <p><span id="example"></span></p>
        <script>
            var translation = document.getElementById("translation");
            var transcription = document.getElementById("transcription");
            var word = document.getElementById("word");
            var example = document.getElementById("example");
            function RandomWordReqest(){
                var request = new XMLHttpRequest();
                request.open("POST", '/randomWord', true);
                request.setRequestHeader('Content-Type', 'application/text');
                request.onreadystatechange = function(){
                    if (request.readyState == 4) {
                        if (request.status == 200) {
                            var response = JSON.parse(request.responseText);
                            translation.innerText = response.word.translation;
                            transcription.innerText = response.word.transcription;
                            word.innerText = response.word.word;
                            example.innerText = response.word.example;
                        }
                    }
                };
                request.send();
            }
            RandomWordReqest();
        </script>
    </div>
</content>

</t:wrapper>