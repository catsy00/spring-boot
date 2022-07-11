$.fn.extend({ProgressBarWars: function(opciones) {
					var ProgressBarWars=this;
					var theidProgressBarWars=$(ProgressBarWars).attr("id");
					var styleUnique = Date.now();
                    var StringStyle="";
					
					defaults = {
					porcentaje:"100",
					tiempo:1000,
					color:"",
					estilo:"vader",
					tamanio:"30%",
					alto:"15px"
					}
					
					var opciones = $.extend({}, defaults, opciones);
					if(opciones.color!=''){StringStyle="<style>.color"+styleUnique+"{ border-radius: 5px;display: block; width: 0%; "+";background-color: #ff6600;}</style>";opciones.estilo="color"+styleUnique;}
					$(ProgressBarWars).before(StringStyle);
					$(ProgressBarWars).append('<span class="barControl" style="width:'+opciones.tamanio+';"><div class="barContro_space"><span class="'+opciones.estilo+'" style="height: '+opciones.alto+';"  id="bar'+theidProgressBarWars+'"></span></div></span>');
					$("#bar"+theidProgressBarWars).animate({width: opciones.porcentaje+"%"},opciones.tiempo);
					this.mover = function(ntamanio) {
					$("#bar"+$(this).attr("id")).animate({width:ntamanio+"%"},opciones.tiempo);
					};
	return this;			 
	}
});
