$(document).ready(function(){

    $("#BoutonConnexion").click(function(){
        if ($("#formConnexion").is(":hidden")){
            $("#formConnexion").slideDown("slow");
        }
        else{
            $("#formConnexion").slideUp("slow");
        }
    });
    
    $("#BoutonMenu").click(function(){
        if ($("#menuDeroulantUser").is(":hidden")){
            $("#menuDeroulantUser").slideDown("slow");
        }
        else{
            $("#menuDeroulantUser").slideUp("slow");
        }
    });
    
    $("#BoutonDeconnexion").click(function(){
        window.location.replace("DeconnexionServlet"); 
    });   
    
                
                

});
            
function fermerForm(){

    $("#formConnex").submit(function () {  
        $.ajax({  
            type: "POST",  
            url: "ConnexionServlet",  
            data: "login=" + $("#login").val() + "&password=" + $("#password").val(),  
            success: function (msg) {  
                 
                 
                // Si l'utilisateur existe, on execute le if 
                if (msg == 1) {  
                    
                    // On fait disparaitre le menu visiteur pour faire apparaitre celui de l'user'
                    $('div#menuVisiteur').remove();
                    $('div#menu').load("config/menu.jsp #menuUser");
                    
                    // On est obligé de rappeler chaque evenement utile ils n'ont pas été
                    // fixé sur les nouveaux element, d'ou la methode live();
                    $('#BoutonDeconnexion').live('click', function(){
                        window.location.replace("DeconnexionServlet");                     
                    });
                    $("#BoutonMenu").live('click', function(){
                        if ($("#menuDeroulantUser").is(":hidden")){
                            $("#menuDeroulantUser").slideDown("slow");
                        }
                        else{
                            $("#menuDeroulantUser").slideUp("slow");
                        }
                    });
                }  
                // Sinon fail
                else {
                    
                    
                    //Test :)
                      
                    /*$('div#menu').after("<div id='menuUser'>"+
                    "<div id='menuDeroulantUser'>"+
                        "<p><a href='#' id='BoutonTest' class='button'>Test</a></p>"+
                    "</div>"+
                    "<br>"+
                    "<a href='#' id='BoutonMenu'class='button button-left'>Menu</a>"
+
                    "<a href='#' id='BoutonDeconnexion' class='button button-right'>Deconnexion</a>"
+
                    "<div class='cl'>&nbsp;</div>"+
                "</div>");*/
                   
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