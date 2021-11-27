function controle(){
    let description = document.getElementById("description").value;
    let dateDepart = document.getElementById("dateDepart").value;
    let dateFin = document.getElementById("dateFin").value;
    let sommeVoulu = document.getElementById("sommeVoulu").value;
    let workStatut = document.getElementById("workStatut").value;

    let date = new Date();


    //console.log(date);
    console.log("coucu");
    //On converti une valeur javascript en chaine JSON
    let isDateDepart = (dateDepart>=date);

    console.log(isDateDepart);
    //let isDateFin = (dateFin>dateDepart && dateFin<9999);
    let isSommeVoulu = sommeVoulu>0;
    console.log("coucu");

    //if(isDateDepart && isSommeVoulu){
        console.log("coucu"); //On rentre jamais ici

        let _data = {
            description: description,
            dateDepart: dateDepart,
            dateFin: dateFin,
            sommeVoulu: sommeVoulu,
            workStatut: workStatut
        }

        console.log(_data);

        let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "/broker/createProjectClient");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(_data));
   // }else{
        //if(!isDateDepart){window.alert("Error : la date de départ doit être supérieur à "+date.getFullYear()};
        if(!isSommeVoulu){window.alert("Error : la somme doit être supérieur à 0")}
   // }
}

