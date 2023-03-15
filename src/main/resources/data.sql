INSERT IGNORE INTO categories(id, name, description) VALUES ('0243a270-8348-4a7f-867e-6c0cc5984adc','TRAVEL','Mochillas para viajar');
INSERT IGNORE INTO categories(id, name, description) VALUES ('d20a14b6-15d5-42ee-8779-36ea7be4dc6d','SCHOOL','Mochillas para la escuela');
INSERT IGNORE INTO categories(id, name, description) VALUES ('c179ad35-a5fc-4ef0-9a1b-110a332f818f','SPORT','Mochillas deportivas');
INSERT IGNORE INTO categories(id, name, description) VALUES ('4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6','WORK','Mochillas para el trabajo');

INSERT IGNORE INTO roles(id, name, description) VALUES ('27fea06b-f25c-46c2-880d-23c2b8c21f8d','ADMIN','Rol de administrador');
INSERT IGNORE INTO roles(id, name, description) VALUES ('577272ea-fe2f-4c7c-833d-597046bc34be','USER','Rol de usuario');

INSERT IGNORE INTO users(id, first_name, last_name, email, password, address, role_id) VALUES ('2099c854-3862-42dd-b198-46f071053e76','Juan','Perez','juanperez@gmail.com','12345678','Las lomas','577272ea-fe2f-4c7c-833d-597046bc34be');

INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES('6613fbd7-61d3-49e4-a5e3-9788bea1ea73','Product A','Description del producto A','https://image.png',59.99,130,true,'0243a270-8348-4a7f-867e-6c0cc5984adc');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('f2b2f44a-b361-48b1-b86e-65fddf792e30', 'Mochilla Totto', 'Mochilla para niño totto','https://image.png',236.99,20,true,'d20a14b6-15d5-42ee-8779-36ea7be4dc6d');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('1aab9d7c-1780-4db4-9451-da4c64f2ffbd', 'Mochilla Husky', 'Mochilla para trabajo color rojo para hombre','https://image.png',306.85,39,true,'4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('3e828c11-b889-461c-8667-6a823e34c7d6', 'Mochila Roja', 'Description de la mochila roja','https://imageAO.png',629.54,50,true,'0243a270-8348-4a7f-867e-6c0cc5984adc');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('be8fbd85-2393-43a5-ab8a-03d4340c4006', 'Mochila Azul', 'Description de la mochila azul','https://imageA_O_2.png',456.21,65,true,'4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('d8c68ae6-eb85-4e00-a808-599748b58d1f', 'Mochila Michey S', 'Mochila que lleva tus personajes favoritos','https://image.png',389.00,50,true,'d20a14b6-15d5-42ee-8779-36ea7be4dc6d');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('66227292-7293-41c9-b352-af865ef63c5e', 'Mochila Estampado Acuarela', 'Lleva tus cosas con multiples compartimientos','https://image.png',309.00,80,true,'4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('99c6628b-1225-4756-94cf-ab3c385ef275', 'Product D001', 'Mochila en color plomo','https://media.gq.com.mx/photos/5ee930538f739bf973bc80f0/master/w_1600%2Cc_limit/Adidas%2520Prime%2520V%2520Backpack.jpg', 160, 25, true, 'c179ad35-a5fc-4ef0-9a1b-110a332f818f' );
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('dda3dceb-bf5b-416b-abfe-fa7fb2ac5195', 'Product Mano D101', 'Mochila de mano','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQDHuUj-vbkMUsGNS-m-5J9gDAIz9RQ5QgrUcI8B1yRF0enK2VxRZINIdBLoUqaCVA1l14&usqp=CAU', 125, 50, true, 'c179ad35-a5fc-4ef0-9a1b-110a332f818f' );
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('9b0708c4-cbd2-4db5-9787-d72d520c7808', 'Product Mano D101', 'Mochila de mano','https://imagenes.elpais.com/resizer/_b3BN7fHdV8bbWeg3HgiLdiKtvU=/414x0/cloudfront-eu-central-1.images.arcpublishing.com/prisa/UUZNSROKNFD7NO5RKTRHKT44KY.jpg', 125, 50, true, '4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6' );
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('40d472ae-b6fb-11ed-afa1-0242ac120002', 'Mochila de Viaje Pequeña', 'Para documentos ','https://image.png',50,130,true,'0243a270-8348-4a7f-867e-6c0cc5984adc');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('457c4976-b6fb-11ed-afa1-0242ac120002', 'Mochila de Viaje Mediana', 'Camping excurcion','https://image.png',120,130,true,'0243a270-8348-4a7f-867e-6c0cc5984adc');
INSERT IGNORE INTO products (id, name, description, image_url, price, stock, active, category_id) VALUES ('66227292-7293-41c9-b352-af865ef63c5e','Mochila Adidas Orange','multiples usos deportivo y escolar','https://www.adidaspadelargentina.com/wp-content/uploads/2019/11/mochila-barricade-orange-19-500x531.jpg', 560.99,75,true,'4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6');
INSERT IGNORE INTO products(id, name, description, image_url, price, stock, active, category_id) VALUES ('856ecaf1-f904-4c18-8958-068ee5f16465', 'product z', ' descripción of product z','https://image.png', 350.20,30, true, '4c5f3eef-37a1-43bc-a6bf-2be9a06c4ec6');
INSERT IGNORE INTO products(id, name, description, image_url, price, stock, active, category_id) VALUES ('27fbb0df-f013-4225-8554-ddb78dd993c3', 'product x', ' descripción of product x','https://image.png', 31,10, true, '0243a270-8348-4a7f-867e-6c0cc5984adc');