$(document).ready(function(){

    // On ouvre/cache le formulaire de connexion
    $("#BoutonConnexion").click(function(){
        if ($("#formConnexion").is(":hidden")){
            $("#formConnexion").slideDown("slow");
        }
        else{
            $("#formConnexion").slideUp("slow");
        }
    });
    
    // On ouvre/cache le menu client
    $("#BoutonMenuU").click(function(){
        if ($("#menuDeroulantUser").is(":hidden")){
            $("#menuDeroulantUser").slideDown("slow");
        }
        else{
            $("#menuDeroulantUser").slideUp("slow");
        }
    });
    
    // On ouvre/cache le menu administrateur
    $("#BoutonMenuA").click(function(){
        if ($("#menuDeroulantAdmin").is(":hidden")){
            $("#menuDeroulantAdmin").slideDown("slow");
        }
        else{
            $("#menuDeroulantAdmin").slideUp("slow");
        }
    });
    
    // le clique sur le bouton de deconnexion nous envoit sur la servlet de déco
    $("#BoutonDeconnexion").click(function(){
        window.location.replace("DeconnexionServlet"); 
    });
    
    $("#AjoutAdm").click(function(){
        if ($("#toggleCrea").is(":hidden")){
            $("#toggleCrea").slideDown("slow");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            effacer("#formRechercheA");
            effacer("#formSupprimmerA");
        }
        else{
            $("#toggleCrea").slideUp("slow");
        }
    });
    
    $("#RechMAdmin").click(function(){
        if ($("#toggleModif").is(":hidden")){
            $("#toggleModif").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            effacer("#formCreationA");
            effacer("#formSupprimmerA");
        }
        else{
            $("#toggleModif").slideUp("slow");
        }
    });
    
    $("#SupprAdm").click(function(){
        if ($("#toggleSupp").is(":hidden")){
            $("#toggleSupp").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            effacer("#formCreationA");
            effacer("#formRechercheA");
        }
        else{
            $("#toggleSupp").slideUp("slow");
        }
    });
    
                
                

}); 
function effacer (nomForm) {
    $(':input',nomForm)
    .not(':button, :submit, :reset, :hidden')
    .val('')
}

jQuery(document).ready(function() {
    
    // Validation du formulaire de connexion
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
                data: "groupe=usr&login=" + $("#login").val() + "&password=" + $("#password").val(),  
                success: function (msg) {  

                    // Si l'client existe, on execute le if 
                    if (msg == 1) { 
                        // On fait disparaitre le menu visiteur pour faire apparaitre celui de l'user'
                        $('div#menuVisiteur').remove();
                        $('div#bienvenue').load("config/menu.jsp #bienvenue");
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
 
                        $("#connA").show();
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Le compte demandé n'existe pas</center>").fadeIn("slow");
                        
                    }
                    // Sinon fail
                    else if(msg == -1){
                   
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Combinaison identifiant/mot de passe incorrecte ! </center>").fadeIn("slow");
                        
                    }
                    else{
                        $('span#erreurConnexion').hide();
                        $("span#erreurConnexion").html ("<center>Une erreur est survenue </center>").fadeIn("slow");
                    }
                }  
            });  
            return false;  
            
        },

        errorPlacement: function(error, element) { 
            error.insertBefore(element); 
        } 
        
    }),
    
    // Validation du formulaire de creation client
    jQuery("#formCreationC").validate({
        rules: {
            "login_c":{
                "login": true,
                "minlength": 5,
                "maxlength": 20
            },
            "password_c": {
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
            },
            "adresse_f":{
                "required": true,
                "minlength": 10,
                "maxlength": 80
            },
            "adresse_f_suite":{
                "maxlength": 40
            },
            "adresse_f_zip":{
                "required": true,
                "digits": true,
                "minlength": 5,
                "maxlength": 5
            },
            "adresse_f_ville":{
                "required": true,
                "minlength": 4,
                "maxlength": 20
            },
            "adresse_l":{
                "required": true,
                "minlength": 10,
                "maxlength": 80
            },
            "adresse_l_suite":{
                "maxlength": 40
            },
            "adresse_l_zip":{
                "required": true,
                "digits": true,
                "minlength": 5,
                "maxlength": 5
            },
            "adresse_l_ville":{
                "required": true,
                "minlength": 4,
                "maxlength": 20
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompteServlet",  
                data: "but=creerC&login=" + $("#login_c").val() + "&password=" + $("#password_c").val()
                +"&nom=" + $("#nom").val() + "&prenom=" + $("#prenom").val()
                +"&email=" + $("#email").val() + "&num_tel=" + $("#num_tel").val()
                +"&adresse_f=" + $("#adresse_f").val() +" "+ $("#adresse_f_suite").val() 
                +"&adresse_f_zip=" + $("#adresse_f_zip").val() + "&adresse_f_ville=" + $("#adresse_f_ville").val()
                +"&adresse_l=" + $("#adresse_l").val() +" "+ $("#adresse_l_suite").val() 
                +"&adresse_l_zip=" + $("#adresse_l_zip").val() + "&adresse_l_ville=" + $("#adresse_l_ville").val(),
                success: function (msg) {  
                 
                    // Si le client existe, on execute le if 
                    if (msg == 1) {  
                        $('form#formCreationC').remove();
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Votre compte a bien été crée.</center><br /><center> Vous pouvez utiliser le menu Connexion pour pouvoir y accèder ou retourner à l'<a href='home.jsp'>accueil </center>").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Login déja utilisé ! </center>").fadeIn("slow");
                        
                    }
                    else if (msg == -2){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Email déjà utilisé </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Une erreur est survenue, le traitement ne peut être effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    // Validation du formulaire de modification client
    jQuery("#formModificationC").validate({
        rules: {
            "password_c": {
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
            },
            "adresse_f":{
                "required": true,
                "minlength": 10,
                "maxlength": 500
            },
            "adresse_f_suite":{
                "maxlength": 40
            },
            "adresse_f_zip":{
                "required": true,
                "digits": true,
                "minlength": 5,
                "maxlength": 5
            },
            "adresse_f_ville":{
                "required": true,
                "minlength": 4,
                "maxlength": 20
            },
            "adresse_l":{
                "required": true,
                "minlength": 10,
                "maxlength": 500
            },
            "adresse_l_suite":{
                "maxlength": 40
            },
            "adresse_l_zip":{
                "required": true,
                "digits": true,
                "minlength": 5,
                "maxlength": 5
            },
            "adresse_l_ville":{
                "required": true,
                "minlength": 4,
                "maxlength": 20
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompteServlet",  
                data: "but=modifierC&login=" + $("#login_c").val() + "&password=" + $("#password_c").val()
                +"&nom=" + $("#nom").val() + "&prenom=" + $("#prenom").val()
                +"&email=" + $("#email").val() + "&num_tel=" + $("#num_tel").val()
                +"&adresse_f=" + $("#adresse_f").val() +" "+ $("#adresse_f_suite").val() 
                +"&adresse_f_zip=" + $("#adresse_f_zip").val() + "&adresse_f_ville=" + $("#adresse_f_ville").val()
                +"&adresse_l=" + $("#adresse_l").val() +" "+ $("#adresse_l_suite").val() 
                +"&adresse_l_zip=" + $("#adresse_l_zip").val() + "&adresse_l_ville=" + $("#adresse_l_ville").val(),
                success: function (msg) {  
                 
                    
                    if (msg == 1) {  
                        $('div#bienvenue').load("config/menu.jsp #bienvenue");
                        
                        $('form#formCreationC').remove();
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Votre compte a bien été modifié.</center><br /><center> Vous pouvez retourner à l'<a href='home.jsp'>accueil </center>").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Email déjà utilisé ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -2)
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Vous n'avez effectué aucune modification ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Une erreur est survenue, le traitement ne peut être effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    jQuery("#formCreationA").validate({
        rules: {
            "login_aa": {
                "login": true,
                "maxlength": 20,
                "minlength": 5
            },
            "password_aa": {
                "password": true,
                "maxlength": 20,
                "minlength": 5
            },
            "nom_a":{
                "required": true,
                "minlength": 5,
                "maxlength": 20
            },
            "num_tel_a":{
                "digits": true,
                "minlength": 10,
                "maxlength": 10
            },
            "email_a":{
                "required": true,
                "email": true,
                "minlength": 4,
                "maxlength": 30
            },
            "password_ver_a":{
                "password": true,
                "equalTo": "#password_aa",
                "minlength": 5,
                "maxlength": 20
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompteServlet",  
                data: "but=creerA&login=" + $("#login_aa").val() + "&password=" + $("#password_aa").val()
                +"&nom=" + $("#nom_a").val() +"&email=" + $("#email_a").val() + "&num_tel=" + $("#num_tel_a").val(),
                success: function (msg) {  
                 
                    if (msg == 1) {  
                        
                        effacer("#formCreationA");
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Le compte a bien été crée.</center><br />").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Login déja utilisé ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -2)
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Email déjà utilisé ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Une erreur est survenue, le traitement ne peut être effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    // Validation du formulaire de modification client
    jQuery("#formModificationA").validate({
        rules: {
            "login_a": {
                "login": true,
                "maxlength": 20,
                "minlength": 5
            },
            "password_a": {
                "password": true,
                "maxlength": 20,
                "minlength": 5
            },
            "nom":{
                "required": true,
                "minlength": 5,
                "maxlength": 20
            },
            "num_tel":{
                "digits": true,
                "minlength": 10,
                "maxlength": 10
            },
            "email":{
                "required": true,
                "email": true,
                "minlength": 4,
                "maxlength": 30
            },
            "password_ver":{
                "password": true,
                "equalTo": "#password_a",
                "minlength": 5,
                "maxlength": 20
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompteServlet",  
                data: "but=modifierA&login=" + $("#login_a").val() + "&password=" + $("#password_a").val()
                +"&nom=" + $("#nom").val() +"&email=" + $("#email").val() + "&num_tel=" + $("#num_tel").val(),
                success: function (msg) {  
                 
                    // Si l'admin existe, on execute le if 
                    if (msg == 1) {  
                        $('div#bienvenue').load("config/menu.jsp #bienvenue");
                        
                        $('form#formCreationA').remove();
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Le compte a bien été modifié.</center><br />").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Email déja utilisé ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -2)
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Login déjà utilisé ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -3)
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Vous n'avez effectué aucune modification ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Une erreur est survenue, le traitement ne peut être effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    jQuery("#formRechercheA").validate({
        rules: {
            "login_ar": {
                "login": true,
                "maxlength": 20,
                "minlength": 5
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "modifierA",  
                data: "login=" + $("#login_ar").val(),
                success: function (msg) {  
                 
                    // Si l'admin existe, on execute le if 
                    if (msg == 1) {
                        $('span#erreurModification').load("admin/modifierAdmin.jsp #erreurModification");
                        $('div#menuModif').load("admin/modifierAdmin.jsp #formModificationA");
                        $('div#menuModif').show();
                        
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Le compte recherché n'existe pas ! </center>").fadeIn("slow");
                        
                    }
                    else if (msg == -2){
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Vous devez aller sur cette <a href='modifierA'>page</a> pour modifier vos informations de compte ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Une erreur est survenue, le traitement ne peut être effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    jQuery("#formSupprimmerA").validate({
        rules: {
            "login_as": {
                "login": true,
                "maxlength": 20,
                "minlength": 5
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompteServlet",  
                data: "but=supprimerA&login=" + $("#login_as").val(),
                success: function (msg) {  
                 
                    // Si l'admin existe, on execute le if 
                    if (msg == 1) {
                        
                        
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le compte a été supprimé ! </center>").fadeIn("slow");
                        
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le compte à supprimer n'existe pas ! </center>").fadeIn("slow");
                        
                    }
                    else if (msg == -2){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Vous ne pouvez pas supprimer votre compte ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Une erreur est survenue, le traitement ne peut être effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    })
 
});

// Ouvre une fenetre pour la connexion admin
// On vérifie que le formulaire est bien remplie
// Puis une requete ajax est envoyée pour vérifier dans la bd si c'est bon ou non
$(function() {
    	
        
    var name = $( "#login_a" ),
    password = $( "#password_a" ),
    allFields = $( [] ).add( name ).add( password ),
    tips = $(".validateTips");

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
	

    $( "#BoutonAdmin" ).button().click(function() {
        $("#connAdmin").dialog("open");
    });
    

    $("#connAdmin").dialog({
        autoOpen: false,
        height: 300,
        width: 350,
        modal: true,
        buttons: {
            "Connexion": function() {
                $(this).trigger('submit');
            },
            Cancel: function() {
                $( this ).dialog( "close" );
            }
        },
        close: function() {
            allFields.val( "" ).removeClass( "ui-state-error" );
        }
    });
    
    $("#connAdmin").bind( "submit", function() {
        var bValid = true;
        allFields.removeClass( "ui-state-error" );

        bValid = bValid && checkLength( name, "nom du compte", 5, 20 );
        bValid = bValid && checkLength( password, "password", 5, 20 );


        bValid = bValid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, begin with a letter." );
        // From jquery.validate.js (by joern), contributed by Scott Gonzalez: http://projects.scottsplayground.com/email_address_validation/
        bValid = bValid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );
        if ( bValid ) {
              
            
            $.ajax({
                type: "POST",  
                url: "ConnexionServlet",  
                data: "groupe=adm&login=" + name.val() + "&password=" + password.val(),  
                success: function (msg) {    
                    
                    // Si l'administrateur existe, on execute le if 
                    if (msg == 1) {
                        $('div#menu').load("config/menu.jsp #menuAdmin");
                        $('#footer').load("config/footer.jsp #footer");
                        $('div#bienvenue').load("config/menu.jsp #bienvenue");
                        // On est obligé de rappeler chaque evenement utile ils n'ont pas été
                        // fixé sur les nouveaux element, d'ou la methode live();
                        $('#BoutonDeconnexion').live('click', function(){
                            window.location.replace("DeconnexionServlet");                     
                        });
                        $("#BoutonMenuA").live('click', function(){
                            if ($("#menuDeroulantAdmin").is(":hidden")){
                                $("#menuDeroulantAdmin").slideDown("slow");
                            }
                            else{
                                $("#menuDeroulantAdmin").slideUp("slow");
                            }
                        });
                        $( $("#connAdmin") ).dialog( "close" );
                    }
                    else if(msg == -1){
                        updateTips("Combinaison identifiant/mot de passe incorrecte !");
                    }
                    else if(msg == -2)
                    {
                        updateTips("Le compte demandé n'existe pas");
                    }
                }
            });
            return false;    
                    
        }
    });
});