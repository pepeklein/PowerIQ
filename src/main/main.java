package com.main;

import com.models.Meta;
import com.dao.*;
import com.models.*;

import java.sql.*;
import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmpresaDAO empresaDAO = new EmpresaDAO();
    private static final ConsumoDAO consumoDAO = new ConsumoDAO();
    private static final FaturaDAO faturaDAO = new FaturaDAO();
    private static final MetaDAO metaDAO = new MetaDAO();
    private static final NotificacaoDAO notificacaoDAO = new NotificacaoDAO();
    private static final SimulacaoDAO simulacaoDAO = new SimulacaoDAO();

    public static void main(String[] args) {
        int opcao;
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character
            switch (opcao) {
                case 1:
                    cadastrarEmpresa();
                    break;
                case 2:
                    listarEmpresas();
                    break;
                case 3:
                    cadastrarConsumo();
                    break;
                case 4:
                    listarConsumos();
                    break;
                case 5:
                    cadastrarFatura();
                    break;
                case 6:
                    listarFaturas();
                    break;
                case 7:
                    cadastrarMeta();
                    break;
                case 8:
                    listarMetas();
                    break;
                case 9:
                    cadastrarNotificacao();
                    break;
                case 10:
                    listarNotificacoes();
                    break;
                case 11:
                    cadastrarSimulacao();
                    break;
                case 12:
                    listarSimulacoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Cadastrar Empresa");
        System.out.println("2. Listar Empresas");
        System.out.println("3. Cadastrar Consumo");
        System.out.println("4. Listar Consumos");
        System.out.println("5. Cadastrar Fatura");
        System.out.println("6. Listar Faturas");
        System.out.println("7. Cadastrar Meta");
        System.out.println("8. Listar Metas");
        System.out.println("9. Cadastrar Notificação");
        System.out.println("10. Listar Notificações");
        System.out.println("11. Cadastrar Simulação");
        System.out.println("12. Listar Simulações");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Cadastrar uma nova empresa
    private static void cadastrarEmpresa() {
        System.out.println("\n--- Cadastrar Empresa ---");
        try {
            System.out.print("Nome da Empresa: ");
            String nome = scanner.nextLine();
            System.out.print("CNPJ: ");
            String cnpj = scanner.nextLine();
            System.out.print("Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Setor: ");
            String setor = scanner.nextLine();
            System.out.print("Plano (Gratuito ou Premium): ");
            String plano = scanner.nextLine();

            Empresa empresa = new Empresa(nome, cnpj, endereco, setor, plano);
            empresaDAO.inserir(empresa);
            System.out.println("Empresa cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar empresa: " + e.getMessage());
        }
    }

    // Listar todas as empresas
    private static void listarEmpresas() {
        System.out.println("\n--- Listar Empresas ---");
        try {
            List<Empresa> empresas = empresaDAO.listar();
            for (Empresa empresa : empresas) {
                System.out.println(String.format(
                        "\n\nNome da Empresa: %s\n" +
                                "CNPJ: %s\n" +
                                "Endereço: %s\n" +
                                "Setor: %s\n" +
                                "Plano: %s",
                        empresa.getNomeEmpresa(),
                        empresa.getCnpj(),
                        empresa.getEndereco(),
                        empresa.getSetor(),
                        empresa.getPlano()
                ));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar empresas: " + e.getMessage());
        }
    }

    // Cadastrar um consumo
    private static void cadastrarConsumo() {
        System.out.println("\n--- Cadastrar Consumo ---");
        try {
            System.out.print("ID da Empresa: ");
            int idEmpresa = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            System.out.print("Categoria de Consumo: ");
            String categoria = scanner.nextLine();
            System.out.print("Data de Registro (YYYY-MM-DD): ");
            String dataRegistro = scanner.nextLine();
            System.out.print("Valor do Consumo (kWh): ");
            float valorConsumo = scanner.nextFloat();
            System.out.print("Custo do Consumo (R$): ");
            double custoConsumo = scanner.nextDouble();

            Consumo consumo = new Consumo(categoria, custoConsumo, valorConsumo, dataRegistro, idEmpresa);
            consumoDAO.inserir(consumo);
            System.out.println("Consumo cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar consumo: " + e.getMessage());
        }
    }

    // Listar consumos
    private static void listarConsumos() {
        System.out.println("\n--- Listar Consumos ---");
        try {
            List<Consumo> consumos = consumoDAO.listar();
            for (Consumo consumo : consumos) {
                System.out.println(String.format(
                        "\n\nEmpresa ID: %d\n" +
                                "Categoria de Consumo: %s\n" +
                                "Data de Registro: %s\n" +
                                "Valor do Consumo: %.2f kWh\n" +
                                "Custo do Consumo: R$ %.2f",
                        consumo.getIdEmpresa(),
                        consumo.getCategoria(),
                        consumo.getDataRegistro(),
                        consumo.getValorConsumo(),
                        consumo.getCustoConsumo()
                ));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar consumos: " + e.getMessage());
        }
    }

    // Cadastrar uma fatura
    private static void cadastrarFatura() {
        System.out.println("\n--- Cadastrar Fatura ---");
        try {
            System.out.print("ID da Empresa: ");
            int idEmpresa = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            System.out.print("Mês de Referência (YYYY-MM): ");
            String mesReferencia = scanner.nextLine();
            System.out.print("Valor Total da Fatura (R$): ");
            double valorTotal = scanner.nextDouble();
            System.out.print("Data de Emissão (YYYY-MM-DD): ");
            String dataEmissao = scanner.nextLine();

            Fatura fatura = new Fatura(dataEmissao, valorTotal, mesReferencia, idEmpresa);
            faturaDAO.inserir(fatura);
            System.out.println("Fatura cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar fatura: " + e.getMessage());
        }
    }

    // Listar faturas
    private static void listarFaturas() {
        System.out.println("\n--- Listar Faturas ---");
        try {
            List<Fatura> faturas = faturaDAO.listar();
            for (Fatura fatura : faturas) {
                System.out.println(String.format(
                        "\n\nFatura ID: %d\n" +
                                "Empresa ID: %d\n" +
                                "Mês de Referência: %s\n" +
                                "Valor Total: R$ %.2f\n" +
                                "Data de Emissão: %s",
                        fatura.getIdFatura(),
                        fatura.getIdEmpresa(),
                        fatura.getMesReferencia(),
                        fatura.getValorTotal(),
                        fatura.getDataEmissao()
                ));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar faturas: " + e.getMessage());
        }
    }

    // Cadastrar uma meta
    private static void cadastrarMeta() {
        System.out.println("\n--- Cadastrar Meta ---");
        try {
            System.out.print("ID da Empresa: ");
            int idEmpresa = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            System.out.print("Descrição da Meta: ");
            String descricaoMeta = scanner.nextLine();
            System.out.print("Percentual de Redução: ");
            float percentualReduzir = scanner.nextFloat();
            System.out.print("Status da Meta (Ativa ou Concluída): ");
            String statusMeta = scanner.nextLine();

            Meta meta = new Meta(descricaoMeta, percentualReduzir, statusMeta, idEmpresa);
            metaDAO.inserir(meta);
            System.out.println("Meta cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar meta: " + e.getMessage());
        }
    }

    // Listar metas
    private static void listarMetas() {
        System.out.println("\n--- Listar Metas ---");
        try {
            List<Meta> metas = metaDAO.listar();
            for (Meta meta : metas) {
                System.out.println(String.format(
                        "\n\nMeta ID: %d\n" +
                                "Empresa ID: %d\n" +
                                "Descrição da Meta: %s\n" +
                                "Percentual de Redução: %.2f%%\n" +
                                "Status da Meta: %s",
                        meta.getIdMeta(),
                        meta.getIdEmpresa(),
                        meta.getDescricaoMeta(),
                        meta.getPercentualReduzir(),
                        meta.getStatusMeta()
                ));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar metas: " + e.getMessage());
        }
    }

    // Cadastrar uma notificação
    private static void cadastrarNotificacao() {
        System.out.println("\n--- Cadastrar Notificação ---");
        try {
            System.out.print("ID da Empresa: ");
            int idEmpresa = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            System.out.print("Tipo de Notificação (Dica ou Alerta): ");
            String tipoNotificacao = scanner.nextLine();
            System.out.print("Data de Envio (YYYY-MM-DD HH:MM:SS): ");
            String dataEnvio = scanner.nextLine();
            System.out.print("Mensagem: ");
            String mensagem = scanner.nextLine();

            Notificacao notificacao = new Notificacao(mensagem, tipoNotificacao, dataEnvio, idEmpresa);
            notificacaoDAO.inserir(notificacao);
            System.out.println("Notificação cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar notificação: " + e.getMessage());
        }
    }

    // Listar notificações
    private static void listarNotificacoes() {
        System.out.println("\n--- Listar Notificações ---");
        try {
            List<Notificacao> notificacoes = notificacaoDAO.listar();
            for (Notificacao notificacao : notificacoes) {
                System.out.println(String.format(
                        "\n\nNotificação ID: %d\n" +
                                "Empresa ID: %d\n" +
                                "Tipo de Notificação: %s\n" +
                                "Data de Envio: %s\n" +
                                "Mensagem: %s",
                        notificacao.getIdNotificacao(),
                        notificacao.getIdEmpresa(),
                        notificacao.getTipoNotificacao(),
                        notificacao.getDataEnvio().toString(),
                        notificacao.getMensagem()
                ));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar notificações: " + e.getMessage());
        }
    }

    // Cadastrar uma simulação
    private static void cadastrarSimulacao() {
        System.out.println("\n--- Cadastrar Simulação ---");
        try {
            System.out.print("ID da Empresa: ");
            int idEmpresa = scanner.nextInt();
            scanner.nextLine();  // Consume the newline
            System.out.print("Tipo de Energia: ");
            String tipoEnergia = scanner.nextLine();
            System.out.print("Economia Anual Estimada (R$): ");
            double economiaAnual = scanner.nextDouble();
            System.out.print("Custo do Investimento (R$): ");
            double custoInvestimento = scanner.nextDouble();
            System.out.print("Tempo de Retorno do Investimento (meses): ");
            int retornoInvestimento = scanner.nextInt();

            Simulacao simulacao = new Simulacao(idEmpresa, tipoEnergia, economiaAnual, custoInvestimento, retornoInvestimento);
            simulacaoDAO.inserir(simulacao);
            System.out.println("Simulação cadastrada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar simulação: " + e.getMessage());
        }
    }

    // Listar simulações
    private static void listarSimulacoes() {
        System.out.println("\n--- Listar Simulações ---");
        try {
            List<Simulacao> simulacoes = simulacaoDAO.listar();
            for (Simulacao simulacao : simulacoes) {
                System.out.println(String.format(
                        "\n\nSimulação ID: %d\n" +
                                "Empresa ID: %d\n" +
                                "Tipo de Energia: %s\n" +
                                "Economia Anual Estimada: R$ %.2f\n" +
                                "Custo de Investimento: R$ %.2f\n" +
                                "Tempo de Retorno do Investimento: %d meses",
                        simulacao.getIdSimulacao(),
                        simulacao.getIdEmpresa(),
                        simulacao.getTipoEnergia(),
                        simulacao.getEconomiaAnual(),
                        simulacao.getCustoInvestimento(),
                        simulacao.getRetornoInvestimento()
                ));

            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar simulações: " + e.getMessage());
        }
    }
}
