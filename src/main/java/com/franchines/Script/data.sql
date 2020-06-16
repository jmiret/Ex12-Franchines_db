INSERT INTO Shop(name, pictures_number) VALUES("Shop_1", 1);
INSERT INTO Shop(name, pictures_number) VALUES("Shop_2", 2);
INSERT INTO Shop(name, pictures_number) VALUES("Shop_3", 3);

INSERT INTO Picture (picture_name, picture_author, price, date_reg, shop_id) 
	VALUES ("Karma", null, 12000, now(), 1);
INSERT INTO Picture (picture_name, picture_author, price, date_reg, shop_id) 
	VALUES ("Milking Time", "Elioth Gruner", 120000, now(), 1);
INSERT INTO Picture (picture_name, picture_author, price, date_reg, shop_id) 
	VALUES ("Bird's Eye View of the City of Omaha Nebraska", "Albert Ruger", 1500000, now(), 1);

INSERT INTO Picture (picture_name, picture_author, price, date_reg, shop_id) 
	VALUES ("The Tulip Folly", "Jean-Léon Gérôme", 1500000, now(), 2);
INSERT INTO Picture (picture_name, picture_author, price, date_reg, shop_id) 
	VALUES ("Caterina Isnarda marchesa di Caluso e Delibera Eleonora S.Martino di Parella marchesa di Rodi", "Mathieu Balthasar", 2500000, now(), 2);