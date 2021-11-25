function controle(){
    let description = document.getElementById("description").value;
    let dateDepart = document.getElementById("dateDepart").value;
    let dateFin = document.getElementById("dateFin").value;
    let sommeVoulu = document.getElementById("sommeVoulu").value;
    let workStatut = document.getElementById("workStatut").value;
    let date = new Date();

    console.log(dateDepart);
    //On converti une valeur javascript en chaine JSON
    let isDateDepart = (dateDepart>=date.getFullYear());
    //let isDateFin = (dateFin>dateDepart && dateFin<9999);
    let isSommeVoulu = sommeVoulu>0;

    if(isDateDepart && isSommeVoulu){
        let _data = {
            description: description,
            dateDepart: dateDepart,
            dateFin: dateFin,
            sommeVoulu: sommeVoulu,
            workStatut: workStatut
        }

        console.log(_data);

        let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "/broker/createProject");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(_data));
    }else{
        //if(!isDateDepart){window.alert("Error : la date de départ doit être supérieur à "+date.getFullYear()};
        if(!isSommeVoulu){window.alert("Error : la somme doit être supérieur à 0")}
    }
}

function manageProject(){
    let _data

    let xmlhttp = new XMLHttpRequest();
    xhr.open('GET', "/getProject");
    xhr.send();
    xhr.onload = function (){
        _data = xhr.response;
    }

}