async function controle() {
    let projectDescription = document.getElementById("projectDescription").value;
    let requiredValue = document.getElementById("requiredValue").value; //Somme désirée par l'utilisateur
    let durationMax = document.getElementById("durationMax").value; //Durée maximale souhaitée par l'utilisateur
    let proposalDate = document.getElementById("proposalDate").value; //Date de départ de l'emprunt souhaitée
    let expirationDate = document.getElementById("expirationDate").value;//Date de fin emprunt souhaitée

    let surface = document.getElementById("surface").value;
    let constructionYear = document.getElementById("constructionYear").value;
    let price = document.getElementById("price").value;
    let numberOfRooms = document.getElementById("numberOfRooms").value;
    let streetNameRealEstate = document.getElementById("streetNameRealEstate").value;
    let streetNumberRealEstate = document.getElementById("streetNumberRealEstate").value;
    let postalCodeRealEstate = document.getElementById("postalCodeRealEstate").value;
    let cityRealEstate = document.getElementById("cityRealEstate").value;
    let complementaryAddressRealEstate = document.getElementById("complementaryAddressRealEstate").value;

    let streetNameBorrower = document.getElementById("streetNameBorrower").value;
    let streetNumberBorrower = document.getElementById("streetNumberBorrower").value;
    let postalCodeBorrower = document.getElementById("postalCodeBorrower").value;
    let cityBorrower = document.getElementById("cityBorrower").value;
    let complementaryAddressBorrower = document.getElementById("complementaryAddressBorrower").value;
    let email = document.getElementById("email").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let gender = document.getElementById("gender").value;
    let birthdate = document.getElementById("birthdate").value;
    let employmentContract = document.getElementById("employmentContract").value;
    let annualSalary = document.getElementById("annualSalary").value;
    let firstDeposit = document.getElementById("firstDeposit").value;
    let phoneNumber = document.getElementById("phoneNumber").value;
    let requiredInterest = document.getElementById("requiredInterest").value;
    let monthlyRefund = document.getElementById("monthlyRefund").value;
    let debtRatio = document.getElementById("debtRatio").value;

    /* Vérification que l'adresse mail saisie n'existe pas déja */
    /*On construit l'URL selon le mail saisit par l'utilisateur */

    let url = "/mail/"+email;
    const responseMail = await fetch(url, {
        method: 'HEAD', // *GET, POST, PUT, DELETE, etc.
        mode: 'cors', // no-cors, *cors, same-origin
        cache: 'no-cache', // *default, no-cache, reload, force-cache, only-if-cached
        credentials: 'same-origin', // include, *same-origin, omit
        headers: {
            'Content-Type': 'application/json'
            // 'Content-Type': 'application/x-www-form-urlencoded',
        },
        redirect: 'follow', // manual, *follow, error
        referrerPolicy: 'no-referrer', // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url// body data type must match "Content-Type" header
    });

    //Message d'erreur contenu dans le header de la requete
    if(responseMail.status!=404){
        window.alert("Error : l'email est deja present")
    }else {
        /* Création au format JSON des informations saisies par l'utilisateur*/

        let _data = {

            "projectDescription": projectDescription,
            "requiredValue": requiredValue,
            "durationMax": durationMax,
            "proposalDate": proposalDate,
            "expirationDate": expirationDate,
            "realEstateId": {
                "surface": surface,
                "constructionYear": constructionYear,
                "price": price,
                "numberOfRooms": numberOfRooms,
                "addressId": {
                    "streetName": streetNameRealEstate,
                    "streetNumber": streetNumberRealEstate,
                    "postalCode": postalCodeRealEstate,
                    "city": cityRealEstate,
                    "complementaryAddress": complementaryAddressRealEstate
                },
            },
            "borrowerId": {
                "addressId": {
                    "streetName": streetNameBorrower,
                    "streetNumber": streetNumberBorrower,
                    "postalCode": postalCodeBorrower,
                    "city": cityBorrower,
                    "complementaryAddress": complementaryAddressBorrower
                },
                "email": email,
                "firstName": firstName,
                "lastName": lastName,
                "gender": gender,
                "birthdate": birthdate,
                "employmentContract": employmentContract,
                "annualSalary": annualSalary,
                "firstDeposit": firstDeposit,
                "phoneNumber": phoneNumber,
                "requiredInterest": requiredInterest,
                "monthlyRefund": monthlyRefund,
                "debtRatio": debtRatio
            }
        }

        console.log(_data);

        let xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "/project/project");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(_data));
        // }else{
        //if(!isDateDepart){window.alert("Error : la date de départ doit être supérieur à "+date.getFullYear()};
        if (!requiredValue) {
            window.alert("Error : la somme doit être supérieur à 0")
        }
        window.alert('Votre projet a bien été envoyé');
    }
}