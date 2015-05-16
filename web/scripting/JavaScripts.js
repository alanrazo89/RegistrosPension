
function txtalfanum(string) {
    for
            (var i = 0, output = '',
                    validos = " .-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ@1234567890";
                    i < string.length; i++)
        if (validos.indexOf(string.charAt(i)) != -1)
            output += string.charAt(i)
    return output;
}
function txt(string) {
    for
            (var i = 0, output = '',
                    validos = " .-_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
                    i < string.length; i++)
        if (validos.indexOf(string.charAt(i)) != -1)
            output += string.charAt(i)
    return output;
}

function vdoble(string) {
    for
            (var i = 0, output = '',
                    validos = "1234567890.-";
                    i < string.length; i++)
        if (validos.indexOf(string.charAt(i)) != -1)
            output += string.charAt(i)
    return output;
}

function ventero(string) {
    for
            (var i = 0, output = '',
                    validos = "1234567890";
                    i < string.length; i++)
        if (validos.indexOf(string.charAt(i)) != -1)
            output += string.charAt(i)
    return output;
}

function popup(url, ancho, alto) {
    var posicion_x;
    var posicion_y;
    posicion_x = (screen.width / 2) - (ancho / 2);
    posicion_y = (screen.height / 2) - (alto / 2);

    window
            .open(
                    url,
                    "ERP Alan Gonzalez",
                    "width="
                    + ancho
                    + ",height="
                    + alto
                    + ",location=no,menubar=no,toolbar=no,directories=no,scrollbars=yes,resizable=no,left="
                    + posicion_x + ",top=" + posicion_y + "");
}




