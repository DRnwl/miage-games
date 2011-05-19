$(document).ready(function(){

    // On ouvre/cache le formulaire de connexion
    $("#BoutonConnexion").live('click',function(){
        if ($("#formConnexion").is(":hidden")){
            $("#formConnexion").slideDown("slow");
        }
        else{
            $("#formConnexion").slideUp("slow");
        }
    });
    
    // On ouvre/cache le menu client
    $("#BoutonMenuU").live('click',function(){
        if ($("#menuDeroulantUser").is(":hidden")){
            $("#menuDeroulantUser").slideDown("slow");
        }
        else{
            $("#menuDeroulantUser").slideUp("slow");
        }
    });
    
    // On ouvre/cache le menu administrateur
    $("#BoutonMenuA").live('click',function(){
        if ($("#menuDeroulantAdmin").is(":hidden")){
            $("#menuDeroulantAdmin").slideDown("slow");
        }
        else{
            $("#menuDeroulantAdmin").slideUp("slow");
        }
    });
    
    // le clique sur le bouton de deconnexion nous envoit sur la servlet de déco
    $("#BoutonDeconnexion").live('click',function(){
        window.location.replace("DeconnexionServlet"); 
    });

    $("#AjoutAdm").click(function(){
        if ($("#toggleCrea").is(":hidden")){
            effacer("#formRechercheA");
            effacer("#formSupprimmerA");
            
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            $("#menuModif").empty();
            $("#erreurModification").empty();
            $("#afficherAdmin").empty();
            
            $("#toggleCrea").slideDown("slow");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
        }
        else{
            $("#toggleCrea").slideUp("slow");
        }
    });
    
    $("#RechMAdmin").click(function(){
        if ($("#toggleModif").is(":hidden")){
            effacer("#formCreationA");
            effacer("#formSupprimmerA");
            $("#erreurCreation").hide();
            $("#erreurSuppression").hide();
            $("#afficherAdmin").empty();
            $("#erreurVoir").hide();
            $("#toggleModif").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
            
        }
        else{
            $("#toggleModif").slideUp("slow");
        }
    });
    
    $("#SupprAdm").click(function(){
        if ($("#toggleSupp").is(":hidden")){
            
            effacer("#formCreationA");
            effacer("#formRechercheA");
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#erreurVoir").hide();
            $("#menuModif").empty();
            $("#erreurModification").empty();
            $("#afficherAdmin").empty();
            
            $("#toggleSupp").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
        }
        else{
            $("#toggleSupp").slideUp("slow");
        }
    });
    
    $("#VoirTousAdm").click(function(){
        if ($("#toggleVoir").is(":hidden")){
            
            effacer("#formCreationA");
            effacer("#formRechercheA");
            effacer("#formSupprimmerA");
            
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            
            $("#menuModif").empty();
            $("#erreurModification").empty();
            
            $("#toggleVoir").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            

            
            loadDataA(1,'Admin');
            
        }
        else{
            $("#toggleVoir").slideUp("slow");
        }
    });
    
                
    
  
    
    
    
    $("#AjoutClt").click(function(){
        if ($("#toggleCrea").is(":hidden")){
            
                        
            effacer("#formRechercheC");
            effacer("#formSupprimmerC");
            
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            
            $("#menuModifC").empty();
            $("#erreurModification").hide();
            $("#voirClt").empty();
            
            $("#toggleCrea").slideDown("slow");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");

        }
        else{
            $("#toggleCrea").slideUp("slow");
        }
    });
    
    $("#RechMClt").click(function(){
        if ($("#toggleModif").is(":hidden")){
            
            effacer("#formCreationC");
            effacer("#formSupprimmerC");
            $("#erreurCreation").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            $("#voirClt").empty();
            
            $("#toggleModif").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
        }
        else{
            $("#toggleModif").slideUp("slow");
        }
    });
    
    $("#SupprClt").click(function(){
        if ($("#toggleSupp").is(":hidden")){
            
            effacer("#formCreationC");
            effacer("#formRechercheC");
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#menuModifC").empty();
            $("#erreurModification").hide();
            $("#erreurVoir").hide();
            $("#voirClt").empty();
            
            $("#toggleSupp").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
            
        }
        else{
            $("#toggleSupp").slideUp("slow");
        }
    });
    
    $("#VoirTousClt").click(function(){
        if ($("#toggleVoir").is(":hidden")){
            
            effacer("#formCreationC");
            effacer("#formRechercheC");
            effacer("#formSupprimmerC");
            
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#menuModifC").empty();
            $("#erreurModification").empty();
            
            $("#toggleVoir").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            

            
            loadDataA(1,'Client');
            
        }
        else{
            $("#toggleVoir").slideUp("slow");
        }
    });
    
                
    
    $('#voirClt .pagination li.active').live('click',function(){
        var page = $(this).attr('p');
        loadDataA(page,'Client');
    }); 
    
    
    
    $("#AjoutProd").click(function(){
        if ($("#toggleCrea").is(":hidden")){
            
                        
            effacer("#formRechercheP");
            effacer("#formSupprimmerP");
            
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            
            $("#menuModifP").empty();
            $("#erreurModification").hide();
            $("#voirProd").empty();
            
            $("#toggleCrea").slideDown("slow");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");

        }
        else{
            $("#toggleCrea").slideUp("slow");
        }
    });
    
    $("#RechMProd").click(function(){
        if ($("#toggleModif").is(":hidden")){
            
            effacer("#formCreationP");
            effacer("#formSupprimmerP");
            $("#erreurCreation").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            $("#voirProd").empty();
            
            $("#toggleModif").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
        }
        else{
            $("#toggleModif").slideUp("slow");
        }
    });
    
    $("#SupprProd").click(function(){
        if ($("#toggleSupp").is(":hidden")){
            
            effacer("#formCreationP");
            effacer("#formRechercheP");
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#menuModifP").empty();
            $("#erreurModification").hide();
            $("#erreurVoir").hide();
            $("#voirProd").empty();
            
            $("#toggleSupp").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
            
        }
        else{
            $("#toggleSupp").slideUp("slow");
        }
    });
    
    $("#VoirTousProd").click(function(){
        if ($("#toggleVoir").is(":hidden")){
            
            effacer("#formCreationP");
            effacer("#formRechercheP");
            effacer("#formSupprimmerP");
            
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#menuModifP").empty();
            $("#erreurModification").empty();
            
            $("#toggleVoir").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            

            
            loadDataA(1,'Prod');
            
        }
        else{
            $("#toggleVoir").slideUp("slow");
        }
    });
    
    
    $("#AjoutComd").click(function(){
        if ($("#toggleCrea").is(":hidden")){
            
                        
            effacer("#formRechercheCo");
            effacer("#formSupprimmerCo");
            
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            
            $("#menuModifCo").empty();
            $("#erreurModification").hide();
            $("#voirComd").empty();
            
            $("#toggleCrea").slideDown("slow");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");

        }
        else{
            $("#toggleCrea").slideUp("slow");
        }
    });
    
    $("#RechMComd").click(function(){
        if ($("#toggleModif").is(":hidden")){
            
            effacer("#formCreationCo");
            effacer("#formSupprimmerCo");
            $("#erreurCreation").hide();
            $("#erreurSuppression").hide();
            $("#erreurVoir").hide();
            $("#voirComd").empty();
            
            $("#toggleModif").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
        }
        else{
            $("#toggleModif").slideUp("slow");
        }
    });
    
    $("#SupprComd").click(function(){
        if ($("#toggleSupp").is(":hidden")){
            
            effacer("#formCreationCo");
            effacer("#formRechercheCo");
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#menuModifCo").empty();
            $("#erreurModification").hide();
            $("#erreurVoir").hide();
            $("#voirComd").empty();
            
            $("#toggleSupp").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleVoir").slideUp("fast");
            
            
            
        }
        else{
            $("#toggleSupp").slideUp("slow");
        }
    });
    
    $("#VoirTousComd").click(function(){
        if ($("#toggleVoir").is(":hidden")){
            
            effacer("#formCreationCo");
            effacer("#formRechercheCo");
            effacer("#formSupprimmerCo");
            
            $("#erreurCreation").hide();
            $("#erreurRecherche").hide();
            $("#erreurSuppression").hide();
            $("#menuModifP").empty();
            $("#erreurModification").empty();
            
            $("#toggleVoir").slideDown("slow");
            $("#toggleCrea").slideUp("fast");
            $("#toggleModif").slideUp("fast");
            $("#toggleSupp").slideUp("fast");
            

            
            loadDataA(1,'Comd');
            
        }
        else{
            $("#toggleVoir").slideUp("slow");
        }
    });

    $(function() {
        $.datepicker.setDefaults( $.datepicker.regional[ "fr" ] );
        $( "#date" ).datepicker( $.datepicker.regional[ "fr" ] );
        $( "#date" ).datepicker( "option", "dateFormat", 'dd MM yy' );
        
        $('#date_pm').live('click', function() {
            window.alert($( "#date_pm" ).val());
            $(this).datepicker({
                showOn:'focus',
                defaultDate: $.datepicker.parseDate('dd MM yy',$("#date_pm").val())
            }).focus();
            
            
            $( this ).datepicker( $.datepicker.regional[ "fr" ] );
            $( this ).datepicker( "option", "dateFormat", 'dd MM yy' );
            
            
        });
        
    });
    $(document).ready(function() 
    { 
        
        $("#tabCommandes").tablesorter( ); 
        
    } 
    ); 
      
    
}); 

    
function loadDataA(page, type)
{ 
    $.ajax
    ({
        type: "POST",
        url: "paginationAdmin",
        data: "pagi="+type+"&page="+page,
        success: function(msg)
        {
            
            $("#afficher"+type).ajaxComplete(function(event, request, settings)
            {
                if(msg == -1)
                {
                    $('span#erreurVoir').hide();
                    $("span#erreurVoir").html ("<center>Une erreur est survenue </center>").fadeIn("slow");
                    
                }
                else
                    $("#afficher"+type).html(msg);
            });
            
        }
    });
    return false;
}

function Modif(page, demande , donnee, type, pagee)
{ 
    $.ajax
    ({
        type: "POST",
        url: "CreerEditer"+page,
        data: "but="+demande+"&"+donnee,
        success: function(msg)
        {
            
            
            if(msg == -1)
            {
                $('span#erreurVoir').hide();
                $("span#erreurVoir").html ("<center>Une erreur est survenue </center>").fadeIn("slow");
                    
            }
            else
                $(this).empty();
            loadDataA(pagee,type);
        }
    });
    return false;

    
}

function loadData(page, url)
{ 
    $.ajax
    ({
        type: "POST",
        url: url,
        data: "but=reload&page="+page,
        success: function(msg)
        {
         
            $("#divListeProduits").ajaxComplete(function(event, request, settings)
            {
                $(this).empty();
                $(this).html(msg);
                
            });
        }
    
    });
    return false;
}
    
function detailCommande(commande)
{ 

            
    window.location.replace("detailCommande?commande="+commande);

}
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
                "minlength": 3,
                "maxlength": 20
            },
            "password": {
                "password": true,
                "maxlength": 20,
                "minlength": 3
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "ConnexionServlet",  
                data: "groupe=usr&login=" + $("#login").val() + "&password=" + $("#password").val(),  
                success: function (msg) {  

                    // Si le client existe, on execute le if 
                    if (msg == 1) { 
                        // On fait disparaitre le menu visiteur pour faire apparaitre celui de l'user'
                        $('div#menuVisiteur').remove();
                        $('div#bienvenue').load("config/menu.jsp #bienvenue");
                        $('div#menu').load("config/menu.jsp #menuUser");

                        
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
                "minlength": 3,
                "maxlength": 20
            },
            "password_c": {
                "password": true,
                "maxlength": 20,
                "minlength": 3
            },
            "nom":{
                "required": true,
                "minlength": 3,
                "maxlength": 20
            },
            "prenom":{
                "required": true,
                "minlength": 3,
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
                "maxlength": 60
            },
            "password_ver":{
                "password": true,
                "equalTo": "#password_c",
                "minlength": 3,
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
                url: "CreerEditerCompte",  
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
                        $("span#erreurCreation").html ("<center> Le compte a bien ete cree.</center><br /><center> Vous pouvez utiliser le menu Connexion pour pouvoir y accèder ou retourner à l'<a href='ServletPrincipal'>accueil </center>").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Login deja utilise ! </center>").fadeIn("slow");
                        
                    }
                    else if (msg == -2){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Email deja utilise </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Une erreur est survenue, le traitement ne peut être effectue </center>").fadeIn("slow");
                         
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
                "minlength": 3
            },
            "nom":{
                "required": true,
                "minlength": 3,
                "maxlength": 20
            },
            "prenom":{
                "required": true,
                "minlength": 3,
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
                "maxlength": 60
            },
            "password_ver":{
                "password": true,
                "equalTo": "#password_c",
                "minlength": 3,
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
                url: "CreerEditerCompte",  
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
                "minlength": 3
            },
            "password_aa": {
                "password": true,
                "maxlength": 20,
                "minlength": 3
            },
            "nom_a":{
                "required": true,
                "minlength": 3,
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
                "maxlength": 60
            },
            "password_ver_a":{
                "password": true,
                "equalTo": "#password_aa",
                "minlength": 3,
                "maxlength": 20
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompte",  
                data: "but=creerA&login=" + $("#login_aa").val() + "&password=" + $("#password_aa").val()
                +"&nom=" + $("#nom_a").val() +"&email=" + $("#email_a").val() + "&num_tel=" + $("#num_tel_a").val(),
                success: function (msg) {  
                 
                    if (msg == 1) {  
                        
                        effacer("#formCreationA");
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Le compte a bien ete cree.</center><br />").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Login deja utilise ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -2)
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Email deja utilise ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Une erreur est survenue, le traitement ne peut etre effectue </center>").fadeIn("slow");
                         
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
                "minlength": 3
            },
            "password_a": {
                "password": true,
                "maxlength": 20,
                "minlength": 3
            },
            "nom":{
                "required": true,
                "minlength": 3,
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
                "maxlength": 60
            },
            "password_ver":{
                "password": true,
                "equalTo": "#password_a",
                "minlength": 3,
                "maxlength": 20
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompte",  
                data: "but=modifierA&login=" + $("#login_a").val() + "&password=" + $("#password_a").val()
                +"&nom=" + $("#nom").val() +"&email=" + $("#email").val() + "&num_tel=" + $("#num_tel").val(),
                success: function (msg) {  
                 
                    // Si l'admin existe, on execute le if 
                    if (msg == 1) {  
                        $('div#bienvenue').load("config/menu.jsp #bienvenue");
                        
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Le compte a bien ete modifie.</center><br />").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Email deja utilise ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -2)
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Login deja utilise ! </center>").fadeIn("slow");
                        
                    }
                    else if(msg == -3)
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Vous n'avez effectue aucune modification ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurModification').hide();
                        $("span#erreurModification").html ("<center> Une erreur est survenue, le traitement ne peut etre effectue </center>").fadeIn("slow");
                         
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
                "minlength": 3
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
                        $('span#erreurRecherche').empty();
                        $('span#erreurModification').load("admin/modifierAdmin.jsp #erreurModification");
                        
                        $('div#menuModif').load("admin/modifierAdmin.jsp #formModificationA");
                        $('div#menuModif').show();
 
                        $("#ValiderModifierBouton").live('click',function(){
                            jQuery("#formModificationA").validate({
                                rules: {
                                    "login_a": {
                                        "login": true,
                                        "maxlength": 20,
                                        "minlength": 3
                                    },
                                    "password_a": {
                                        "password": true,
                                        "maxlength": 20,
                                        "minlength": 3
                                    },
                                    "nom":{
                                        "required": true,
                                        "minlength": 3,
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
                                        "maxlength": 60
                                    },
                                    "password_ver":{
                                        "password": true,
                                        "equalTo": "#password_a",
                                        "minlength": 3,
                                        "maxlength": 20
                                    }

            
                                },
                                submitHandler: function(){
                                    $.ajax({  
                                        type: "POST",  
                                        url: "CreerEditerCompte",  
                                        data: "but=modifierA&login=" + $("#login_a").val() + "&password=" + $("#password_a").val()
                                        +"&nom=" + $("#nom").val() +"&email=" + $("#email").val() + "&num_tel=" + $("#num_tel").val(),
                                        success: function (msg) {  
                 
                                            // Si l'admin existe, on execute le if 
                                            if (msg == 1) {  
                                               
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Le compte a bien ete modifié.</center><br />").fadeIn("slow");
                        
                                            } 
                                            else if (msg == -1){
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Email deja utilise ! </center>").fadeIn("slow");
                        
                                            }
                                            else if(msg == -2)
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Login deja utilise ! </center>").fadeIn("slow");
                        
                                            }
                                            else if(msg == -3)
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Vous n'avez effectue aucune modification ! </center>").fadeIn("slow");
                        
                                            }
                                            else
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Une erreur est survenue, le traitement ne peut etre effectue </center>").fadeIn("slow");
                         
                                            }
                                        }  
                                    });  
                                    return false;  
            
                                }

                            })
                        });
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurModification').empty();
                        $('div#menuModif').empty();
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Le compte recherche n'existe pas ! </center>").fadeIn("slow");
                        
                    }
                    else if (msg == -2){
                        $('span#erreurModification').empty();
                        $('div#menuModif').empty();
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Vous devez aller sur cette <a href='modifierA'>page</a> pour modifier vos informations de compte ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurModification').empty();
                        $('div#menuModif').empty();
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Une erreur est survenue, le traitement ne peut être effectue </center>").fadeIn("slow");
                         
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
                "minlength": 3
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompte",  
                data: "but=supprimerA&login=" + $("#login_as").val(),
                success: function (msg) {  
                 
                    // Si l'admin existe, on execute le if 
                    if (msg == 1) {
                        
                        
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le compte a ete supprime ! </center>").fadeIn("slow");
                        
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le compte a supprimer n'existe pas ! </center>").fadeIn("slow");
                        
                    }
                    else if (msg == -2){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Vous ne pouvez pas supprimer votre compte ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Une erreur est survenue, le traitement ne peut être effectue </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    jQuery("#formRechercheC").validate({
        rules: {
            "login_cr": {
                "login": true,
                "maxlength": 20,
                "minlength": 3
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "modifierCl",  
                data: "login=" + $("#login_cr").val(),
                success: function (msg) {  
                 
  
                    if (msg == 1) {
                        $('span#erreurRecherche').empty();
                        $('span#erreurModification').load("admin/modifierClient.jsp #erreurModification");
                        $('div#menuModifC').load("admin/modifierClient.jsp #formModificationC");
                        $('div#menuModifC').show();
                        $("#ValiderModifierBoutonC").live('click',function(){
                            jQuery("#formModificationC").validate({
                                rules: {
                                    "login_cm": {
                                        "login": true,
                                        "maxlength": 20,
                                        "minlength": 3
                                    },
                                    "password_cm": {
                                        "password": true,
                                        "maxlength": 20,
                                        "minlength": 3
                                    },
                                    "nom_cm":{
                                        "required": true,
                                        "minlength": 3,
                                        "maxlength": 20
                                    },
                                    "num_tel_cm":{
                                        "digits": true,
                                        "minlength": 10,
                                        "maxlength": 10
                                    },
                                    "email_cm":{
                                        "required": true,
                                        "email": true,
                                        "minlength": 4,
                                        "maxlength": 60
                                    },
                                    "password_ver_cm":{
                                        "password": true,
                                        "equalTo": "#password_cm",
                                        "minlength": 3,
                                        "maxlength": 20
                                    },
                                    "adresse_f_cm":{
                                        "required": true,
                                        "minlength": 10,
                                        "maxlength": 500
                                    },
                                    "adresse_f_suite_cm":{
                                        "maxlength": 40
                                    },
                                    "adresse_f_zip_cm":{
                                        "required": true,
                                        "digits": true,
                                        "minlength": 5,
                                        "maxlength": 5
                                    },
                                    "adresse_f_ville_cm":{
                                        "required": true,
                                        "minlength": 4,
                                        "maxlength": 20
                                    },
                                    "adresse_l_cm":{
                                        "required": true,
                                        "minlength": 10,
                                        "maxlength": 500
                                    },
                                    "adresse_l_suite_cm":{
                                        "maxlength": 40
                                    },
                                    "adresse_l_zip_cm":{
                                        "required": true,
                                        "digits": true,
                                        "minlength": 5,
                                        "maxlength": 5
                                    },
                                    "adresse_l_ville_cm":{
                                        "required": true,
                                        "minlength": 4,
                                        "maxlength": 20
                                    }

            
                                },
                                submitHandler: function(){
                                    $.ajax({  
                                        type: "POST",  
                                        url: "CreerEditerCompte",  
                                        data: "but=modifierC&login=" + $("#login_cm").val() + "&password=" + $("#password_cm").val()
                                        +"&nom=" + $("#nom_cm").val() +"&email=" + $("#email_cm").val() + "&num_tel=" + $("#num_tel_cm").val()
                                        +"&adresse_f=" + $("#adresse_f_cm").val() +" "+ $("#adresse_f_suite_cm").val() 
                                        +"&adresse_f_zip=" + $("#adresse_f_zip_cm").val() + "&adresse_f_ville=" + $("#adresse_f_ville_cm").val()
                                        +"&adresse_l=" + $("#adresse_l_cm").val() +" "+ $("#adresse_l_suite_cm").val() 
                                        +"&adresse_l_zip=" + $("#adresse_l_zip_cm").val() + "&adresse_l_ville=" + $("#adresse_l_ville_cm").val(),
           
                                        success: function (msg) {  
                                            
                                            
                                            if (msg == 1) {  
                                               
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Le compte a bien ete modifie.</center><br />").fadeIn("slow");
                        
                                            } 
                                            else if (msg == -1){
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Email deja utilise ! </center>").fadeIn("slow");
                        
                                            }
                                            else if(msg == -2)
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Login deja utilise ! </center>").fadeIn("slow");
                        
                                            }
                                            else if(msg == -3)
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Vous n'avez effectue aucune modification ! </center>").fadeIn("slow");
                        
                                            }
                                            else
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Une erreur est survenue, le traitement ne peut etre effectue </center>").fadeIn("slow");
                         
                                            }
                                        }  
                                    });  
                                    return false;  
            
                                }

                            })
                        });
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Le compte recherche n'existe pas ! </center>").fadeIn("slow");
                        $('span#erreurModification').empty();
                        $('div#menuModifC').empty();
                    }
                    else
                    {
                        $('span#erreurModification').empty();
                        $('div#menuModifC').empty();
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Une erreur est survenue, le traitement ne peut etre effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    jQuery("#formSupprimmerC").validate({
        rules: {
            "login_cs": {
                "login": true,
                "maxlength": 20,
                "minlength": 3
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCompte",  
                data: "but=supprimerC&login=" + $("#login_cs").val(),
                success: function (msg) {  
                 

                    if (msg == 1) {
                        
                        
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le compte a ete supprime ! </center>").fadeIn("slow");
                        
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le compte a supprimer n'existe pas ! </center>").fadeIn("slow");
                        
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

    }),
    
    jQuery("#formCreationP").validate({
        rules: {
            "nom_p":{
                "required": true,
                "minlength": 3,
                "maxlength": 40
            },
            "prix_p": {
                "required" : true,
                "prix": true,
                "maxlength": 6,
                "minlength": 1
            },
            "categorie_p":{
            },
            "distributeur_p":{
                "required": true
            },
            "editeur_p":{
                "required": true,
                "minlength": 4,
                "maxlength": 20
            },
            "developpeur_p":{
                "required": true,
                "minlength": 4,
                "maxlength": 20
            },
            "date":{
                "required": true,
                "minlength": 1
            },
            "image_p":{
                "required": true,
                "url": true,
                "minlength": 5,
                "maxlength": 300
            },
            "description_p":{
                "required": true,
                "minlength": 30,
                "maxlength": 700
            },
            "quantite_p":{
                "required": true,
                "number": true,
                "range" : [0, 9999],
                "maxlength": 5
            }

            
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerProduit",  
                data: "but=creerP&nom=" + $("#nom_p").val() + "&prix=" + $("#prix_p").val()
                +"&categorie=" + $("#categorie_p").val() + "&distributeur=" + $("#distributeur_p").val()
                +"&editeur=" + $("#editeur_p").val() + "&developpeur=" + $("#developpeur_p").val()
                +"&date_sortie=" + $("#date").val() + "&categorie_age=" + $("#categorieage_p").val()
                +"&image=" + $("#image_p").val() + "&description=" + $("#description_p").val()
                +"&quantite=" + $("#quantite_p").val(),
                
                success: function (msg) {  
                
                 
                    
                    if (msg == 1) {  
                        effacer("#formCreationP");
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Le produit a bien ete cree.</center>").fadeIn("slow");
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Produit deja existant dans cette categorie ! </center>").fadeIn("slow");
                        
                    }
                    else
                    {
                        $('span#erreurCreation').hide();
                        $("span#erreurCreation").html ("<center> Une erreur est survenue, le traitement ne peut etre effectue </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    jQuery("#formRechercheP").validate({
        rules: {
            "nom_pr":{
                "required": true,
                "minlength": 3,
                "maxlength": 40
            },
            "categorie_pr":{
                "required": true
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "modifierP",  
                data: "nom=" + $("#nom_pr").val() +"&categorie=" + $("#categorie_pr").val(),
                
                success: function (msg) {  
                
                 
                    
                    if (msg == 1) {  
                        $('span#erreurRecherche').empty();
                        $('span#erreurModification').load("admin/modifierProduit.jsp #erreurModification");
                        $('div#menuModifP').load("admin/modifierProduit.jsp #formModificationP");
                        $('div#menuModifP').show();
                        
                        $("#ValiderModifierBoutonP").live('click',function(){
                            jQuery("#formModificationP").validate({
                                rules: {
                                    "nom_pm":{
                                        "required": true,
                                        "minlength": 3,
                                        "maxlength": 40
                                    },
                                    "prix_pm": {
                                        "required" : true,
                                        "prix": true,
                                        "maxlength": 6,
                                        "minlength": 1
                                    },
                                    "categorie_pm":{
                                    },
                                    "distributeur_pm":{
                                        "required": true
                                    },
                                    "editeur_pm":{
                                        "required": true,
                                        "minlength": 4,
                                        "maxlength": 20
                                    },
                                    "developpeur_pm":{
                                        "required": true,
                                        "minlength": 4,
                                        "maxlength": 20
                                    },
                                    "date_pm":{
                                        "required": true,
                                        "minlength": 1
                                    },
                                    "image_pm":{
                                        "required": true,
                                        "url": true,
                                        "minlength": 5,
                                        "maxlength": 300
                                    },
                                    "description_pm":{
                                        "required": true,
                                        "minlength": 30,
                                        "maxlength": 700
                                    },
                                    "quantite_pm":{
                                        "required": true,
                                        "number": true,
                                        "range" : [0, 9999],
                                        "maxlength": 5
                                    }

            
                                },
                                submitHandler: function(){
                                    $.ajax({  
                                        type: "POST",  
                                        url: "CreerEditerProduit",  
                                        data: "but=modifierP&nom=" + $("#nom_pm").val() + "&prix=" + $("#prix_pm").val()
                                        +"&categorie=" + $("#categorie_pm").val() + "&distributeur=" + $("#distributeur_pm").val()
                                        +"&editeur=" + $("#editeur_pm").val() + "&developpeur=" + $("#developpeur_pm").val()
                                        +"&date_sortie=" + $("#date_pm").val() + "&categorie_age=" + $("#categorieage_pm").val()
                                        +"&image=" + $("#image_pm").val() + "&description=" + $("#description_pm").val()
                                        +"&quantite=" + $("#quantite_pm").val(),
                
                                        success: function (msg) {  
                                            
                                            if (msg == 1) {  
                                               
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Le produit a bien ete modifie.</center><br />").fadeIn("slow");
                        
                                            } 
                                            else if (msg == -1){
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Ce produit existe deja dans cette categorie ! </center>").fadeIn("slow");
                        
                                            }
                                            else if (msg == -2){
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center>Aucune modification effectuee ! </center>").fadeIn("slow");
                        
                                            }
                                            else
                                            {
                                                $('span#erreurModification').hide();
                                                $("span#erreurModification").html ("<center> Une erreur est survenue, le traitement ne peut etre effectue </center>").fadeIn("slow");
                         
                                            }
                                        }  
                                    });  
                                    return false;  
            
                                }

                            })
                        });
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Le produit recherche n'existe pas ! </center>").fadeIn("slow");
                        $('span#erreurModification').empty();
                        $('div#menuModifP').empty();
                    }
                    else
                    {
                        $('span#erreurModification').empty();
                        $('div#menuModifP').empty();
                        $('span#erreurRecherche').hide();
                        $("span#erreurRecherche").html ("<center> Une erreur est survenue, le traitement ne peut etre effectué </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    }),
    
    jQuery("#formSupprimmerP").validate({
        rules: {
            "nom_ps": {
                "required": true,
                "maxlength": 20,
                "minlength": 3
            },
            "categorie_ps": {
                "required": true
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerProduit",  
                data: "but=supprimerP&nom=" + $("#nom_ps").val() + "&categorie=" + $("#categorie_ps").val(),
                success: function (msg) {  
                 
                    // Si l'admin existe, on execute le if 
                    if (msg == 1) {
                        
                        
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le produit a ete supprime ! </center>").fadeIn("slow");
                        
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Le produit a supprimer n'existe pas dans cette categorie ! </center>").fadeIn("slow");
                        
                    }
                    
                    else
                    {
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Une erreur est survenue, le traitement ne peut être effectue </center>").fadeIn("slow");
                         
                    }
                }  
            });  
            return false;  
            
        }

    })
    
    jQuery("#formSupprimmerCo").validate({
        rules: {
            "numero_cs": {
                "required": true,
                "digits": true,
                "maxlength": 10,
                "minlength": 5
            }
        },
        submitHandler: function(){
            $.ajax({  
                type: "POST",  
                url: "CreerEditerCommande",  
                data: "but=supprimerCo&num_confirm=" + $("#numero_cs").val(),
                success: function (msg) {  
                 
                    
                    if (msg == 1) {
                        
                        
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> La commande a ete supprime ! </center>").fadeIn("slow");
                        
                        
                    } 
                    else if (msg == -1){
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> La commande n'existe pas! </center>").fadeIn("slow");
                        
                    }
                    
                    else
                    {
                        $('span#erreurSuppression').hide();
                        $("span#erreurSuppression").html ("<center> Une erreur est survenue, le traitement ne peut être effectue </center>").fadeIn("slow");
                         
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

        bValid = bValid && checkLength( name, "nom du compte", 3, 20 );
        bValid = bValid && checkLength( password, "password", 3, 20 );


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