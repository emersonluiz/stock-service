INSERT INTO product_category (id, name, enable) VALUES (1, 'EPI', 1)

INSERT INTO unity (id, name) VALUES (1, 'peça (s)')

INSERT INTO reason (id, name, initials, enable) VALUES (1, 'Acidente', 'A', 1)
INSERT INTO reason (id, name, initials, enable) VALUES (2, 'Danificado', 'D', 1)
INSERT INTO reason (id, name, initials, enable) VALUES (3, 'Entrega da Admissão', 'E', 1)
INSERT INTO reason (id, name, initials, enable) VALUES (4, 'Inadequado', 'I', 1)
INSERT INTO reason (id, name, initials, enable) VALUES (5, 'Outros', 'O')
INSERT INTO reason (id, name, initials, enable) VALUES (6, 'Tempo de Uso', 'T', 1)

INSERT INTO size (id, name, product_category_id, enable) VALUES (1, 'G', 1, 1)

INSERT INTO document (id, name, enable) VALUES (1, 'RG', 1)

INSERT INTO product(id, product_category_id, name, enable, validity, minimum, unity_id, size) VALUES (1, 1, 'Camisa', 1, 0, 1, 1, 1)

INSERT INTO product(id, product_category_id, name, enable, validity, minimum, unity_id, size) VALUES (2, 1, 'Calça', 1, 0, 1, 1, 1)

INSERT INTO state (code, name) VALUES ('BR-AC', 'Acre')
INSERT INTO state (code, name) VALUES ('BR-AL', 'Alagoas')
INSERT INTO state (code, name) VALUES ('BR-AP', 'Amapá')
INSERT INTO state (code, name) VALUES ('BR-AM', 'Amazonas')
INSERT INTO state (code, name) VALUES ('BR-BA', 'Bahia')
INSERT INTO state (code, name) VALUES ('BR-CE', 'Ceará')
INSERT INTO state (code, name) VALUES ('BR-DF', 'Distrito Federal')
INSERT INTO state (code, name) VALUES ('BR-ES', 'Espírito Santo')
INSERT INTO state (code, name) VALUES ('BR-GO', 'Goiás')
INSERT INTO state (code, name) VALUES ('BR-MA', 'Maranhão')
INSERT INTO state (code, name) VALUES ('BR-MS', 'Mato Grosso do Sul')
INSERT INTO state (code, name) VALUES ('BR-MT', 'Mato Grosso')
INSERT INTO state (code, name) VALUES ('BR-MG', 'Minas Gerais')
INSERT INTO state (code, name) VALUES ('BR-PA', 'Pará')
INSERT INTO state (code, name) VALUES ('BR-PB', 'Paraíba')
INSERT INTO state (code, name) VALUES ('BR-PR', 'Paraná')
INSERT INTO state (code, name) VALUES ('BR-PE', 'Pernambuco')
INSERT INTO state (code, name) VALUES ('BR-PI', 'Piauí')
INSERT INTO state (code, name) VALUES ('BR-RJ', 'Rio de Janeiro')
INSERT INTO state (code, name) VALUES ('BR-RN', 'Rio Grande do Norte')
INSERT INTO state (code, name) VALUES ('BR-RS', 'Rio Grande do Sul')
INSERT INTO state (code, name) VALUES ('BR-RO', 'Rondônia')
INSERT INTO state (code, name) VALUES ('BR-RR', 'Roraima')
INSERT INTO state (code, name) VALUES ('BR-SP', 'São Paulo')
INSERT INTO state (code, name) VALUES ('BR-SC', 'Santa Catarina')
INSERT INTO state (code, name) VALUES ('BR-SE', 'Sergipe')
INSERT INTO state (code, name) VALUES ('BR-TO', 'Tocantins')

INSERT INTO company (id, name, state_code, city, enable) VALUES (1, 'Control', 'BR-SP', 'Santos', 1)

INSERT INTO job_position (id, name, enable) VALUES (1, 'Desenvolvedor', 1)

INSERT INTO employee (id, name, job_position_id, company_id, enable) VALUES (1, 'Emerson',1, 1, 1)
