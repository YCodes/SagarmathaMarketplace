INSERT INTO `sagarmatha`.`user`(`username`, `password`, `enabled`, `role`) VALUES ('admin@mum.edu', 'admin', True, 'Admin');
INSERT INTO `sagarmatha`.`admin`(`firstname`, `lastname`, `phonenumber`, `email`, `user_id`, `addressid`) VALUES ('admin',
'admin','1234','admin@mum.edu','1','1');
INSERT INTO `sagarmatha`.`address`(`street`, `city`, `zip_code`, `state`,'country') VALUES ('1000 North', 'Fairfield', '52557', 'Iowa','US');