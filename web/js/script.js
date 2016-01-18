/**
 * Created by rekcahxunil on 11-1-16.
 */
$(document).ready(function(){
    $("#login-form-navbar").on("submit",function(event){
        event.preventDefault();

        var inpUsername = $("#username").val();
        var inpPassword = $("#password").val();

        $.post("ProsessLogin.jsp", {username:inpUsername,password:inpPassword}, function(data){
            console.log( data.trim() );
        });

    });
});
