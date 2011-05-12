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
    <!-- / Search -->
    <!-- Sign In -->
    <div id="sign" class="block">
        <div class="block-bot">
            <div class="block-cnt">
                <div class="cl">&nbsp;</div>
                <div id="menu">
                    <% if (session.getAttribute("groupeUtilisateur") == "visiteur") {%>
                    <div id="menuVisiteur" >
                        <div id="formConnexion" style="display:none">
                            <form id ="formConnex" name="session" action="#" method=post>
                                <div id="loginBox" class="rounded">
                                    <span id="erreurConnexion"></span>  
                                    <p><strong>Nom du compte:</strong></p>
                                    <p> <input type="text" size="20" id="login"></p>

                                    <p><strong>Password:</strong></p>
                                    <p><input type="password" size="20" id="password"></p>
                                    <br />
                                    <input id="send" value=" Valider " name="Valider" onclick="fermerForm()"  type="submit" />

                                </div>
                            </form>
                            <br>
                        </div>
                        <a href="#" class="button button-left">Creer compte</a>
                        <a href="#" id="BoutonConnexion" class="button button-right">Connexion</a>
                        <div class='cl'>&nbsp;</div>
                    </div>
                    <% }
                        if (session.getAttribute("groupeUtilisateur") == "utilisateur") {%>
                    <div id="menuUser"> 

                        <div id="menuDeroulantUser">
                            <p align="center"><a href="categorie?cat=PC" id="BoutonTest" class="button">Test</a></p>
                        </div>

                        <br>
                        <a href="#" id="BoutonMenu"class="button button-left">Menu</a>

                        <a href="#" id="BoutonDeconnexion" class="button button-right">Deconnexion</a>

                        <div class="cl">&nbsp;</div>
                    </div>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
    <!-- / Sign In -->
</div>
