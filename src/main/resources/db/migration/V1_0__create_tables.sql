# ************************************** `Country`

CREATE TABLE `Country`
(
 `id`          nvarchar(3) NOT NULL ,
 `countryName` nvarchar(50) NOT NULL UNIQUE,

PRIMARY KEY (`id`)
);

-- ************************************** 'User'

CREATE TABLE `User`
(
 `id`         int NOT NULL AUTO_INCREMENT ,
 `nameUser`       nvarchar(50) NOT NULL ,
 `surnameUser`    nvarchar(50) NOT NULL ,
 `email`      nvarchar(12) NOT NULL UNIQUE ,
 `password`   nvarchar(100) NOT NULL ,
 `country_id` nvarchar(3) NOT NULL ,
 `role`       nvarchar(50) NOT NULL DEFAULT 'ROLE_USER',

PRIMARY KEY (`id`),
KEY `fkIdx_30` (`country_id`),
CONSTRAINT `FK_29` FOREIGN KEY `fkIdx_30` (`country_id`) REFERENCES `Country` (`id`),
CONSTRAINT verify_role CHECK ( role IN ('ROLE_ADMIN', 'ROLE_USER'))
);

# ************************************** `Transfer`

CREATE TABLE `Transfer`
(
 `id`                 int NOT NULL AUTO_INCREMENT ,
 `sum`                decimal(15,2) NOT NULL ,
 `currency`           nvarchar(50) NOT NULL ,
 `sender_id`          int NOT NULL ,
 `nameRecipient`      nvarchar(50) NOT NULL ,
 `surnameRecipient`   nvarchar(50) NOT NULL ,
 `recipient_id`       int ,
 `transferNumber`     int NOT NULL UNIQUE ,
 `status`             nvarchar(50) NOT NULL ,

PRIMARY KEY (`id`),
KEY `fkIdx_38` (`sender_id`),
CONSTRAINT `FK_37` FOREIGN KEY `fkIdx_38` (`sender_id`) REFERENCES `User` (`id`),
KEY `fkIdx_41` (`recipient_id`),
CONSTRAINT `FK_40` FOREIGN KEY `fkIdx_41` (`recipient_id`) REFERENCES `User` (`id`)
);