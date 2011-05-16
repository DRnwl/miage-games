
<div id="sidebar">
    <!-- Search -->
    <div id="search" class="block">
        <div class="block-bot">
            <div class="block-cnt">
                <form action="" method="post">
                    <div class="cl">&nbsp;</div>
                    <div class="fieldplace">
                        <input type="text" class="field" value="Search" title="Search" />
                    </div>
                    <input type="submit" class="button" value="GO" />
                    <div class="cl">&nbsp;</div>
                </form>
            </div>
        </div>
    </div>

    <div id="bienvenue" class="block">
        <div class="block-bot">
            <div class="block-cnt">
                <center> <h3>Bienvenue ${login}<br /> Vous êtes un ${groupeUtilisateur} </h3></center>
            </div>
        </div>
    </div>
    <!-- / Search -->
    <!-- Sign In -->
    <div id="sign" class="block">
        <div class="block-bot">
            <div class="block-cnt">
                <div class="cl">&nbsp;</div>
                <div id="menu">
                    <% if (session.getAttribute("groupeUtilisateur").equals("visiteur")) {%>
                    <div id="menuVisiteur" >
                        <div id="formConnexion" style="display:none">
                            <form id ="formConnex" name="session" action="" method=post>
                                <div id="loginBox" class="rounded">
                                    <span id="erreurConnexion"></span>  
                                    <p><strong>Nom du compte:</strong></p>
                                    <p> <input type="text" size="20" name="login" id="login"></p>

                                    <p><strong>Password:</strong></p>
                                    <p><input type="password" size="20" name="password" id="password"></p>
                                    <br />
                                    <input id="ValiderConnexion" class="button" value=" Valider " name="Valider"   type="submit" />

                                </div>
                            </form>
                            <br>
                        </div>
                        <a href="creerClient" class="button button-left">Creer compte</a>
                        <a href="#" id="BoutonConnexion" class="button button-right" onClick="return false">Connexion</a>
                        <div class='cl'>&nbsp;</div>
                    </div>
                    <% }
                        if (session.getAttribute("groupeUtilisateur").equals("client")) {%>
                    <div id="menuUser"> 

                        <div id="menuDeroulantUser">
                            <a href="modifierC" id="ModifierCompte" class="button button-center">Modifier Compte</a>
                            <a href="voirCommandes" id="VoirCommande" class="button button-center">Voir commande</a>                   
                            <br />
                        </div>


                        <a href="#" id="BoutonMenuU"class="button button-left" onClick="return false">Menu</a>

                        <a href="#" id="BoutonDeconnexion" class="button button-right" onClick="return false">Deconnexion</a>

                        <div class="cl">&nbsp;</div>
                    </div>
                    <%} else if (session.getAttribute("groupeUtilisateur").equals("administrateur")) {%>
                    <div id="menuAdmin"> 

                        <div id="menuDeroulantAdmin">
                            <a href="modifierA" id="ModifierInfo" class="button button-center">Modifier Compte</a>
                            <a href="voirAdmin" id="Admin" class="button button-center">Admins</a>
                            <a href="voirClient" id="Clients" class="button button-center">Clients</a>
                            <a href="voirCommande" id="Commandes" class="button button-center">Commandes</a>
                            <a href="voirProduit" id="Produits" class="button button-center">Produits</a>
                            <br>
                        </div>


                        <a href="#" id="BoutonMenuA"class="button button-left" onClick="return false">Menu</a>

                        <a href="#" id="BoutonDeconnexion" class="button button-right" onClick="return false">Deconnexion</a>

                        <div class="cl">&nbsp;</div>
                    </div>
                    <%}%>
                </div>
                <%if (!session.getAttribute("groupeUtilisateur").equals("administrateur")) {%>
                <div id="connAdmin" title="Connexion">
                    <p class="validateTips">Tous les champs sont requis</p>

                    <form id ="formConnexA" name="session" action="" method=post>
                        <fieldset>
                            <label for="login_a">Nom de compte</label>
                            <input type="text" name="login_a" id="login_a" class="text ui-widget-content ui-corner-all" />
                            <label for="password_a">Password</label>
                            <input type="password" name="password_a" id="password_a" value="" class="text ui-widget-content ui-corner-all" />

                        </fieldset>
                        <div style="display:none"><input type="submit" id="BoutonConnexionA"/></div>


                    </form>
                </div>
                <% }%>
            </div>
        </div>
    </div>

    <!-- / Sign In -->
</div>
