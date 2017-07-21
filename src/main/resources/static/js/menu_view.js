
function showMenuDtl(menu){
	tableRowFocus(menu);
}

function tableRowFocus(menu){
	var $tr = $("tr[rel='"+menu.id+"']");
	if($tr){
		$('.selected').removeClass('selected');
		$tr.addClass('selected');
		$grid = $('#menuList');
		if ($("#sid_menu", $grid).size() == 0) {
			$grid.prepend('<input id="sid_menu" type="hidden" />');
		}
		$("#sid_menu", $grid).val(menu.id);
	}
}