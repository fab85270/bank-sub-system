function controle(){
    let description = document.getElementById("description").value;
    let dateDepart = document.getElementById("dateDepart").value;
    let dateFin = document.getElementById("dateFin").value;
    let sommeVoulu = document.getElementById("sommeVoulu").value;
    let date = new Date();

    /* On converti une valeur javascript en chaine JSON */

    let isDateDepart = (dateDepart>=date.getFullYear() && dateDepart<9999);
    let isDateFin = (dateFin>dateDepart && dateFin<9999);
    let isSommeVoulu = sommeVoulu>0;

    if(isDateDepart && isDateFin && isSommeVoulu){
        let _data = {
            description: description,
            dateDepart: dateDepart,
            dateFin: dateFin,
            sommeVoulu: sommeVoulu
        }

        console.log(_data);

        let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "/broker/createProject");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(_data));
    }else{
        if(!isDateDepart){window.alert("Error : la date de départ doit être supérieur à "+date.getFullYear()+" et comporter 4 chiffres")}
        if(!isDateFin){window.alert("Error : la date de fin doit être supérieur à 2021 et comporter 4 chiffres")}
        if(!isDateValide){window.alert("Error : la date de départ doit être supérieur à la date de fin")}
        if(!isSommeVoulu){window.alert("Error : la somme doit être supérieur à 0")}
    }

}