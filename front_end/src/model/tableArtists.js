jQuery(document).ready(function($){

    function fetchArtists(endpoint = null, params = '') {

        fetch(endpoint+params).then(
            res => {
                res.json().then(
                    data => {
                        console.log(data);
                        if (data.length > 0) {

                            var temp = "";
                            data.forEach((itemData) => {
                                temp += "<tr>";
                                temp += "<td>" + itemData.nome + "</td>";
                                temp += "<td>" + itemData.ltuogoNascita + "</td>";
                                temp += "<td>" + itemData.dataNascita + "</td>";
                                temp += "<td>" + itemData.luogoMorte + "</td>";
                                temp += "<td>" + itemData.dataMorte + "</td>";
                                temp += "<td>" + itemData.natzionalita + "</td>";
                                temp += "</tr>";
                            });
                            $("#artists-list").html(temp);
                        }
                    }
                )
            }
        )
    }

    fetchArtists('http://localhost:8080/api/v1/artisti');

    $('#search-btn').on('click', function(){
       var nomeArtista = $('#search-text').val();
        fetchArtists('http://localhost:8080/api/v1/artistaSpecifico', '?nome='+nomeArtista);
    });

});
