INSERT INTO "user" (email, name, last_name, password) VALUES ('pedrosilva@hotmail.com', 'Pedro', 'Silva', '$2y$12$lBRPSdZ9ft9G8uKz7tr5yuNSqXLzl/vynOaNViLZP7ACzWNOUmrPq')
INSERT INTO "user" (email, name, last_name, password) VALUES ('carlosroberto@hotmail.com', 'Carlos', 'Roberto', '$2y$12$5Uw2tiN9Sa37Xq.fO.VHtOCOf6fPWQnUMlg.79TH6mKEZ40DM22qm')
INSERT INTO "user" (email, name, last_name, password) VALUES ('mariana08@hotmail.com', 'Mariana', 'B. Ferreira', '$2y$12$dag5AxvurR70mSU0C.YhUOT306l2BWjCiL084YoNx2GONlBIQ7BxK')
INSERT INTO "user" (email, name, last_name, password) VALUES ('fernando_jose@hotmail.com', 'Fernando', 'José', '$2y$12$oNLJhkClUvlgnDVsaSNfLeSVDG7CSDmCESuoZXOxJH7F9MKuRUzZG')
INSERT INTO "user" (email, name, last_name, password) VALUES ('admin@admin.com', 'admin', 'admin', '$2y$12$s8Pz4v50PMJYjUIj40nPC.LBC2TrY/4ABWpwQqE4kVtMkEq.94kz')

INSERT INTO "perfil" (name) VALUES ('ADMIN')
INSERT INTO "perfil" (name) VALUES ('USER')

INSERT INTO "expense" (date_time, description, tag, "value", "user") VALUES ('2021-01-07T14:30:40.000100', 'Pagamento cartão de crédito', 'NÃO PAGO', 2000, 1)
INSERT INTO "expense" (date_time, description, tag, "value", "user") VALUES ('2021-01-06T19:30:40.023000', 'Pagamento carro', 'NÃO PAGO', 900, 2)
INSERT INTO "expense" (date_time, description, tag, "value", "user") VALUES ('2021-01-05T10:26:40.124500', 'Pagamento emprestimo', 'NÃO PAGO', 1500, 3)
INSERT INTO "expense" (date_time, description, tag, "value", "user") VALUES ('2021-01-04T13:10:40.123100', 'Pagamento ipva', 'NÃO PAGO', 1200, 4)

INSERT INTO "user_perfil_entity_list" (user_entity_id, perfil_entity_list_id) values (1, 2)
INSERT INTO "user_perfil_entity_list" (user_entity_id, perfil_entity_list_id) values (2, 2)
INSERT INTO "user_perfil_entity_list" (user_entity_id, perfil_entity_list_id) values (3, 2)
INSERT INTO "user_perfil_entity_list" (user_entity_id, perfil_entity_list_id) values (4, 2)
INSERT INTO "user_perfil_entity_list" (user_entity_id, perfil_entity_list_id) values (5, 1)