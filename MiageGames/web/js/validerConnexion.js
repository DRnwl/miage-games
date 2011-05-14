$(document).ready(function(){

    $("#BoutonConnexion").click(function(){
        if ($("#formConnexion").is(":hidden")){
            $("#formConnexion").slideDown("slow");
        }
        else{
            $("#formConnexion").slideUp("slow");
        }
    });
    
    $("#BoutonMenuU").click(function(){
        if ($("#menuDeroulantUser").is(":hidden")){
            $("#menuDeroulantUser").slideDown("slow");
        }
        else{
            $("#menuDeroulantUser").slideUp("slow");
        }
    });
    
    $("#BoutonMenuA").click(function(){
        if ($("#menuDeroulantAdmin").is(":hidden")){
            $("#menuDeroulantAdmin").slideDown("slow");
        }
        else{
            $("#menuDeroulantAdmin").slideUp("slow");
        }
    });
    
    $("#BoutonDeconnexion").click(function(){
        window.location.replace("DeconnexionServlet"); 
    });   
    
                
                

});           

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
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "ConnexionServlet",  
                data: "login=" + $("#login").val() + "&password=" + $("#password").val(),  
                success: function (msg) {  
                 
                    
                    // Si l'utilisateur existe, on execute le if 
                    if (msg == 1) { 
                        // On fait disparaitre le menu visiteur pour faire apparaitre celui de l'user'
                        $('div#menuVisiteur').remove();
                        $('div#bienvenue').remove();
                        $('div#menu').load("config/menu.jsp #menuUser");
                    
                        // On est obligé de rappeler chaque evenement utile ils n'ont pas été
                        // fixé sur les nouveaux element, d'ou la methode live();
                        $('#BoutonDeconnexion').live('click', function(){
                            window.location.replace("DeconnexionServlet");                     
                        });
                        $("#BoutonMenuU").live('click', function(){
                            if ($("#menuDeroulantUser").is(":hidden")){
                                $("#menuDeroulantUser").slideDown("slow");
                            }
                            else{
                                $("#menuDeroulantUser").slideUp("slow");
                            }
                        });
                    }
                    // Si l'administrateur existe, on execute le if 
                    else if (msg == 2) { 
                        window.location.replace("AdministrateurServlet");
                    }
                    else if(msg == -2){
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Le compte demandé n'existe pas</center>").fadeIn("slow");
                        
                    }
                    // Sinon fail
                    else if(msg == -1){
                   
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Combinaison identifiant/mot de passe incorrecte ! </center>").fadeIn("slow");
                        
                    }  
                }  
            });  
            return false;  
            
        },

        errorPlacement: function(error, element) { 
            error.insertBefore(element); 
        } 
        
    }),
    
    jQuery("#formCreation").validate({
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
            },
            "nom":{
                "required": true,
                "minlength": 5,
                "maxlength": 20
            },
            "prenom":{
                "required": true,
                "minlength": 5,
                "maxlength": 20
            },
            "num_tel":{
                "digits": true,
                "minlength": 10,
                "maxlength": 10
            },
            "adresse":{
                "required": true,
                "minlength": 5,
                "maxlength": 100
            },
            "email":{
                "required": true,
                "email": true,
                "minlength": 4,
                "maxlength": 30
            },
            "password_ver":{
                "password": true,
                "equalTo": "#password_c",
                "minlength": 5,
                "maxlength": 20
            }
            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompteServlet",  
                data: "login=" + $("#login").val() + "&password=" + $("#password").val()
                +"nom=" + $("#nom").val() + "&prenom=" + $("#prenom").val()
                +"email=" + $("#email").val() + "&password=" + $("#adresse").val(),
                success: function (msg) {  
                 
                    
                    // Si l'utilisateur existe, on execute le if 
                    if (msg == 1) {  
                        
                        
                    } 
                    else{
                        window.alert("beuh");
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Combinaison identifiant/mot de passe incorrecte ! </center>").fadeIn("slow");
                        
                    }
                }  
            });  
            return false;  
            
        }
        
        
      
    }),
    
    jQuery("#formConnexA").validate({
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
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "ConnexionServlet",  
                data: "login=" + $("#login").val() + "&password=" + $("#password").val(),  
                success: function (msg) {  
                 
                    window.alert("woot");
                    // Si l'utilisateur existe, on execute le if 
                    if (msg == 1) { 
                        // On fait disparaitre le menu visiteur pour faire apparaitre celui de l'user'
                        $('div#menuVisiteur').remove();
                        $('div#bienvenue').remove();
                        $('div#menu').load("config/menu.jsp #menuUser");
                    
                        // On est obligé de rappeler chaque evenement utile ils n'ont pas été
                        // fixé sur les nouveaux element, d'ou la methode live();
                        $('#BoutonDeconnexion').live('click', function(){
                            window.location.replace("DeconnexionServlet");                     
                        });
                        $("#BoutonMenuU").live('click', function(){
                            if ($("#menuDeroulantUser").is(":hidden")){
                                $("#menuDeroulantUser").slideDown("slow");
                            }
                            else{
                                $("#menuDeroulantUser").slideUp("slow");
                            }
                        });
                    }
                    // Si l'administrateur existe, on execute le if 
                    else if (msg == 2) { 
                        window.location.replace("AdministrateurServlet");
                    }
                    else if(msg == -2){
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Le compte demandé n'existe pas</center>").fadeIn("slow");
                        
                    }
                    // Sinon fail
                    else if(msg == -1){
                   
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Combinaison identifiant/mot de passe incorrecte ! </center>").fadeIn("slow");
                        
                    }  
                }  
            });  
            return false;  
            
        },

        errorPlacement: function(error, element) { 
            error.insertBefore(element); 
        } 
        
    })
 
});

$(function() {
    	
    var name = $( "#nom_a" ),
    password = $( "#password_a" ),
    allFields = $( [] ).add( name ).add( password ),
    tips = $( ".validateTips" );

    function updateTips( t ) {
        tips
        .text( t )
        .addClass( "ui-state-highlight" );
        setTimeout(function() {
            tips.removeClass( "ui-state-highlight", 1500 );
        }, 500 );
    }

    function checkLength( o, n, min, max ) {
        if ( o.val().length > max || o.val().length < min ) {
            o.addClass( "ui-state-error" );
            updateTips( "La taille de " + n + " doit être entre " +
                min + " et " + max + "." );
            return false;
        } else {
            return true;
        }
    }

    function checkRegexp( o, regexp, n ) {
        if ( !( regexp.test( o.val() ) ) ) {
            o.addClass( "ui-state-error" );
            updateTips( n );
            return false;
        } else {
            return true;
        }
    }
	

    $( "#BoutonAdmin" ).click(function() {
        $("#connAdmin").dialog("open");
    });
    
    $("#connAdmin").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "Connexion": function() {
                var bValid = true;
                allFields.removeClass( "ui-state-error" );

                bValid = bValid && checkLength( name, "username", 5, 20 );
                bValid = bValid && checkLength( password, "password", 5, 20 );

                bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
                // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
                bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

                if ( bValid ) {
                    $( "#users tbody" ).append( "<tr>" +
                        "<td>" + name.val() + "</td>" + 
                        "<td>" + password.val() + "</td>" +
                        "</tr>" ); 
                    $( this ).dialog( "close" );
                }
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        },
        close: function() {
            allFields.val( "" ).removeClass( "ui-state-error" );
        }
    });


});