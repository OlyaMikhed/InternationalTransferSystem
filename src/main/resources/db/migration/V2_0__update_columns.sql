ALTER TABLE Country RENAME COLUMN `countryName` TO `country_name`;

ALTER TABLE Transfer rename to `Transaction`;

ALTER TABLE Transaction RENAME COLUMN `nameRecipient` TO `name_recipient`;

ALTER TABLE Transaction RENAME COLUMN `surnameRecipient` TO `surname_recipient`;

ALTER TABLE Transaction RENAME COLUMN `transferNumber` TO `transfer_number`;

ALTER TABLE User RENAME COLUMN `nameUser` TO `name_user`;

ALTER TABLE User RENAME COLUMN `surnameUser` TO `surname_user`;

ALTER TABLE User modify email nvarchar(50) NOT NULL UNIQUE;