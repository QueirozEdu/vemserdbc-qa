function exibirTexto(frase) {
    document.write(frase);
    document.write('<br>')
}

var texto1 = prompt('Digite um texto aqui: ');
var texto2 = prompt('Digite uma palavra');

exibirTexto(`O texto digitado é ${texto1} e o segundo texto é: ${texto2}`);

