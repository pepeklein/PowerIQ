-- Inserção de dados na tabela 'EMPRESA'
INSERT INTO EMPRESA (Nome_Empresa, CNPJ, Endereco, Setor, Plano) VALUES
('Empresa Solar', '12345678000199', 'Rua das Flores, 123', 'Energia', 'Premium'),
('Eco Energia', '98765432000188', 'Avenida Verde, 456', 'Serviço', 'Gratuito'),
('Soluções Sustentáveis', '11223344556677', 'Praça Central, 789', 'Comércio', 'Premium');

-- Inserção de dados na tabela 'CONSUMO'
INSERT INTO CONSUMO (ID_Empresa, Categoria, Data_Registro, Valor_Consumo, Custo_Consumo) VALUES
(1, 'Iluminação', '2024-01-15', 120.5, 360.75),
(2, 'Ar Condicionado', '2024-01-20', 250.0, 750.00),
(3, 'Máquinas', '2024-01-25', 300.0, 900.00);

-- Inserção de dados na tabela 'FATURA'
INSERT INTO FATURA (ID_Empresa, Mes_Referencia, Valor_Total, Data_Emissao) VALUES
(1, '2024-01-01', 1250.75, '2024-01-10'),
(2, '2024-01-01', 950.50, '2024-01-10'),
(3, '2024-01-01', 1780.00, '2024-01-10');

-- Inserção de dados na tabela 'META'
INSERT INTO META (ID_Empresa, Descricao_Meta, Percentual_Reduzir, Status_Meta) VALUES
(1, 'Reduzir consumo em 10%', 10.0, 'Ativa'),
(2, 'Reduzir custos com iluminação em 15%', 15.0, 'Concluída'),
(3, 'Economizar 20% na conta geral', 20.0, 'Ativa');

-- Inserção de dados na tabela 'NOTIFICACAO'
INSERT INTO NOTIFICACAO (ID_Empresa, Tipo_Notificacao, Data_Envio, Mensagem) VALUES
(1, 'Dica', '2024-11-21 10:30:00', 'Desligue equipamentos fora de uso para economizar energia.'),
(2, 'Alerta', '2024-11-21 15:00:00', 'Consumo de energia acima da meta estipulada!'),
(3, 'Dica', '2024-11-21 18:45:00', 'Utilize lâmpadas de LED para reduzir custos.');

-- Inserção de dados na tabela 'SIMULACAO'
INSERT INTO SIMULACAO (ID_Empresa, Tipo_Energia, Economia_Anual, Custo_Investimento, Retorno_Investimento) VALUES
(1, 'Solar', 15000.50, 75000.00, 60),
(2, 'Eólica', 25000.00, 125000.00, 72),
(3, 'Híbrida', 20000.75, 100000.00, 54);

-- Update na tabela 'EMPRESA'
UPDATE EMPRESA
SET PLANO = 'Gratuito'
WHERE ID = 1;

-- Delete na tabela 'EMPRESA'
DELETE FROM EMPRESA
WHERE ID = 2;

-- Update na tabela 'META'
UPDATE META
SET STATUS_META = 'Concluída'
WHERE ID = 1;

-- Delete na tabela 'META'
DELETE FROM META
WHERE ID = 2;

-- Update na tabela 'FATURA'
UPDATE FATURA
SET VALOR_TOTAL = 400.00
WHERE ID = 1;

-- Delete na tabela 'FATURA'
DELETE FROM FATURA
WHERE ID = 4;
