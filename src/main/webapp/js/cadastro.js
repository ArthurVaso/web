function show(element) {
	element.classList.remove('oculto');
}

function hide(element) {
	element.classList.add('oculto');
}

function validarTexto(id) {
	const fieldSelector = '#' + id;
	const errorSelector = fieldSelector + ' + .error';
	let valido = true;
	
	const txtInput = document.querySelector(fieldSelector);	
	const errorMsg = document.querySelector(errorSelector);
	if (txtInput.value == '') {
		show(errorMsg);
		valido = false;
	} else {
		hide(errorMsg);
	}
	
	// console.info(fieldSelector, errorSelector, valido);
	
	return valido;
}

function validarForm() {
	let valido = true;

	valido = validarTexto('nome') && valido;	
	valido = validarTexto('email') && valido;
	
	return valido;	
}