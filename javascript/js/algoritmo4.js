var value1 = prompt('Valor a ser convertido');

function converter(value) {
    return ((5 / 9) * (value1 - 32)).toFixed(2);
}
document.getElementById('algoritmo4').innerHTML = converter(value1);
