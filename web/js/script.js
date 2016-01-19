/**
 * Created by rekcahxunil on 11-1-16.
 */
$(document).ready(function(){
    $("#login-form-navbar").on("submit",function(event){
        event.preventDefault();

        var inpUsername = $("#username").val();
        var inpPassword = $("#password").val();

        $.post("ProcessLogin.jsp", {username:inpUsername,password:inpPassword}, function(data) {
            console.log(data.trim());
            if (data.trim() == "true") {
                window.location.replace("index.jsp");
            }
            else
            {
                $('#login-modal').modal('show')
            }
        });
    });

    $("#register-form").on("submit", function(event){
        event.preventDefault();
        $("#register-feedback-data").html("");

        var inpUserName = $("#register-username").val();
        var inpFirstName = $("#register-firstName").val();
        var inpLastName = $("#register-lastName").val();
        var inpEmail = $("#register-email").val();
        var inpPassword = $("#register-password").val();
        var errors=0;

        if(!checkPassword())
        {
            console.log("[debug] password mismatch");
            $("#register-feedback-data").html("<span class='feedback-error'>De wachtwoorden komen niet overeen.</span>");
            errors = 1;
        }
        if(!checkUsername())
        {
            console.log("[debug] short username");
            $("#register-feedback-data").html( "<span class='feedback-error'>Uw gebruikters naam is te kort.</span>");
            errors = 1;
        }

        var submitData = {
            username : inpUserName,
            firstName : inpFirstName,
            lastName : inpLastName,
            email : inpEmail,
            password : inpPassword
        };

        if(errors<1)
        {
            $.post("ProcessRegister.jsp", submitData, function( data ){
                console.log("[debug]" + data);
                $("#register-feedback-data").html(data)
            })
        }
    });

    $("#logout-button").click(function(){
        $.post("ProcessLogout.jsp", function( data ){
            window.location.replace("index.jsp");
        })
    })

});

function checkPassword()
{
    if($("#register-password").val() !== $("#register-password-again").val() )
    {
        $("#register-form-group-password").addClass("has-error has-feedback");
        $("#register-form-group-password-again").addClass("has-error has-feedback");
        return false;
    }
    else
    {
        $("#register-form-group-password").removeClass("has-error has-feedback");
        $("#register-form-group-password-again").removeClass("has-error has-feedback");
        return true;
    }
}

function checkUsername()
{
    if( $("#register-username").val().length < 5 )
    {
        $("#register-form-group-username").addClass("has-error has-feedback");
        return false;
    }
    else
    {
        $("#register-form-group-username").removeClass("has-error has-feedback");
        return true;
    }
}