package com.arquitetura.orientada.servicos;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.arquitetura.orientada.servicos.domain.Cidade;
import com.arquitetura.orientada.servicos.domain.Cliente;
import com.arquitetura.orientada.servicos.domain.Endereco;
import com.arquitetura.orientada.servicos.domain.Estado;
import com.arquitetura.orientada.servicos.domain.ItemPedido;
import com.arquitetura.orientada.servicos.domain.Maquina;
import com.arquitetura.orientada.servicos.domain.Pagamento;
import com.arquitetura.orientada.servicos.domain.PagamentoBoleto;
import com.arquitetura.orientada.servicos.domain.PagamentoCartao;
import com.arquitetura.orientada.servicos.domain.Pedido;
import com.arquitetura.orientada.servicos.domain.Produto;
import com.arquitetura.orientada.servicos.domain.Enums.EstadoPagamento;
import com.arquitetura.orientada.servicos.domain.Enums.TipoCliente;
import com.arquitetura.orientada.servicos.repositories.CidadeRepository;
import com.arquitetura.orientada.servicos.repositories.ClienteRepository;
import com.arquitetura.orientada.servicos.repositories.EnderecoRepository;
import com.arquitetura.orientada.servicos.repositories.EstadoRepository;
import com.arquitetura.orientada.servicos.repositories.ItemPedidoRepository;
import com.arquitetura.orientada.servicos.repositories.MaquinaRepository;
import com.arquitetura.orientada.servicos.repositories.PagamentoRepository;
import com.arquitetura.orientada.servicos.repositories.PedidoRepository;
import com.arquitetura.orientada.servicos.repositories.ProdutoRepository;

@SpringBootApplication
public class SnackMachineApplication implements CommandLineRunner {

	@Autowired
	private MaquinaRepository maquinaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SnackMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Maquina maq1 = new Maquina(null, "Maquina 1", "Piso L1, próximo ao bompreço.");
		Maquina maq2 = new Maquina(null, "Maquina 2", "Estacionamento G2, Setor B4.");
		Maquina maq3 = new Maquina(null, "Maquina 3", "Estacionamento G1, Setor E3.");
		Maquina maq4 = new Maquina(null, "Maquina 4", "Piso L2, próximo ao sanitário masculino.");
		Maquina maq5 = new Maquina(null, "Maquina 5", "Piso L3, Praça de alimentação.");
		
		Produto p1 = new Produto(null, "Sanduíche Natural", "P1SN", 6.00);
		Produto p2 = new Produto(null, "Coockies", "P2CO", 4.00);
		Produto p3 = new Produto(null, "Água Mineral com Gás", "P3AC", 2.50);
		Produto p4 = new Produto(null, "Água Mineral", "P4AS", 2.00);
		Produto p5 = new Produto(null, "Barra de Cereal", "P5BC", 1.50);
		
		maq1.getProdutos().addAll(Arrays.asList(p1, p1, p1, p1, p1, p2, p2, p3, p4, p4, p5, p5, p5));
		maq2.getProdutos().addAll(Arrays.asList(p1, p2, p2, p3, p3, p3, p3, p3, p5, p5));
		maq3.getProdutos().addAll(Arrays.asList(p2, p2, p2, p2, p3, p4, p5));
		maq4.getProdutos().addAll(Arrays.asList(p3, p3, p3, p3, p3, p3, p3, p3, p4, p4, p4, p4, p4));
		maq5.getProdutos().addAll(Arrays.asList(p1, p1, p1, p1, p1));
		
		p1.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq5));
		p2.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq3));
		p3.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq3, maq4));
		p4.getMaquinas().addAll(Arrays.asList(maq1, maq3, maq4));
		p5.getMaquinas().addAll(Arrays.asList(maq1, maq2, maq3));
		
		maquinaRepository.saveAll(Arrays.asList(maq1, maq2, maq3, maq4, maq5));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		Estado est1 = new Estado(null, "Bahia");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "São Paulo", est2);
		Cidade c2 = new Cidade(null, "São Vincente", est2);
		Cidade c3 = new Cidade(null, "Salvador", est1);
		
		est1.getCidades().addAll(Arrays.asList(c3));
		est2.getCidades().addAll(Arrays.asList(c1, c2));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
		
	}

}

