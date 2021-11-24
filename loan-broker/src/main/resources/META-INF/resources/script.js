function controle(){
    var description = document.getElementById("description").value;
    var dateDepart = document.getElementById("dateDepart").value;
    var dateFin = document.getElementById("dateFin").value;
    var sommeVoulu = document.getElementById("sommeVoulu").value;

    /* On converti une valeur javascript en chaine JSON */

    let _data = {
        description: description,
        dateDepart: dateDepart,
        dateFin: dateFin,
        sommeVoulu: sommeVoulu
    }

    console.log(_data);

    var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
    xmlhttp.open("POST", "/broker/createProject");
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(_data));
    /*
    fetch('http://localhost:8080/broker/createProject',{
        method: "POST",
        body: _data,
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
    /*let test =JSON.stringify({description:description,dateDepart:dateDepart,dateFin:dateFin,someVoulou:sommeVoulou});
    console.log(test);*/
}