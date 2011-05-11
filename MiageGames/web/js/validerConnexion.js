$(document).ready(function(){

    $("#BoutonConnexion").click(function(){
        if ($("#formConnexion").is(":hidden")){
            $("#formConnexion").slideDown("slow");
        }
        else{
            $("#formConnexion").slideUp("slow");
        }
    });
    
                
                

});
            
function fermerForm(){

        $("#formConnex").submit(function () {  
            $.ajax({  
                type: "POST",  
                url: "home.jsp",  
                data: "login=" + $("#login").val() + "&password=" + $("#password").val(),  
                success: function (msg) {  
                   
                    if (msg == 1) {  
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Vous êtes connecté !</center>").fadeIn("slow");
                    //window.location.replace("home.jsp");  
                    }  
                    else {  
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Combinaison identifiant/mot de passe incorrecte ! </center>").fadeIn("slow");
                        
                    }  
                }  
            });  
            return false;  
        });
    
               
}

jQuery(document).ready(function() {
    jQuery("#formConnex").validate({
        rules: {
            "login":{
                "login": true,
                "minlength": 5,
                "maxlength": 20
            },
            "password": {
                "password": true,
                "maxlength": 20,
                "minlength": 5
            }
            
        },
        
        errorPlacement: function(error, element) {
            error.insertAfter(element);
        }
        
    })
});