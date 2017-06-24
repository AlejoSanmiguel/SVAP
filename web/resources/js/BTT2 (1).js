$(document).ready(function(){
      $('body').append('<aside id="topTop"class="filtro asidef well shadow container"><div  class="nav vertical-qcat" role="navigation"> <dl class="" id="id_category">               <dt class="dt-title">Categorías</dt> <dd> <h3>                   <a class="qcat-truncate" style="max-width:137px;" title="Otros" href=""> Otros </a> </h3> <em>(183)</em></dd> </dl> <dl class="" id="id_state">  </dl> <a class="qcat-more-filters" id="otherFilters" href="#"><span class="txt">Más opciones</span><i class="ch-icon-caret-down"></i></a> </dd> </dl> <dl> <dt>Precio</dt> <dd> <form id="priceForm" class="range-filter" action="#" method="get"> <fieldset>  <legend>Rango de precios</legend> <ul>  <li>  <label class="espacios" for="fromPrice"> <input class="tamprice" type="text" id="fromPrice" class="price-number" value="Mín." tabindex="3"> </label>  </li> <li>  <label class="espacios" for="toPrice"> <span>&nbsp;-&nbsp;</span>  <input class="tamprice" type="text" id="toPrice" class="price-number" value="Máx." tabindex="4"> </label>  </li> </ul> </fieldset> <p class="actions"> <input type="submit" value="Filtrar" title="Filtrar" class="btn"> </p></form> </dd> </dl> </div></aside>');
    	$(window).scroll(function () {
			if ($(this).scrollTop() != 0) {
				$('#toTop').fadeIn();
			} else {
				$('#toTop').fadeOut();
			}
		}); 
    $('#toTop').click(function(){
        $("html, body").animate({ scrollTop: 0 }, 2000);
        return false;
    });
});