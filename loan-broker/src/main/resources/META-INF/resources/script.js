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

async function manageProject() {

   /* var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/broker/getProject", true);
    xhttp.send();
    console.log(xhttp);
    console.log(JSON.stringify(xhttp));
    //console.log(xhttp);
*/
    const response = await fetch("/broker/getProject", {
        method: 'GET', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url// body data type must match "Content-Type" header
    }).then(res => res.json());
    console.log(response);
}