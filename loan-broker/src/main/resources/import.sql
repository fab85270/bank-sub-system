

REPLACE INTO `Address` (`idAddress`,`city`,`complementaryAddress`, `postalCode`,`streetName`, `streetNumber`) VALUES
    (1,'Villejuif','',94800,'Avenue de Paris',2),
    (2, 'Paris', '3e etage',75013,'Rue du general de Gaule',10);

REPLACE INTO `Bank` (`bankId`,`bankName`,`addressId`) VALUES
    (1,'lcl',1),
    (2,'bnp',2);




