function controle() {
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

    let todaySDate = new Date(Date.now());
    const regex = new RegExp(/^[0-9]{10}$/);

    /*Vérification saisie*/
    let isSommeValid = requiredValue>0;
    let isRequiredValueValid = requiredValue>0;
    let isDurationMaxValid = durationMax>0;
    //let isProposalDateValid = proposalDate>todaySDate;
    let isExpirationDateValid = expirationDate>proposalDate;
    let isSurfaceValid = surface>0;
    let isConstructionYearValid = constructionYear>0
    let isPriceValid = price>0;
    let isNumberOfRoomsValid = numberOfRooms>0;
    let isStreetNumberRealEstateValid = streetNumberRealEstate>0;
    let isPostalCodeRealEstateValid = postalCodeRealEstate >0 && postalCodeRealEstate<99999;
    let isStreetNumberBorrowerValid = streetNumberBorrower>0;
    let isPostalCodeBorrowerValid = postalCodeBorrower>0;
    //let isBirthdateValid = birthdate<todaySDate;
    let isAnnualSalaryValud = annualSalary>0;
    let isFirstDepositValid = firstDeposit>0;
    let isRequiredInterestValid = requiredInterest>0;
    let isMonthlyRefundValid = monthlyRefund>0;
    let isDebtRatioValid = debtRatio>0;

    if(isSommeValid && isRequiredValueValid && isDurationMaxValid  && isExpirationDateValid && isSurfaceValid && isConstructionYearValid && isPriceValid &&
        isNumberOfRoomsValid && isStreetNumberRealEstateValid && isPostalCodeRealEstateValid && isStreetNumberBorrowerValid && isPostalCodeBorrowerValid &&
        isAnnualSalaryValud && isFirstDepositValid && isRequiredInterestValid && isMonthlyRefundValid && isDebtRatioValid){
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
        xmlhttp.open("POST", "/broker/createProject");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify(_data));
    }

    // }
}

