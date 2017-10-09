
$(function () {
    $('#add').click(function () {
        var input = '<div class="form-group col-md-6">';
        input += '<label for="palavraChave">Palavra Chave: </label>';
        input += '<input type="text" class="form-control" name="palavraChave" id="palavraChave" required>';
        input += '<a href="#" class="btn btn-danger btn-xs">X</a></div>';

        $("#palavrasChave").append(input);
        return false;
    });

    $('#palavrasChave').delegate('a', 'click', function (e) {
        e.preventDefault();
        $(this).parent('div').remove();
    });
});