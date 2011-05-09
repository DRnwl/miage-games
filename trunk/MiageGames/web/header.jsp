<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Page -->
		<div id="page" class="shell">
			<!-- Header -->
			<div id="header">
				<!-- Top Navigation -->
				<div id="top-nav">
					<ul>
						<li class="home"><a href="#">Accueil</a></li>
					    <c:forEach var="categorie" items="${categories}">
                    
                                                <li><a href="/ventes/categorie.jsp?cat=${categorie.nom}">${categorie.nom}</a></li>
               
                                            </c:forEach> 
					</ul>
				</div>
				<!-- / Top Navigation -->
				<div class="cl">&nbsp;</div>
				<!-- Logo -->
				<div id="logo">
					<h1><a href="#">Miage <span>Games</span></a></h1>
					<p class="description">Votre zone de jeu</p>
				</div>
				<!-- / Logo -->
				<!-- Main Navigation -->
				<div id="main-nav">
					<div class="bg-right">
						<div class="bg-left">
							<ul>
							    <li><a href="#">community</a></li>
							    <li><a href="#">forum</a></li>
							    <li><a href="#">video</a></li>
							    <li><a href="#">cheats</a></li>
							    <li><a href="#">features</a></li>
							    <li><a href="#">downloads</a></li>
							    <li><a href="#">sports</a></li>
							    <li><a href="#">tech</a></li>
							</ul>
						</div>
					</div>
				</div>
				<!-- / Main Navigation -->
				<div class="cl">&nbsp;</div>
				<!-- Sort Navigation -->
				<div id="sort-nav">
					<div class="bg-right">
						<div class="bg-left">
							<div class="cl">&nbsp;</div>
							<ul>
							    <li class="first active first-active"><a href="#">Review</a><span class="sep">&nbsp;</span></li>
							    <li><a href="#">Previews </a><span class="sep">&nbsp;</span></li>
							    <li><a href="#">New Releases</a><span class="sep">&nbsp;</span></li>
							    <li><a href="#">Top Games</a><span class="sep">&nbsp;</span></li>
							    <li><a href="#">All Games</a><span class="sep">&nbsp;</span></li>
							</ul>
							<div class="cl">&nbsp;</div>
						</div>
					</div>
				</div>
				<!-- / Sort Navigation -->
			</div>
			<!-- / Header -->
			<!-- Main -->
			<div id="main">
				<div id="main-bot">
					<div class="cl">&nbsp;</div>
