<%-- 
    Document   : footer
    Created on : 9 mai 2011, 20:39:59
    Author     : Sangre
--%>
<% if (session.getAttribute("groupeUtilisateur") == null) {
        response.sendRedirect("index.jsp");
    }
%>
<div class="cl">&nbsp;</div>
<!-- Footer -->
<div id="footer">
    <% if (!session.getAttribute("groupeUtilisateur").equals("administrateur")) {%>
    <div class="navs">
        <div class="navs-bot">
            <div class="cl">&nbsp;</div>
            <ul>
                <li><input id="BoutonAdmin" size="12.5" class="boutonlien"type="link"value="Administration" ></li>

            </ul>	
            <div class="cl">&nbsp;</div>
        </div>
    </div>
    <%}%>
    <p class="copy">&copy; Miage Games.</p>
</div>
<!-- / Footer -->	
</div>
</div>
<!-- / Main -->
</div>
<!-- / Page -->

