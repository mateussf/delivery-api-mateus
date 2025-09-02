package com.deliverytech.delivery.component;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.deliverytech.delivery.model.ClienteModel;
import com.deliverytech.delivery.model.ProdutoModel;
import com.deliverytech.delivery.model.RestauranteModel;
import com.deliverytech.delivery.repository.IClienteRepository;
import com.deliverytech.delivery.repository.IPedidoRepository;
import com.deliverytech.delivery.repository.IProdutoRepository;
import com.deliverytech.delivery.repository.IRestauranteRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IClienteRepository clienteRepository;

    @Autowired
    private IRestauranteRepository restauranteRepository;

    @Autowired
    private IProdutoRepository produtoRepository;

    @Autowired
    private IPedidoRepository pedidoRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== INICIANDO CARGA DE DADOS DE TESTE ===");

        // Limpar dados existentes
        pedidoRepository.deleteAll();
        produtoRepository.deleteAll();
        restauranteRepository.deleteAll();
        clienteRepository.deleteAll();

        // Inserir dados de teste
        inserirClientes();
        inserirRestaurantes();
        inserirProdutos();
        inserirPedidos();

        // Executar testes das consultas
        testarConsultas();

        System.out.println("=== CARGA DE DADOS CONCLUÍDA ===");
    }

    private void testarConsultas() {
        /*
        System.out.println("\n=== TESTANDO CONSULTAS DOS REPOSITORIES ===");

        // Teste ClienteRepository
        System.out.println("\n--- Testes ClienteRepository ---");

        var clientePorEmail = clienteRepository.findByEmail("joao@email.com");
        System.out.println("Cliente por email: " + (clientePorEmail.isPresent() ? clientePorEmail.get().getNome() : "Não encontrado"));

        var clientesAtivos = clienteRepository.findByAtivoTrue();
        System.out.println("Clientes ativos: " + clientesAtivos.size());

        var clientesPorNome = clienteRepository.findByNomeContainingIgnoreCase("silva");
        System.out.println("Clientes com 'silva' no nome: " + clientesPorNome.size());

        boolean emailExiste = clienteRepository.existsByEmail("maria@email.com");
        System.out.println("Email maria@email.com existe: " + emailExiste);
        */
    }

    private void inserirPedidos() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'inserirPedidos'");
    }

    private void inserirProdutos() {
        ProdutoModel produto1 = new ProdutoModel();
        produto1.setNome("Torresmo");
        produto1.setPreco(new BigDecimal("34.78"));
        produto1.setCategoria("Categoria 1");
        produto1.setDisponivel(true);

        ProdutoModel produto2 = new ProdutoModel();
        produto2.setNome("Toicinho");
        produto2.setPreco(new BigDecimal("16.21"));
        produto2.setCategoria("Categoria 2");
        produto2.setDisponivel(true);

        ProdutoModel produto3 = new ProdutoModel();
        produto3.setNome("Panceta");
        produto3.setPreco(new BigDecimal("10.1"));
        produto3.setCategoria("Categoria 3");
        produto3.setDisponivel(true);


        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
        System.out.println("✓ 3 clientes inseridos");
    }

    private void inserirRestaurantes() {
        /*
        System.out.println("--- Inserindo Restaurantes ---");

        RestauranteModel restaurante1 = new RestauranteModel();
        restaurante1.setNome("Pizza Express");
        restaurante1.setCategoria("Italiana");
        restaurante1.setEndereco("Av. Principal, 100");
        restaurante1.setTelefone("1133333333");
        restaurante1.setTaxaEntrega(new BigDecimal("3.50"));
        restaurante1.setAtivo(true);

        RestauranteModel restaurante2 = new RestauranteModel();
        restaurante2.setNome("Burger King");
        restaurante2.setCategoria("Fast Food");
        restaurante2.setEndereco("Rua Central, 200");
        restaurante2.setTelefone("1144444444");
        restaurante2.setTaxaEntrega(new BigDecimal("5.00"));
        restaurante2.setAtivo(true);

        restauranteRepository.saveAll(Arrays.asList(restaurante1, restaurante2));
        System.out.println("✓ 2 restaurantes inseridos");
        */
    }

    private void inserirClientes() {
        System.out.println("--- Inserindo Clientes ---");

        ClienteModel cliente1 = new ClienteModel();
        cliente1.setNome("João Silva");
        cliente1.setEmail("joao@email.com");
        cliente1.setTelefone("11999999999");
        cliente1.setEndereco("Rua A, 123");
        cliente1.setAtivo(true);

        ClienteModel cliente2 = new ClienteModel();
        cliente2.setNome("Maria Santos");
        cliente2.setEmail("maria@email.com");
        cliente2.setTelefone("11888888888");
        cliente2.setEndereco("Rua B, 456");
        cliente2.setAtivo(true);

        ClienteModel cliente3 = new ClienteModel();
        cliente3.setNome("Pedro Oliveira");
        cliente3.setEmail("pedro@email.com");
        cliente3.setTelefone("11777777777");
        cliente3.setEndereco("Rua C, 789");
        cliente3.setAtivo(false);

        clienteRepository.saveAll(Arrays.asList(cliente1, cliente2, cliente3));
        System.out.println("✓ 3 clientes inseridos");

    }
}